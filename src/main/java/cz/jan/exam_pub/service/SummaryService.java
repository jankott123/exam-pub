package cz.jan.exam_pub.service;

import cz.jan.exam_pub.dto.ProductOrderLine;
import cz.jan.exam_pub.dto.ProductSummaryResponse;
import cz.jan.exam_pub.dto.UserOrderLine;
import cz.jan.exam_pub.repository.OrderRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SummaryService {

    private final OrderRepository orderRepository;

    public SummaryService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductSummaryResponse> getSummaryAll() {
        return orderRepository.findProductSummary();
    }

    @Transactional(readOnly = true)
    public Map<String, List<ProductOrderLine>> getSummaryByProduct() {
        return orderRepository.findAllWithUserAndProduct().stream()
                .collect(Collectors.groupingBy(
                        order -> order.getProduct().getName(),
                        LinkedHashMap::new,
                        Collectors.mapping(ProductOrderLine::from, Collectors.toList())));
    }

    @Transactional(readOnly = true)
    public Map<Long, List<UserOrderLine>> getSummaryByUser() {
        return orderRepository.findAllWithUserAndProduct().stream()
                .collect(Collectors.groupingBy(
                        order -> order.getUser().getId(),
                        LinkedHashMap::new,
                        Collectors.mapping(UserOrderLine::from, Collectors.toList())));
    }
}
