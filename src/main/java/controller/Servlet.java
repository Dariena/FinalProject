package controller;
import controller.command.Command;
import controller.command.ActionManager;
import controller.command.ActionMaster;
import controller.command.ActionUser;
import controller.command.Home;
import controller.command.Logout;
import controller.command.Manager;
import controller.command.Master;
import controller.command.Registration;
import controller.command.ReviewAll;
import controller.command.ReviewUser;
import controller.command.User;
import controller.filters.AuthFilter;
import model.service.UserService;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

public class Servlet extends HttpServlet {

    private HashMap<String, Command> commands = new HashMap<String, Command>();
    private static final Logger LOGGER = Logger.getLogger(AuthFilter.class);

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("loggedUsers", new HashSet<String>());

        commands.put("registration", new Registration(new UserService()));
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
        LOGGER.info("Servlet initialization is successfully");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            LOGGER.info("Redirecting to " + page);
        } else {
            req.getRequestDispatcher(page).forward(req, resp);
        }
    }

    private String getPage(String path, HttpServletRequest req) {
        String result = req.getContextPath();
        Optional<Command> command = Optional.ofNullable(commands.get(path));
        if (command.isPresent()) {
            result = command.get().execute(req);
        }
        LOGGER.debug("Page is " + result);
        return result;
    }
}

