package cz.jan.exam_pub.service;

import cz.jan.exam_pub.dto.BuyRequest;
import cz.jan.exam_pub.dto.OrderResponse;
import cz.jan.exam_pub.entity.Order;
import cz.jan.exam_pub.entity.Product;
import cz.jan.exam_pub.entity.User;
import cz.jan.exam_pub.exception.*;
import cz.jan.exam_pub.repository.OrderRepository;
import cz.jan.exam_pub.repository.ProductRepository;
import cz.jan.exam_pub.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class BuyService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public BuyService(
            UserRepository userRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderResponse buy(BuyRequest request, String callerUsername) {
        User user = userRepository
                .findByIdForUpdate(request.userId())
                .orElseThrow(() -> new UserNotFoundException(request.userId()));

        if (!user.getUsername().equals(callerUsername)) {
            throw new AccessDeniedException("Prohibited buying drinks for others");
        }
        if (!user.isActive()) {
            throw new InactiveUserException(user.getId());
        }

        Product product = productRepository
                .findById(request.productId())
                .orElseThrow(() -> new ProductNotFoundException(request.productId()));

        if (request.price() != null && request.price().compareTo(product.getPrice()) != 0) {
            throw new PriceMismatchException(request.price(), product.getPrice());
        }
        if (product.isForAdult() && !user.isAdult()) {
            throw new UnderageException(product.getName());
        }

        Order order = new Order(user, product, 1);
        user.pay(order.getTotalPrice());
        orderRepository.save(order);

        return OrderResponse.from(order);
    }
}
