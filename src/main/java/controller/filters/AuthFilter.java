package controller.filters;

import controller.command.CommandUtility;
import model.entity.Account;
import model.entity.enums.Role;
import model.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AuthFilter implements Filter {
    private UserService userService;
    private static final Logger LOGGER = Logger.getLogger(AuthFilter.class);
    private Map<String, String> rolePage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userService = new UserService();
        rolePage = new HashMap<>();
        rolePage.put(Role.USER.name(), "/WEB-INF/user/login.jsp");
        rolePage.put(Role.MANAGER.name(), "/WEB-INF/manager/login.jsp");
        rolePage.put(Role.MASTER.name(), "/WEB-INF/master/login.jsp");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        final String email = request.getParameter("email");
        final String password = request.getParameter("password");

        Optional<Account> account = userService.login(email);

        if (canAuthenticate(account, password)) {
            LOGGER.info("Authentication is successfully");
            loginOrError(request, response, account.get().getEmail());
            setAuthAttributesToSession(request.getSession(),account.get());
            goTo(request, response, account.get().getRole());
        }
        LOGGER.info("Authorization is successfully");
        filterChain.doFilter(servletRequest, servletResponse);

    }

    private boolean canAuthenticate(Optional<Account> account, String password) {
        return  account.isPresent() &&
                password.equals(account.get().getPassword());
    }

    private void setAuthAttributesToSession(HttpSession session, Account account) {
        session.setAttribute("role", account.getRole().name());
        session.setAttribute("email", account.getEmail());

    }

    private void loginOrError(HttpServletRequest request, HttpServletResponse response, String email)
            throws ServletException, IOException {
        if (CommandUtility.cannotLogUser(request, email)) {
            LOGGER.error("Cannot log in, forwarding to jsp");
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    private void goTo(final HttpServletRequest req,
                      final HttpServletResponse response,
                      final Role role) throws ServletException, IOException {
        LOGGER.info("Forwarding to role " + rolePage.get(role.name()));
        req.getRequestDispatcher(rolePage.get(role.name())).forward(req, response);
    }

    @Override
    public void destroy() {

    }

}
