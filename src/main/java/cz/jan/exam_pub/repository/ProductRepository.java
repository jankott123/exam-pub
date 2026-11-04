package cz.jan.exam_pub.repository;

import cz.jan.exam_pub.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
