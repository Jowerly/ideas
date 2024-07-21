<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType= "text/HTML; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <div>
    <h1>Edit Idea</h1>
        <form:form action="${pageContext.request.contextPath}/ideas/${idea.id}/edit" modelAttribute="idea" method="POST">
            <div class="mb-3">
                <form:label path="title" class="form-label"></form:label>
                <form:input path="title" id="title" class="form-control" value="${idea.title}"></form:input>
            </div>
        <div class="mb-3">
            <form:label path="content"></form:label>
            <form:input path="content" id="content" class="form-control" value="${idea.content}"></form:input>
        </div>
        <button type="submit">Guardar cambios</button>
        </form:form>   
        <form method="post" action="${pageContext.request.contextPath}/ideas/${idea.id}/delete" style="display:inline;">
            <button type="submit" onclick="return confirm('Are you sure you want to delete this idea?');">Delete Idea</button>
        </form>
</div>
</body>
</html>