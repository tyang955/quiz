<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap');

        body, html {
            margin: 0;
            padding: 0;
            font-family: 'Roboto', sans-serif;
            background: #f7f7f7;
        }

        h2 {
            text-align: center;
            color: #333;
            margin: 20px 0;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            background: #fff;
            margin: 5px 15%;
            padding: 10px;
            border-radius: 5px;
            text-align: center;
        }

        li a {
            text-decoration: none;
            color: #5cb85c;
            font-weight: 500;
        }

        li a:hover {
            text-decoration: underline;
        }

        table {
            width: 70%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            color: #5cb85c;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<jsp:include page="navbar.jsp" />

<div class="content">
    <h2>Quiz Categories</h2>
    <ul>
        <c:forEach items="${categories}" var="category">
            <li>
                <a href="/startQuiz/${category.categoryId}">${category.name}</a>
            </li>
        </c:forEach>
    </ul>

    <h2>Recent Quiz Results</h2>
    <table>
        <thead>
        <tr>
            <th>Quiz Name</th>
            <th>Date Taken</th>
            <th>Result</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${quizzes}" var="quiz">
            <tr>
                <td>${quiz.name}</td>
                <td>${quiz.timeEnd}</td>
                <td><a href="result/${quiz.quizId}">View Result</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
