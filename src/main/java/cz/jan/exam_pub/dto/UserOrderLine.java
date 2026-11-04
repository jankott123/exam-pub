package cz.jan.exam_pub.dto;

import cz.jan.exam_pub.entity.Order;
import java.math.BigDecimal;

public record UserOrderLine(String product, BigDecimal price) {
    public static UserOrderLine from(Order order) {
        return new UserOrderLine(order.getProduct().getName(), order.getTotalPrice());
    }
}
