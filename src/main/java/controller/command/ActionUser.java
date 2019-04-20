package controller.command;

import model.entity.Request;
import model.entity.enums.State;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class ActionUser extends AbstractController implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Optional<String> id = Optional.ofNullable(request.getParameter("dN"));
        Optional<String> content = Optional.ofNullable(request.getParameter("content"));

        id.ifPresent(s -> {
            requestService.delete(Integer.valueOf(s));
            LOGGER.info("Request was successfully deleted");
        });
        content.ifPresent(c -> {
            Date date = new Date(System.currentTimeMillis());
            Request req = new Request(c, date, State.UNREAD, "");
            requestService.create(req, userService.getCurrentAccount(request));
            LOGGER.info("Request was successfully created");

        });

        setPagination(request, List.of(
                State.UNREAD.name(),
                State.ACCEPTED.name(),
                State.IN_PROCESS.name(),
                State.READY.name(),
                State.REJECTED.name()
        ));
        return "/WEB-INF/user/action.jsp";
       // String content = request.getParameter("content");
     /*   Date date = new Date(System.currentTimeMillis());
        Request req = new Request(content, date, State.UNREAD, "");

        if (content == null) {
            LOGGER.debug("Request content is null");
            setPagination(request, "*");
            return "/WEB-INF/user/action.jsp";
        }*/

      //  requestService.create(req, userService.getCurrentAccount(request));
      //  LOGGER.info("Request was successfully created");

      //  setPagination(request, "*");
      //  return "/WEB-INF/user/action.jsp";


    }

}

