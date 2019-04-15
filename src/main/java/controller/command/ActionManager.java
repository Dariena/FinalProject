package controller.command;

import javax.servlet.http.HttpServletRequest;

public class ActionManager implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/manager/action.jsp";
    }
}
