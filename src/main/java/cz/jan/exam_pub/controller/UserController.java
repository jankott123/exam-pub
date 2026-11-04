package cz.jan.exam_pub.controller;

import cz.jan.exam_pub.dto.UserDetailResponse;
import cz.jan.exam_pub.dto.UserResponse;
import cz.jan.exam_pub.service.UserService;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDetailResponse getUser(@PathVariable Long id, Authentication authentication) {
        boolean isBartender = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_BARTENDER"));
        return userService.getUser(id, authentication.getName(), isBartender);
    }
}
