package dev.abu.productservice.repositories;

import dev.abu.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {
Optional<Product> findById(Long id);


@Query(" Select p  from Product p inner join Category c where c.title = :category ")
List<Product> findProductByCategory(@Param("category") String category);
}
