package controller.command;

import model.entity.Account;
import model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;


public class CommandUtility {

    static void unlogUser(HttpServletRequest request, String email) {
        @SuppressWarnings("unchecked")
        HashSet<String> loggedUsers = (HashSet<String>)
                request.getSession().getServletContext().getAttribute("loggedUsers");

        loggedUsers.remove(email);
        request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);

        HttpSession session = request.getSession();

        session.setAttribute("email", null);
        session.setAttribute("role", null);
    }

    public static boolean cannotLogUser(HttpServletRequest request, Account account) {
        @SuppressWarnings("unchecked")
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if (loggedUsers.stream().anyMatch(account.getEmail()::equals)) {
            return true;
        }

        loggedUsers.add(account.getEmail());
        request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);

        HttpSession session = request.getSession();

        session.setAttribute("email", account.getEmail());
        session.setAttribute("role", account.getRole().name());

        return false;
    }


}
