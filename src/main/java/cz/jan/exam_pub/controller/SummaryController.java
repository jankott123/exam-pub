package cz.jan.exam_pub.controller;

import cz.jan.exam_pub.dto.ProductOrderLine;
import cz.jan.exam_pub.dto.ProductSummaryResponse;
import cz.jan.exam_pub.dto.UserOrderLine;
import cz.jan.exam_pub.service.SummaryService;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/summary")
public class SummaryController {

    private final SummaryService summaryService;

    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping("/all")
    public List<ProductSummaryResponse> getAll() {
        return summaryService.getSummaryAll();
    }

    @GetMapping("/product")
    public Map<String, List<ProductOrderLine>> getByProduct() {
        return summaryService.getSummaryByProduct();
    }

    @GetMapping("/user")
    public Map<Long, List<UserOrderLine>> getByUser() {
        return summaryService.getSummaryByUser();
    }
}
