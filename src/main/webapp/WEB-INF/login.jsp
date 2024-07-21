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
    <h1>Register</h1>
    <form:form action="/user/new" modelAttribute="user" method="POST">
    <form:label path="username">Username: </form:label>
    <form:input path="username" type="text"></form:input>
    <form:errors path="username" style="color: red;"></form:errors>
    <br><br>
    <form:label path="email">Email: </form:label>
    <form:input path="email" type="email"></form:input>
    <form:errors path="email" style="color: red;"></form:errors>
    <br><br>
    <form:label path="password">Pasword: </form:label>
    <form:input path="password" type="password"></form:input>
    <form:errors path="password" style="color: red;"></form:errors>
    <br><br>
    <form:label path="passwordConfirmation">Password Confirmation: </form:label>
    <form:input path="passwordConfirmation" type="password"></form:input>
    <form:errors path="passwordConfirmation" style="color: red;"> </form:errors>
    <br><br>
    <button type="submit">Crear usuario</button>
    </form:form>
    <h1>Login</h1>
    <form:form action="/user/login" modelAttribute="user" method="POST">
    <form:label path="email">Email: </form:label>
    <form:input path="email" type="email"></form:input>
    <form:errors path="email" style="color: red;"></form:errors>
    <br><br>
    <form:label path="password">Password: </form:label>
    <form:input path="password" type="password"></form:input>
    <form:errors path="password" style="color: red;"></form:errors>
    <br><br>
    <button type="submit">Login</button>
    </form:form>
</body>
</html>