package cz.jan.exam_pub.service;

import cz.jan.exam_pub.dto.UserDetailResponse;
import cz.jan.exam_pub.dto.UserResponse;
import cz.jan.exam_pub.entity.User;
import cz.jan.exam_pub.exception.UserNotFoundException;
import cz.jan.exam_pub.repository.UserRepository;
import java.util.List;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(UserResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public UserDetailResponse getUser(Long id, String callerUsername, boolean callerIsBartender) {
        User user = userRepository.findByIdWithOrders(id).orElseThrow(() -> new UserNotFoundException(id));

        if (!callerIsBartender && !user.getUsername().equals(callerUsername)) {
            throw new AccessDeniedException("can be only view your own account");
        }
        return UserDetailResponse.from(user);
    }
}
