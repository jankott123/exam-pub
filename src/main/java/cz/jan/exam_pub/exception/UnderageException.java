package cz.jan.exam_pub.exception;

public class UnderageException extends RuntimeException {
    public UnderageException(String productName) {
        super("User is not adult, cannot buy " + productName);
    }
}
