package cz.jan.exam_pub.service;

import cz.jan.exam_pub.dto.ProductResponse;
import cz.jan.exam_pub.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getDrinkMenu() {
        return productRepository.findAll().stream().map(ProductResponse::from).toList();
    }
}
