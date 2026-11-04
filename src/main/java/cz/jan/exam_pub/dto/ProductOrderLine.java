package cz.jan.exam_pub.dto;

import cz.jan.exam_pub.entity.Order;
import java.math.BigDecimal;

public record ProductOrderLine(Long userId, int amount, BigDecimal price) {
    public static ProductOrderLine from(Order order) {
        return new ProductOrderLine(order.getUser().getId(), order.getAmount(), order.getTotalPrice());
    }
}
