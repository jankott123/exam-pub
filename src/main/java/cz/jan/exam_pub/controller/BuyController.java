package cz.jan.exam_pub.controller;

import cz.jan.exam_pub.dto.BuyRequest;
import cz.jan.exam_pub.dto.OrderResponse;
import cz.jan.exam_pub.service.BuyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyController {

    private final BuyService buyService;

    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }

    @PostMapping("/buy")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse buy(@Valid @RequestBody BuyRequest request, Authentication authentication) {
        return buyService.buy(request, authentication.getName());
    }
}
