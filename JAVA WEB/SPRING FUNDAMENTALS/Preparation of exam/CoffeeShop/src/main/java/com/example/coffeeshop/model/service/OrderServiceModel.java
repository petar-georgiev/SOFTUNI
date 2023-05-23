package com.example.coffeeshop.model.service;

import com.example.coffeeshop.model.entity.User;
import com.example.coffeeshop.model.entity.enums.CategoryNameEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {
    private Long id;
    private String description;
    private String name;
    private BigDecimal price;
    private LocalDateTime orderТime;
    private CategoryNameEnum category;
    private User employee;

    public User getEmployee() {
        return employee;
    }

    public OrderServiceModel setEmployee(User employee) {
        this.employee = employee;
        return this;
    }

    public OrderServiceModel() {
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public OrderServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    private User employee_id;

    public Long getId() {
        return id;
    }

    public OrderServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderТime() {
        return orderТime;
    }

    public OrderServiceModel setOrderТime(LocalDateTime orderТime) {
        this.orderТime = orderТime;
        return this;
    }



    public User getEmployee_id() {
        return employee_id;
    }

    public OrderServiceModel setEmployee_id(User employee_id) {
        this.employee_id = employee_id;
        return this;
    }
}
