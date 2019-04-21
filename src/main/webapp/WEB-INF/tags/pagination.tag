<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="pagination" required="true" type="model.Pagination" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/2.3.1/css/bootstrap.min.css">

<c:if test="${pagination != null}">

    <div class="pagination">
        <ul aria-label="Pagination">
            <li>
                <c:choose>
                    <c:when test="${pagination.previous}"><a class="disabled" href="${pagination.previousUrl}" aria-label="Previous">Prev</a></c:when>
                    <c:otherwise><a  href="#">Prev</a></c:otherwise>
                </c:choose>
            </li>

            <c:forEach var="page" items="${pagination.pages }">
                <c:choose>
                    <c:when test="${page.current }"><li class="current active"><a href="#">${page.caption}</a></li></c:when>
                    <c:when test="${page.ellipsis }"><li class="ellipsis"></li></c:when>
                    <c:otherwise><li><a href="${page.url }" aria-label="Page ${page.caption}">${page.caption}</a></li></c:otherwise>
                </c:choose>


            </c:forEach>
            <li>
                <c:choose>
                    <c:when test="${pagination.next}"><a href="${pagination.nextUrl}" aria-label="Next page">Next</a></c:when>
                    <c:otherwise><a class="disabled" href="#">Next</a></c:otherwise>
                </c:choose>
            </li>
        </ul>
    </div>
</c:if>