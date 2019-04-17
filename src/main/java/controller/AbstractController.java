package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class AbstractController extends HttpServlet {
    private HttpSession session;

    public HttpSession getSession() {
        return session;
    }
    public void setSession(HttpSession session) {
        this.session = session;
    }

    public final int getOffset(HttpServletRequest req, int limit){
        String val = req.getParameter("page");
        if(val != null){
            int page = Integer.parseInt(val);
            return (page - 1) * limit;
        }else{
            return 0;
        }
    }
}
