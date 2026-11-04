package cz.jan.exam_pub.exception;

public class InactiveUserException extends RuntimeException {
    public InactiveUserException(Long userId) {
        super("User " + userId + " is not active");
    }
}
