package com.victor.web.controllers;

import com.victor.web.dao.TaskDAO;
import com.victor.web.dao.TaskDaoImpl;
import com.victor.web.entities.Goal;

import java.util.List;

/**
 * Created by Sonikb on 19.07.2017.
 */
public class ControllerTaskImpl implements Controller {

    private TaskDAO dao = new TaskDaoImpl();

    @Override
    public void add(String task) {
        Goal goal = new Goal();
        goal.setTaskText(task);
        dao.add(goal);
    }

    @Override
    public Goal read(int id) {
        return dao.read(id);
    }

    @Override
    public void delete(Goal goal) {
        dao.delete(goal);
    }

    @Override
    public void update(Goal goal) {
        dao.update(goal);
    }

    @Override
    public List<Goal> readAll() {
        return dao.readAll();
    }
}
