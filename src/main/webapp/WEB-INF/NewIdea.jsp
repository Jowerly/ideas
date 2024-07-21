<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType= "text/HTML; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Create new idea</h1>
    <form:form action="/ideas/new" modelAttribute="idea" method="POST">
    <form:label path="title">Title: </form:label>
    <form:input path="title"></form:input>
    <form:errors path="title"></form:errors>
    <br><br>
    <form:label path="content">Descripcion: </form:label>
    <form:input path="content"></form:input>    
    <form:errors path="content" style="color: red;"></form:errors>
    <br><br>
    <button type="submit">Create</button>
</form:form>
</body>
</html>