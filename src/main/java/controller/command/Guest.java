package controller.command;

import controller.AbstractController;

import javax.servlet.http.HttpServletRequest;

public class Guest extends AbstractController implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/guest/guestBase.jsp";
    }
}
