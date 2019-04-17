package controller.command;

import model.entity.Review;
import model.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class ReviewUser implements Command {
    ReviewService reviewService = new ReviewService();
    @Override
    public String execute(HttpServletRequest request) {
        String content = request.getParameter("content");
        Review review = new Review();
        review.setContent(content);
        review.setDate(new Date(System.currentTimeMillis()));
        if (content == null) {
            request.getSession().setAttribute("review", reviewService.show());
            return "/WEB-INF/user/reviewUser.jsp";
        }
        reviewService.create(review, reviewService.getCurrentAccount(request));
        request.getSession().setAttribute("review", reviewService.show());
        return "/WEB-INF/user/reviewUser.jsp";
    }
}
