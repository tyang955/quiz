<%--
  Created by IntelliJ IDEA.
  User: tianhaoyang
  Date: 11/5/23
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Score</title>
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

        h3 {
            color: #333;
            text-align: center;
            padding: 20px 0;
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

        .correct {
            color: green;
        }

        .wrong {
            color: red;
        }

        a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #333;
            color: white;
            text-decoration: none;
            text-align: center;
            border-radius: 5px;
            margin: 20px auto;
        }

        a:hover {
            background-color: #555;
        }

        .exit-btn {
            text-align: center;
        }
    </style>
</head>
<body>
<jsp:include page="navbar.jsp" />

<div class="container">
    <h3>Your Score: ${score} out of ${totalQuestions}</h3>

    <table>
        <tr>
            <th>Question No.</th>
            <th>Question</th>
            <th>Your Answer</th>
            <th>Correct Answer</th>
            <th>Status</th>
        </tr>
        <c:forEach var="item" items="${reviewItems}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${item.question.description}</td>
                <td>${item.chosenChoice.description}</td>
                <td>${item.correctChoice.description}</td>
                <td class="${item.correct ? "correct" : "wrong"}">${item.correct ? "Correct" : "Wrong"}</td>
            </tr>
        </c:forEach>
    </table>

    <div class="exit-btn">
        <a href="${pageContext.request.contextPath}/home">Exit</a>
    </div>
</div>
</body>
</html>
