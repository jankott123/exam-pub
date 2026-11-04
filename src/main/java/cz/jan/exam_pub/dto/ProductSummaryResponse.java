package cz.jan.exam_pub.dto;

import java.math.BigDecimal;

public record ProductSummaryResponse(String product, Long amount, BigDecimal unitPrice, BigDecimal summaryPrice) {}
