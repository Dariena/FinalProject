package controller.command;

import javax.servlet.http.HttpServletRequest;

public class Manager extends AbstractController implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getSession().getAttributeNames().hasMoreElements())
        return "/WEB-INF/manager/login.jsp";
        else
            return "/login.jsp";
    }
}
