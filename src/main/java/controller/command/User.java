package controller.command;

import javax.servlet.http.HttpServletRequest;

public class User extends AbstractController implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/user/login.jsp";
    }
}
