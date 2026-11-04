package cz.jan.exam_pub.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User " + id + " not found");
    }
}
