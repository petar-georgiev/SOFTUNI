package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.User;
import com.example.coffeeshop.model.service.UserServiceModel;
import com.example.coffeeshop.model.view.UserViewModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);


    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    User findById(Long id);


    List<UserViewModel> findAllUsersAndCountOfOrdersOrderByCountDesc();
}
