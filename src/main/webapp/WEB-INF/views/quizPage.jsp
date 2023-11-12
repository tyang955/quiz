<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>QuizPage</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .quiz-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            width: 90%;
            max-width: 600px;
        }
        h3 {
            color: #333;
        }
        .choice-label {
            display: block;
            background-color: #f9f9f9;
            border: 2px solid #ddd;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
            cursor: pointer;
        }
        .choice-label:hover {
            background-color: #e9e9e9;
        }
        .choice-label input[type="radio"] {
            margin-right: 10px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #5cb85c;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>

<div class="quiz-container">
    <form action="${currentQuestionIndex == (questions.size() - 1) ? '/submitQuiz' : '/nextQuestion'}" method="post">
        <input type="hidden" name="currentQuestionIndex" value="${currentQuestionIndex}" />
        <input type="hidden" name="currentQuestionId" value="${questions[currentQuestionIndex].questionId}" />

        <h3>${questions[currentQuestionIndex].description}</h3>

        <c:forEach items="${questions[currentQuestionIndex].choices}" var="choice">
            <label class="choice-label">
                <input type="radio" name="selectedChoice" value="${choice.choiceId}" />
                    ${choice.description}
            </label>
        </c:forEach>

        <input type="submit" value="${currentQuestionIndex == (questions.size() - 1) ? 'Submit Quiz' : 'Next'}" />
    </form>
</div>

</body>
</html>
