package controller.command;

import model.entity.Request;
import model.entity.enums.State;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ActionMaster extends AbstractController implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getParameter("dN") != null) {
            int id = Integer.parseInt(request.getParameter("dN"));
            String state = request.getParameter("radio" + id);
            Request req = new Request(id,State.valueOf(state.toUpperCase()));
            requestService.update(req);
            LOGGER.info(State.valueOf(state.toUpperCase())+" successfully updated status of request");
        }

        setPagination(request, List.of(
                State.ACCEPTED.name(),
                State.IN_PROCESS.name()
        ));

        return "/WEB-INF/master/action.jsp";
    }

}
