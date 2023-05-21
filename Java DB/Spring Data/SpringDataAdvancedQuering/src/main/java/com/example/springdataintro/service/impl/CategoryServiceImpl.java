package com.example.springdataintro.service.impl;

import com.example.springdataintro.model.entity.Category;
import com.example.springdataintro.repository.CategoryRepository;
import com.example.springdataintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.springdataintro.filePaths.FilePaths.CATEGORY_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(CATEGORY_FILE_PATH))
                .stream()
                .map(String::trim)
                .filter(row -> !row.isEmpty())
                .forEach(catName -> {
                    Category category = new Category(catName);
                    categoryRepository.save(category);
                });
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        int randInt = ThreadLocalRandom.current().nextInt(1, 3);

        for (int i = 0; i < randInt; i++) {
            long randId = ThreadLocalRandom.current().nextLong(1, categoryRepository.count() + 1);
            Category category = categoryRepository
                    .findById(randId)
                    .orElse(null);
            categories.add(category);
        }

        return categories;
    }
}
