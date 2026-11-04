package cz.jan.exam_pub.entity;

import cz.jan.exam_pub.exception.InsufficientFundsException;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "is_active", nullable = false)
    private boolean active;

    @Column(name = "is_adult", nullable = false)
    private boolean adult;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pocket;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    protected User() {}

    public void pay(BigDecimal amount) {
        if (pocket.compareTo(amount) < 0) {
            throw new InsufficientFundsException(id, pocket, amount);
        }
        pocket = pocket.subtract(amount);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isAdult() {
        return adult;
    }

    public BigDecimal getPocket() {
        return pocket;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
