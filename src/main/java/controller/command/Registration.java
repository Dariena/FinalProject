package controller.command;

import model.entity.Account;
import model.entity.enums.Role;
import model.service.UserService;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class Registration extends AbstractController implements Command {

    private UserService userService;


    public Registration(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String firstNameUk = request.getParameter("firstNameUk");
        String surNameUk = request.getParameter("surNameUk");
        String firstNameUa = request.getParameter("firstNameUa");
        String surNameUa = request.getParameter("surNameUa");
        //String role = request.getParameter("role");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        if(firstNameUk==null || surNameUk==null || email == null
                || firstNameUa == null || surNameUa == null){
            return "/registration.jsp";
        }

        Account account = new Account();
        account.setNameUk(firstNameUk);
        account.setSurnameUk(surNameUk);
        account.setNameUa(firstNameUa);
        account.setSurnameUa(surNameUa);
        account.setRole(Role.USER);
        account.setPassword(password);
        account.setEmail(email);
        account.setPhone(phone);
        if (!userService.exists(account)) {
            userService.create(account);
        } else {
            return "/registration.jsp";
        }
        setSession(request.getSession());
        request.getSession().setAttribute("role",account.getRole());
        request.getSession().setAttribute("email",account.getEmail());

        if (! userService.validateData(account)) {
            return "/registration.jsp";
        }

        Optional<Object> roles = Optional.ofNullable(request.getSession().getAttribute("role"));

        return roles.map(o -> "redirect:"+o.toString().toLowerCase()).orElse("redirect:login");
    }
}
