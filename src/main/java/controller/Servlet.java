package controller;

import controller.command.*;
import model.Pagination;
import model.entity.Request;
import model.service.RequestService;
import model.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Servlet extends HttpServlet {

    private HashMap<String, Command> commands = new HashMap<String, Command>();

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("loggedUsers", new HashSet<String>());

        commands.put("registration", new Registration(new UserService()));
        commands.put("login", new Login(new UserService()));
        commands.put("manager", new Manager());
        commands.put("master", new Master());
        commands.put("user", new User());
        commands.put("logout", new Logout());
        commands.put("home", new Home());
        commands.put("action", new ActionUser());
        commands.put("actionManager", new ActionManager());
        commands.put("actionMaster", new ActionMaster());
        commands.put("reviewUser", new ReviewUser());
        commands.put("reviewAll", new ReviewAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // doGet(req, resp);
        processRequest(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String path = req.getRequestURI();
        path = path.replaceAll(".*/app/", "");
        String page = getPage(path, req);
        if (page.contains("redirect")) {
            resp.sendRedirect(page.replace("redirect:", ""));

        } else {
                req.getRequestDispatcher(page).forward(req, resp);
        }

    }

    private String getPage(String path, HttpServletRequest req) {
        Command command = commands.get(path);
        return command.execute(req);
    }
}

