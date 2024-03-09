package dev.abu.productservice.repositories;

import dev.abu.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    Category findByTitle(String title);

    @Query("Select c.title from Category c")
    List<String> findAllCategory();
}
