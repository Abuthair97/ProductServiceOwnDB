package dev.abu.productservice.repositories;

import dev.abu.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    Category findByTitle(String title);
}
