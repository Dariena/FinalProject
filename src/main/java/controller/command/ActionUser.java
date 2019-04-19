package controller.command;

import model.entity.Request;
import model.entity.enums.State;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class ActionUser extends AbstractController implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String content = request.getParameter("content");
        Date date = new Date(System.currentTimeMillis());
        Request req = new Request(content, date, State.UNREAD, "");

        if (content == null) {
            LOGGER.debug("Request content is null");
            setPagination(request, "*");
            return "/WEB-INF/user/action.jsp";
        }
        requestService.create(req, userService.getCurrentAccount(request));
        LOGGER.info("Request was successfully created");
        setPagination(request, "*");
        return "/WEB-INF/user/action.jsp";


    }

}

