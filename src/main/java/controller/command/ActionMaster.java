package controller.command;

import javax.servlet.http.HttpServletRequest;

public class ActionMaster implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/master/action.jsp";
    }
}
