package controller.command;

import model.entity.Review;
import model.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Optional;

public class ReviewUser implements Command {
    private ReviewService reviewService = new ReviewService();

    @Override
    public String execute(HttpServletRequest request) {
        Optional<String> content = Optional.ofNullable(request.getParameter("content"));

        if (content.isPresent()) {
            Review review = new Review(new Date(System.currentTimeMillis()), content.get());
            reviewService.create(review, reviewService.getCurrentAccount(request));
            LOGGER.info("New review was successfully created");
            request.getSession().setAttribute("review", reviewService.show());
        } else {
            LOGGER.debug("User review content is null");
            request.getSession().setAttribute("review", reviewService.show());
        }
        return "/WEB-INF/user/reviewUser.jsp";
    }
}
