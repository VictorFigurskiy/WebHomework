package com.victor.web.dao;

import com.victor.web.entities.Goal;

import java.util.List;

/**
 * Created by Sonikb on 18.07.2017.
 */
public interface TaskDAO {

    void add(Goal goal);

    Goal read(int id);

    void delete(Goal goal);

    void update(Goal goal);

    List<Goal> readAll();
}
