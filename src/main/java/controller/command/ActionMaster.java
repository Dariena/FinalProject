package controller.command;

import model.entity.Request;
import model.entity.enums.State;
import model.service.RequestService;

import javax.servlet.http.HttpServletRequest;

public class ActionMaster implements Command {
    RequestService requestService = new RequestService();

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getParameter("dN") != null) {
            int id = Integer.parseInt(request.getParameter("dN"));
            String state = request.getParameter("radio" + id);
            Request req = new Request();
            req.setId(id);
            req.setAccepted(State.valueOf(state.toUpperCase()));
            requestService.update(req);
        }
        request.setAttribute("request", requestService.showByState(request, State.ACCEPTED));
        return "/WEB-INF/master/action.jsp";
    }

}
