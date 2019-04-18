package controller.command;

import model.entity.Request;
import model.entity.enums.State;

import javax.servlet.http.HttpServletRequest;

public class ActionManager extends AbstractController implements Command {

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
        setPagination(request, State.UNREAD.name());
        //request.setAttribute("request", requestService.showByState(request, State.UNREAD));

        return "/WEB-INF/manager/action.jsp";

    }


}

