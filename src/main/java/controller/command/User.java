package controller.command;

import controller.AbstractController;

import javax.servlet.http.HttpServletRequest;

public class User extends AbstractController implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        if (request.getSession().getAttributeNames().hasMoreElements())
            return "/WEB-INF/user/login.jsp";
        else
            return "/login.jsp";
    }
}
