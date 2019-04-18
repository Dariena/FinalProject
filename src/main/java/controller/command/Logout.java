package controller.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class Logout extends AbstractController implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        Optional<Object> email = Optional.ofNullable(request.getSession().getAttribute("email"));

        email.ifPresent(e -> CommandUtility.unlogUser(request, e.toString()));
        request.getSession().invalidate();
        return "redirect:login";
    }
}
