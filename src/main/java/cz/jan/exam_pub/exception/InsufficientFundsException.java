package cz.jan.exam_pub.exception;

import java.math.BigDecimal;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(Long userId, BigDecimal pocket, BigDecimal price) {
        super("User " + userId + " has " + pocket + " but needs " + price);
    }
}
