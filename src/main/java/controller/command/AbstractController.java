package controller.command;

import model.Pagination;
import model.entity.Account;
import model.entity.Request;
import model.service.RequestService;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract class AbstractController {

    RequestService requestService = new RequestService();
    UserService userService = new UserService();

    private int getOffset(HttpServletRequest req, int limit) {
        int result = 0;
        String val = req.getParameter("page");
        if (val != null) {
            int page = Integer.parseInt(val);
            result = (page - 1) * limit;
        }

        return result;
    }

    void setPagination(HttpServletRequest request, List<String> states) {
        int defaultLimit = 12;
        int offset = getOffset(request, defaultLimit);

        Account account = userService.getCurrentAccount(request);
        List<Request> requests = requestService.findWithLimit(offset, defaultLimit, userService.getCurrentAccount(request), states);
        Pagination pagination = new Pagination.Builder(request.getRequestURI() + "?", offset,
                requestService.findSize(account.getEmail(), states)).withLimit(12).build();
        request.setAttribute("pagination", pagination);
        request.setAttribute("list", requests);

    }

}
