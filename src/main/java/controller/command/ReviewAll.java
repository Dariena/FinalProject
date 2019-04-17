package controller.command;

import model.service.ReviewService;

import javax.servlet.http.HttpServletRequest;

public class ReviewAll implements Command {
    ReviewService reviewService = new ReviewService();
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute("review", reviewService.show());
        return "/viewAll.jsp";
    }
}
