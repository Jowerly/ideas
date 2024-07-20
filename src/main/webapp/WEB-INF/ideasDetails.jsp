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
    <div class="container">
    <h1 class="mb-4"><c:out value="${idea.title}"></c:out></h1>
    <h2 class="mb-4"><c:out value="${idea.content}"></c:out></h2>
    <h3 class="mb-4">Created By:  <c:out value="${idea.creator.username}"></c:out></h3>
    <h1 class="mb-4">Users who liked your idea: </h1>
    <div class="container">
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
            <tr>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${usersWhoLiked}">
            <tr>
                <td><c:out value="${user.username}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
    </div>
</body>
</html>