package cz.jan.exam_pub.dto;

import cz.jan.exam_pub.entity.User;
import java.math.BigDecimal;

public record UserResponse(Long id, String name, boolean isActive, boolean isAdult, BigDecimal pocket) {
    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getName(), user.isActive(), user.isAdult(), user.getPocket());
    }
}
