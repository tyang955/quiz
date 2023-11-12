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
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }

        h1, p {
            color: #333;
            text-align: center;
            padding: 10px 0;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            padding: 5px 0;
        }

        .status-passed {
            color: green;
        }

        .status-failed {
            color: red;
        }

        .back-home {
            display: inline-block;
            padding: 10px 20px;
            background-color: #333;
            color: white;
            text-decoration: none;
            text-align: center;
            border-radius: 5px;
            margin: 20px auto;
        }

        .back-home:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
<jsp:include page="navbar.jsp" />

<div class="container">
    <h1>Quiz: ${quizResult.quiz.name}</h1>
    <p>User: ${quizResult.user.firstname} ${quizResult.user.lastname}</p>
    <p>Start Time: ${quizResult.quiz.timeStart}</p>
    <p>End Time: ${quizResult.quiz.timeEnd}</p>
    <p>Status: <span class="${quizResult.passed ? "status-passed" : "status-failed"}">${quizResult.passed ? "Passed" : "Failed"}</span></p>

    <table>
        <thead>
        <tr>
            <th>Question</th>
            <th>Options</th>
            <th>Your Answer</th>
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

    <div class="back-home">
        <a href="${pageContext.request.contextPath}/home">Back Home</a>
    </div>
</div>

</body>
</html>
