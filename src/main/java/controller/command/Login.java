package controller.command;

import model.entity.Account;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

    public class Login extends AbstractController implements Command {

        private Map<String, String> pages = new HashMap<>();
        private UserService userService;

        public Login(UserService userService) {
            this.userService = userService;

            pages.put("login", "/login.jsp");
            pages.put("MANAGER", "redirect:manager");
            pages.put("MASTER", "redirect:master");
            pages.put("USER", "redirect:user");
        }

        @Override
        public String execute(HttpServletRequest request) {
            String email = request.getParameter("email");
            String pass = request.getParameter("password");

            if (email == null || email.equals("") || pass == null || pass.equals("")) {
                return "/login.jsp";
            }

            Optional<Account> account = userService.login(email);


            if (account.isPresent() && pass.equals(account.get().getPassword())) {

                if(CommandUtility.cannotLogUser(request, account.get().getEmail(), account.get().getRole())){
                    return "/WEB-INF/error.jsp";
                }
                request.getSession().setAttribute("role",account.get().getRole().name());
                request.getSession().setAttribute("email", account.get().getEmail());
                return pages.getOrDefault(account.get().getRole().name(), pages.get("login"));
            }

            return "/login.jsp";

        }
    }


