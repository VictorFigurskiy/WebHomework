package com.victor.web.servlets;

import com.victor.web.controllers.Controller;
import com.victor.web.controllers.ControllerTaskImpl;
import com.victor.web.entities.Goal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sonikb on 18.07.2017.
 */
@WebServlet(name = "TaskDBServlet", urlPatterns = "/servlet", loadOnStartup = 1)
public class TaskServlet extends HttpServlet {
    private Controller controller = new ControllerTaskImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goal> goals = controller.readAll();
        request.setAttribute("goals", goals);
        request.getRequestDispatcher("/todo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String task = request.getParameter("task");
        if (task != null) {
            if (task.length() != 0) {
                controller.add(task);
                response.setStatus(HttpServletResponse.SC_OK);
                doPut(request, response);
            }
        }
        if (task == null) {
            doDelete(request, response);
        }
        doPut(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goal> goals = controller.readAll();
        req.setAttribute("goals", goals);
        req.getRequestDispatcher("/todo.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskForDelete = req.getParameter("taskForDelete");
        int needToDelete = 0;
        List<Goal> goals = new ArrayList<>();
        if (!taskForDelete.isEmpty()) {
            needToDelete = (Integer.parseInt(taskForDelete));
            goals = controller.readAll();
        }
        if (needToDelete >= 1 && needToDelete <= goals.size()) {
            Goal goal = goals.get(needToDelete - 1);
            controller.delete(goal);
        }
        doPut(req, resp);
    }
}
