package cz.jan.exam_pub.exception;

import java.math.BigDecimal;

public class PriceMismatchException extends RuntimeException {
    public PriceMismatchException(BigDecimal sent, BigDecimal actual) {
        super("Price changed: sent " + sent + ", actual " + actual);
    }
}
