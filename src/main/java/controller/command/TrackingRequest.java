package controller.command;

import model.entity.enums.State;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class TrackingRequest extends AbstractController implements Command {
    String email;
    @Override
    public String execute(HttpServletRequest request) {
        String result = "/login.jsp";
        if (request.getSession().getAttributeNames().hasMoreElements()) {
            result = "/WEB-INF/manager/tracking.jsp";
            setPagination(request, List.of(
                    State.READY.name(),
                    State.IN_PROCESS.name()
            ));
            /*email= userService.findByIdEmail(148).get(1);
            request.getSession().setAttribute("email", email);*/
        }

        return result;
    }
}
