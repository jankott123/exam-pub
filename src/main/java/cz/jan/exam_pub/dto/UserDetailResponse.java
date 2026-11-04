package cz.jan.exam_pub.dto;

import cz.jan.exam_pub.entity.User;
import java.math.BigDecimal;
import java.util.List;

public record UserDetailResponse(
        Long id, String name, boolean isActive, boolean isAdult, BigDecimal pocket, List<OrderResponse> orders) {
    public static UserDetailResponse from(User user) {
        return new UserDetailResponse(
                user.getId(),
                user.getName(),
                user.isActive(),
                user.isAdult(),
                user.getPocket(),
                user.getOrders().stream().map(OrderResponse::from).toList());
    }
}
