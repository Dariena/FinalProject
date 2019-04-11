package controller.command;

import javax.servlet.http.HttpSession;

public abstract class AbstractController {
    private HttpSession session;

    public HttpSession getSession() {
        return session;
    }
    public void setSession(HttpSession session) {
        this.session = session;
    }
}
