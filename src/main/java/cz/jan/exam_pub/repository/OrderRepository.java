package cz.jan.exam_pub.repository;

import cz.jan.exam_pub.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}