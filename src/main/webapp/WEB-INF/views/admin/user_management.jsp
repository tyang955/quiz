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

<table>
    <thead>
    <tr>
        <th>Full Name</th>
        <th>Email</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstname} ${user.lastname}</td>
            <td>${user.email}</td>
            <td>${user.active ? "Active" : "Suspended"}</td>
            <td>
                <c:choose>
                    <c:when test="${user.active}">
                        <a href="${pageContext.request.contextPath}/admin/suspend/${user.u_id}">Suspend</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/admin/activate/${user.u_id}">Activate</a>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
