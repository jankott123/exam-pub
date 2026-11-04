package cz.jan.exam_pub.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record BuyRequest(@NotNull Long userId, @NotNull Long productId, BigDecimal price) {}
