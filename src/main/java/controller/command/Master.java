package controller.command;

import javax.servlet.http.HttpServletRequest;

public class Master extends AbstractController implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        if (request.getSession().getAttributeNames().hasMoreElements())
            return "/WEB-INF/master/login.jsp";
        else
            return "/login.jsp";
    }
}
