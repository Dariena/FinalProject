package controller.command;

import controller.AbstractController;
import model.entity.Request;
import model.entity.enums.State;
import model.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class ActionUser implements Command {
    RequestService requestService = new RequestService();


    @Override
    public String execute(HttpServletRequest request) {
        String content = request.getParameter("content");
        Request req = new Request();
        req.setContent(content);
        req.setAccepted(State.UNREAD);
        req.setComment("");
        req.setDate(new Date(System.currentTimeMillis()));
        if (content == null) {
        //    request.setAttribute("request", requestService.show(request));
            return "/WEB-INF/user/action.jsp";
        }
        requestService.create(req, requestService.getCurrentAccount(request));
        //request.setAttribute("request", requestService.show(request));

        return "/WEB-INF/user/action.jsp";


    }

}

