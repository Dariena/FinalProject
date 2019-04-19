package controller.command;

import model.entity.Review;
import model.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class ReviewUser implements Command {
    private ReviewService reviewService = new ReviewService();

    @Override
    public String execute(HttpServletRequest request) {
        String content = request.getParameter("content");
        Review review = new Review(new Date(System.currentTimeMillis()), content);

        if (content == null) {
            LOGGER.debug("User review content is null");
            request.getSession().setAttribute("review", reviewService.show());
            return "/WEB-INF/user/reviewUser.jsp";
        }
        reviewService.create(review, reviewService.getCurrentAccount(request));
        LOGGER.info("New review was successfully created");
        request.getSession().setAttribute("review", reviewService.show());
        return "/WEB-INF/user/reviewUser.jsp";
    }
}
