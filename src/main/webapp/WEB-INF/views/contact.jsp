<%--
  Created by IntelliJ IDEA.
  User: tianhaoyang
  Date: 11/6/23
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="navbar.jsp" />

<h1>Contact Us</h1>
<c:if test="${param.success}">
    <p>Message sent successfully!</p>
</c:if>

<form:form modelAttribute="message" action="/contact" method="post">
    <div>
        <label>Subject:</label>
        <form:input path="subject" required="true"/>
    </div>
    <div>
        <label>Email:</label>
        <form:input path="email" required="true"/>
    </div>
    <div>
        <label>Message:</label>
        <form:textarea path="message" required="true"/>
    </div>
    <div>
        <button type="submit">Send</button>
    </div>
</form:form>

</body>
</html>
