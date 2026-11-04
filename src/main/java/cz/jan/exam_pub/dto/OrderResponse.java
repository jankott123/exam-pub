package cz.jan.exam_pub.dto;

import cz.jan.exam_pub.entity.Order;
import java.math.BigDecimal;

public record OrderResponse(Long id, String productName, int amount, BigDecimal price) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(order.getId(), order.getProduct().getName(), order.getAmount(), order.getTotalPrice());
    }
}
