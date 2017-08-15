package com.victor.web.servlets;

import com.victor.web.entities.Goal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sonikb on 21.07.2017.
 */

public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goalFromRadio = request.getParameter("goalFromRadio");
        HttpSession session = request.getSession();
        if (session.getAttribute("goals") == null) {
            session.setAttribute("goals", new ArrayList<Goal>());
        }
        List<Goal> goalList = (List<Goal>) session.getAttribute("goals");
        if (goalList != null) {
            for (Goal goal : goalList) {
                if (goal.getTaskText().equals(goalFromRadio)) {
                    goal.setFlag(true);
                }
            }
        }
        request.getRequestDispatcher("/sessionWork.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        if (session.getAttribute("goals") == null) {
            session.setAttribute("goals", new ArrayList<Goal>());
        }
        List<Goal> goalList = (List<Goal>) session.getAttribute("goals");
        String task = req.getParameter("task");

        if (task != null) {
            if (task.length() != 0) {
                Goal goal = new Goal();
                goal.setTaskText(task);
                goalList.add(goal);
                session.setAttribute("goals", goalList);
                doPut(req, resp);
            }
        }
        if (task == null) {
            doDelete(req, resp);
        }
        doPut(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/sessionWork.jsp").forward(req, resp);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Goal> goals = (List<Goal>) session.getAttribute("goals");
        String textTaskForDelete = req.getParameter("taskForDelete");
        if (textTaskForDelete.length() != 0) {
            int taskForDelete = Integer.parseInt(textTaskForDelete);
            if (taskForDelete >= 1 && taskForDelete <= goals.size()) {
                goals.remove(taskForDelete - 1);
            }
        }
        session.setAttribute("goals", goals);
        doPut(req, resp);
    }
}
