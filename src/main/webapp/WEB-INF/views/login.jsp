<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap');

        body, html {
            height: 100%;
            margin: 0;
            font-family: 'Roboto', sans-serif;
        }

        .bg {
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
            height: 100%;
            filter: blur(8px);
            -webkit-filter: blur(8px);
        }

        .login-container {
            background-color: rgba(255, 255, 255, 0.9);
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 340px;
            text-align: center;
        }

        .login-container h2 {
            margin-bottom: 20px;
            font-weight: 500;
        }

        input[type=email], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 20px 0;
            border: none;
            background: #f1f1f1;
            border-radius: 4px;
        }

        input[type=submit] {
            border: none;
            padding: 15px;
            width: 100%;
            background-color: #5cb85c;
            color: #fff;
            border-radius: 4px;
            cursor: pointer;
            font-weight: 500;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .login-container p {
            margin-top: 20px;
        }

        .login-container a {
            text-decoration: none;
            color: #5cb85c;
        }

        .login-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="bg"></div>
<div class="login-container">
    <h2>Welcome Back!</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="email" id="email" name="email" placeholder="Email Address" required>
        <input type="password" id="password" name="password" placeholder="Password" required>
        <input type="submit" value="Login">
    </form>
    <p>Don't have an account? <a href="${pageContext.request.contextPath}/register">Register here</a></p>
</div>

</body>
</html>
