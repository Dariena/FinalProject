package controller.command;

import model.Pagination;
import model.entity.Account;
import model.entity.Request;
import model.service.RequestService;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public abstract class AbstractController {
    private HttpSession session;

    RequestService requestService = new RequestService();
    UserService userService =new UserService();

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    private final int getOffset(HttpServletRequest req, int limit) {
        String val = req.getParameter("page");
        if (val != null) {
            int page = Integer.parseInt(val);
            return (page - 1) * limit;
        } else {
            return 0;
        }
    }

    protected void setPagination(HttpServletRequest request, String state) {
        int defaultLimit = 10;
        int offset = getOffset(request, defaultLimit);

        Account account = userService.getCurrentAccount(request);
        List<Request> requests;
        Pagination pagination;
        requests = requestService.findWithLimit(offset, defaultLimit, userService.getCurrentAccount(request), state);
        pagination = new Pagination
                .Builder(request.getRequestURI() + "?", offset,
                requestService.findSize(account.getEmail(), state))
                .withLimit(10).build();
        request.setAttribute("pagination", pagination);
        request.setAttribute("list", requests);

    }

}
