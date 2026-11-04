package cz.jan.exam_pub.controller;

import cz.jan.exam_pub.dto.ProductResponse;
import cz.jan.exam_pub.service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrinkMenuController {

    private final ProductService productService;

    public DrinkMenuController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/drink-menu")
    public List<ProductResponse> getDrinkMenu() {
        return productService.getDrinkMenu();
    }
}
