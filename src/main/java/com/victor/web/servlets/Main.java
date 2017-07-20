package com.victor.web.servlets;

import com.victor.web.controllers.Controller;
import com.victor.web.controllers.ControllerTaskImpl;
import com.victor.web.entities.Goal;

/**
 * Created by Sonikb on 19.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerTaskImpl();
        controller.add("damn");
    }
}
