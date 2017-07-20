package com.victor.web.controllers;

import com.victor.web.entities.Goal;

import java.util.List;

/**
 * Created by Sonikb on 19.07.2017.
 */
public interface Controller {

    void add(String task);

    Goal read(int id);

    void delete(Goal goal);

    void update(Goal goal);

    List<Goal> readAll();
    
}
