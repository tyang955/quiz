<%--
  Created by IntelliJ IDEA.
  User: tianhaoyang
  Date: 11/6/23
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/navbar.jsp" />

<h1>Quiz: ${quizResult.quiz.name}</h1>
<p>User: ${quizResult.user.firstname} ${quizResult.user.lastname}</p>
<p>Start Time: ${quizResult.quiz.timeStart}</p>
<p>End Time: ${quizResult.quiz.timeEnd}</p>
<p>Scores: ${quizResult.score} / 5</p>
<p>Status: ${quizResult.passed ? "Passed" : "Failed"}</p>

<table border="1">
    <thead>
    <tr>
        <th>Question</th>
        <th>Options</th>
        <th>Selected Answer</th>
        <th>Correct Answer</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${quizResult.questionDetails}" var="detail">
        <tr>
            <td>${detail.question.description}</td>
            <td>
                <ul>
                    <c:forEach items="${detail.choices}" var="choice">
                        <li>${choice.description}</li>
                    </c:forEach>
                </ul>
            </td>
            <td>${detail.userSelectedChoice.description}</td>
            <td>${detail.correctChoice.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>



</body>
</html>
