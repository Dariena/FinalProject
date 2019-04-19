package controller.filters;

import controller.command.CommandUtility;
import model.entity.Account;
import model.entity.enums.Role;
import model.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class AuthFilter implements Filter {
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userService = new UserService();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        final String email = request.getParameter("email");
        final String password = request.getParameter("password");

        Optional<Account> account = userService.login(email);

        if (account.isPresent() && password.equals(account.get().getPassword())) {
            if(CommandUtility.cannotLogUser(request, account.get().getEmail(), account.get().getRole())){
                request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            }
            request.getSession().setAttribute("role",account.get().getRole().name());
            request.getSession().setAttribute("email", account.get().getEmail());
            goTo(request, response, account.get().getRole());
        }
        filterChain.doFilter(servletRequest, servletResponse);


    }

    private void goTo(final HttpServletRequest req,
                 final HttpServletResponse response,
                 final Role role) throws ServletException, IOException {
        Map<String, String> rolePage = new HashMap<>();
        rolePage.put(Role.USER.name(), "/WEB-INF/user/login.jsp");
        rolePage.put(Role.MANAGER.name(), "/WEB-INF/manager/login.jsp");
        rolePage.put(Role.MASTER.name(), "/WEB-INF/master/login.jsp");

        req.getRequestDispatcher(rolePage.get(role.name())).forward(req, response);
    }

    @Override
    public void destroy() {

    }

}
