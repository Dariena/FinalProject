package controller.command;

import model.Pagination;
import model.dao.AccountDao;
import model.dao.DaoFactory;
import model.entity.Account;
import model.entity.Request;
import model.entity.enums.State;
import model.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ActionManager implements Command {
    RequestService requestService = new RequestService();


    @Override
    public String execute(HttpServletRequest request) {
        if (request.getParameter("dN") != null) {
            int id = Integer.parseInt(request.getParameter("dN"));
            String comment = request.getParameter("comment");
            String state = request.getParameter("radio" + id);

            Request req = new Request();
            req.setId(id);
            req.setAccepted(State.valueOf(state.toUpperCase()));
            req.setComment(comment);
            requestService.update(req);

        }

        request.setAttribute("request", requestService.showByState(request, State.UNREAD));

        return "/WEB-INF/manager/action.jsp";

    }


}

