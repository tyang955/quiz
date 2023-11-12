<%--
  Created by IntelliJ IDEA.
  User: tianhaoyang
  Date: 11/6/23
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Contact</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/navbar.jsp" />

<h1>Contact Us Messages</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Subject</th>
        <th>Email</th>
        <th>Time</th>
        <th>Message</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${contacts}" var="contact">
        <tr>
            <td>${contact.contactId}</td>
            <td>${contact.subject}</td>
            <td>${contact.email}</td>
            <td>${contact.time}</td>
            <td>${contact.message}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
