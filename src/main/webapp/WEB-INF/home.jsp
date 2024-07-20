<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType= "text/HTML; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
    <h1>Welcome: ${user.username}</h1>
    <h2>Ideas</h2>
    <a href="/ideas?sort=asc">Low likes</a>
    <a href="/ideas?sort=desc">High likes</a>
    <div class="container">
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <th>Idea</th>
                <th>Created By:</th>
                <th>Likes</th>
                <th>Actions</th>
            </thead>
            <tbody>
                <c:forEach var="idea" items="${ideas}">
                <tr>
                    <td><c:out value="${idea.title}"></c:out></td>
                    <td><c:out value="${idea.creator.username}"></c:out></td>
                    <td><c:out value="${fn:length(idea.usersWhoLiked)}"></c:out></td>
                    <td>
                        <c:choose>
                         <c:when test="${not empty sessionScope.userid and idea.usersWhoLiked.contains(user)}">
                            <form:form action="${pageContext.request.contextPath}/ideas/${idea.id}/like" method="post" class="d-inline">
                                <button type="submit" class="btn btn-secondary">Like</button>   
                            </form:form>
                            </c:when>
                        <c:otherwise>
                            <form:form action="${pageContext.request.contextPath}/ideas/${idea.id}/unlike" method="post" class="d-inline">
                                <button type="submit" class="btn btn-secondary">UnLike</button>   
                            </form:form>                        
                        </c:otherwise>
                    </c:choose>
                        <a href="/ideas/${idea.id}">View</a> 
                        <a href="/ideas/${idea.id}/edit">Edit</a>
                        <form action="/ideas/${idea.id}/delete" method="post" class="d-inline">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <button><a href="/ideas/new"></a>Create an idea</button>
</body>
</html>