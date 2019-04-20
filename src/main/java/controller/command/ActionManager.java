package controller.command;

import model.entity.Request;
import model.entity.enums.State;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class ActionManager extends AbstractController implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Optional<String> id = Optional.ofNullable(request.getParameter("dN"));
        id.ifPresent(s -> {
            String comment = request.getParameter("comment");
            String state = request.getParameter("radio" + id.get());
            Request req = new Request(Integer.valueOf(id.get()), State.valueOf(state.toUpperCase()), comment);
            requestService.update(req);
            LOGGER.info(State.valueOf(state.toUpperCase()) + " successfully change status of request");

        });

        setPagination(request, List.of(State.UNREAD.name()));

        return "/WEB-INF/manager/action.jsp";
    }
}

