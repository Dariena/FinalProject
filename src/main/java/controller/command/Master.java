package controller.command;

import javax.servlet.http.HttpServletRequest;

public class Master extends AbstractController implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String result = "/login.jsp";
        if (request.getSession().getAttributeNames().hasMoreElements())
            result = "/WEB-INF/master/login.jsp";
        return result;
    }
}
