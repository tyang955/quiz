<%--
  Created by IntelliJ IDEA.
  User: tianhaoyang
  Date: 11/6/23
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>question</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/navbar.jsp" />

<h2>Question Management</h2>

<c:url var="addQuestionUrl" value="/admin/questions/add"/>
<a href="${addQuestionUrl}">Add New Question</a>

<c:forEach var="entry" items="${questionsByCategory}">
    <h3>Category: ${entry.key.name}</h3>
    <table border="1">
        <thead>
        <tr>
            <th>Question ID</th>
            <th>Category</th>
            <th>Description</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="question" items="${entry.value}">
            <tr>
                <td>${question.questionId}</td>
                <td>${entry.key.name}</td>
                <td>${question.description}</td>
                <td>${question.active ? 'Active' : 'Suspended'}</td>
                <td>
                    <c:url var="editUrl" value="/admin/questions/edit/${question.questionId}"/>
                    <a href="${editUrl}">Edit</a> |
                    <c:choose>
                        <c:when test="${question.active}">
                            <c:url var="suspendUrl" value="/admin/questions/suspend/${question.questionId}"/>
                            <a href="${suspendUrl}">Suspend</a>
                        </c:when>
                        <c:otherwise>
                            <c:url var="activateUrl" value="/admin/questions/activate/${question.questionId}"/>
                            <a href="${activateUrl}">Activate</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:forEach>
</body>
</html>
