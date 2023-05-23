package com.example.pathfinder.service;

import com.example.pathfinder.model.service.RouteServiceModel;
import com.example.pathfinder.model.view.RouteDetailsViewModel;
import com.example.pathfinder.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();

    void addNewRoute(RouteServiceModel routeServiceModel);

    void deleteItem(Long id);

    RouteDetailsViewModel findRouteById(Long id);
}
