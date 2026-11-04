package cz.jan.exam_pub.repository;

import cz.jan.exam_pub.dto.ProductSummaryResponse;
import cz.jan.exam_pub.entity.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("""
        SELECT new cz.jan.exam_pub.dto.ProductSummaryResponse(
            p.name, SUM(o.amount), p.price, SUM(o.unitPrice * o.amount))
        FROM Order o JOIN o.product p
        GROUP BY p.id, p.name, p.price
        ORDER BY p.name
        """)
    List<ProductSummaryResponse> findProductSummary();

    @Query("SELECT o FROM Order o JOIN FETCH o.user JOIN FETCH o.product ORDER BY o.id")
    List<Order> findAllWithUserAndProduct();
}
