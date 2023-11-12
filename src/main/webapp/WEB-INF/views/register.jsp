<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Registration Form</h2>
<c:if test="${not empty emailError}">
    <div class="error">${emailError}</div>
</c:if>

<form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="user">
    Email: <form:input path="email" />
    First Name: <form:input path="firstname" />
    Last Name: <form:input path="lastname" />
    Password: <form:password path="password" />
    <input type="submit" value="Register">
</form:form>

<p>
    <a href="${pageContext.request.contextPath}/login">Already have an account? Login here.</a>
</p>

</body>
</html>
