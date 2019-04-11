package controller.listeners;


import model.dao.DaoFactory;
import model.entity.Account;
import model.entity.Review;
import model.service.ReviewService;
import model.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext = servletContextEvent.getServletContext();

        UserService userService = new UserService();



    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
