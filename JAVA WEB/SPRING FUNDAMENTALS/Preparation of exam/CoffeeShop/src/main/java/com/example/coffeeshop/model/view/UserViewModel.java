package com.example.coffeeshop.model.view;

import com.example.coffeeshop.model.entity.Order;
import com.example.coffeeshop.model.entity.User;

import java.util.List;

public class UserViewModel {
  private String username;
  private Integer countOrders;

    public UserViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getCountOrders() {
        return countOrders;
    }

    public UserViewModel setCountOrders(Integer countOrders) {
        this.countOrders = countOrders;
        return this;
    }
}
