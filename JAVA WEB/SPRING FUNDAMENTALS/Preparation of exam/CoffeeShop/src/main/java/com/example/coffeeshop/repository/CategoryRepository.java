package com.example.coffeeshop.repository;
import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<com.example.coffeeshop.model.entity.Category, Long> {

    Optional<Category> findByCategory(CategoryNameEnum name);
}
