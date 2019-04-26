package controller.filters;

import org.apache.log4j.Logger;
import javax.servlet.*;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class LocalizeFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(LocalizeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        setLangBundle(servletRequest);
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("Localize Filter is successfully");
    }

    @Override
    public void destroy() {

    }

    private void setLangBundle(ServletRequest req) {
        String lang = req.getParameter("lang");

        if (!Optional.ofNullable(lang).isPresent()) {
            lang = "en_uk";
        }
        String[] langParsed = lang.split("_");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("language", new Locale(langParsed[0], langParsed[1]));
        req.setAttribute("langBundle", resourceBundle);

    }
}
