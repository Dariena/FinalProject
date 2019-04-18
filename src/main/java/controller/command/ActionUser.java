package controller.command;

import model.entity.Request;
import model.entity.enums.State;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class ActionUser extends AbstractController implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String content = request.getParameter("content");
        Request req = new Request();
        req.setContent(content);
        req.setAccepted(State.UNREAD);
        req.setComment("");
        req.setDate(new Date(System.currentTimeMillis()));

        if (content == null) {
            setPagination(request, "*");
        //  request.setAttribute("request", requestService.show(request));
            return "/WEB-INF/user/action.jsp";
        }
        requestService.create(req, requestService.getCurrentAccount(request));
        //request.setAttribute("request", requestService.show(request));
        setPagination(request, "*");
        return "/WEB-INF/user/action.jsp";


    }

}

