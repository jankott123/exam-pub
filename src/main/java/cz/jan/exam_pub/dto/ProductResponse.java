package cz.jan.exam_pub.dto;

import cz.jan.exam_pub.entity.Product;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String productName,
        BigDecimal price,
        boolean isForAdult
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.isForAdult()
        );
    }
}