<%--
  Created by IntelliJ IDEA.
  User: tianhaoyang
  Date: 11/7/23
  Time: 3:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Edit Question</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/navbar.jsp" />

<h2>Edit Question</h2>

<c:url var="editActionUrl" value="/admin/questions/edit/${question.questionId}" />


<form:form action="${editActionUrl}" method="POST" modelAttribute="question">
    <form:hidden path="questionId"/>
    <table>
        <tr>
            <td>Description:</td>
            <td><form:textarea path="description" rows="5" cols="30"/></td>
        </tr>
        <tr>
            <td>Status:</td>
            <td>
                <form:radiobutton path="active" value="true"/> Active
                <form:radiobutton path="active" value="false"/> Suspended
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update Question"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

