package controller.command;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Logger LOGGER = Logger.getLogger(Command.class);

    String execute(HttpServletRequest request);
}
