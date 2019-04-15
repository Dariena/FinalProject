package controller.command;

import model.entity.Request;
import model.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActionUser implements Command {
    RequestService requestService = new RequestService();


    @Override
    public String execute(HttpServletRequest request) {
        String content = request.getParameter("content");
        Request req = new Request();
        req.setContent(content);
        req.setAccepted(false);
        req.setComment("");
        req.setDate(new Date(System.currentTimeMillis()));
        if (content == null) {
            return "/WEB-INF/user/action.jsp";
        }
        requestService.create(req);

        return "/WEB-INF/user/action.jsp";


    }
}

