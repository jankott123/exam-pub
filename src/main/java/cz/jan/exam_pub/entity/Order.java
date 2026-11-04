package cz.jan.exam_pub.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private int amount;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    protected Order() {}

    public Order(User user, Product product, int amount) {
        this.user = user;
        this.product = product;
        this.amount = amount;
        this.unitPrice = product.getPrice();
        this.createdAt = LocalDateTime.now();
    }

    public BigDecimal getTotalPrice() {
        return unitPrice.multiply(BigDecimal.valueOf(amount));
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
