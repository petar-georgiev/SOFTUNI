package com.example.coffeeshop.model.entity;


import com.example.coffeeshop.model.entity.enums.CategoryNameEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "categories")
public class Category extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum category;
    @Column(nullable = false)
    private Integer neededTime;

    public Category() {
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public Category setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
