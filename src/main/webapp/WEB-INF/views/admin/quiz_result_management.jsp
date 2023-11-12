<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quiz Result Management</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/navbar.jsp" />

<form action="/admin/quiz_result_management" method="get">
    <!-- Category: <select name="category">
        <option value="cat1">Category 1</option>
        <option value="cat2">Category 2</option>
    </select> -->

    <!-- User: <select name="user">
        <option value="user1">User 1</option>
        <option value="user2">User 2</option>
    </select> -->

    <input type="submit" value="Filter Results">
</form>

<table border="1">
    <thead>
    <tr>
        <th>Taken Time</th>
        <th>Category (Placeholder)</th>
        <th>User Full Name</th>
        <th>No. of Questions</th>
        <th>Score</th>
        <th>Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="quizResult" items="${quizzes}">
        <tr>
            <td>${quizResult.quiz.timeStart}</td>
            <td>Category Name</td>
            <td>${quizResult.user.firstname} ${quizResult.user.lastname}</td>
            <td><c:out value="${quizResult.questionDetails.size()}"/></td>
            <td>${quizResult.score}</td>
            <td><a href="/admin/quiz_details/${quizResult.quiz.quizId}">View Details</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
