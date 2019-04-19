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

            Request req = new Request(id,State.valueOf(state.toUpperCase()),comment);
            requestService.update(req);
            LOGGER.info(State.valueOf(state.toUpperCase())+ " successfully change status of request");

        }
        setPagination(request, State.UNREAD.name());

        return "/WEB-INF/manager/action.jsp";

    }


}

