<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .navbar {
        background-color: #333;
        overflow: hidden;
        font-family: 'Roboto', sans-serif;
    }

    .navbar a {
        float: left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 20px;
        text-decoration: none;
    }

    .navbar form {
        float: right;
        margin: 0;
        padding: 8px 10px;
    }

    .navbar input[type=submit] {
        padding: 6px 15px;
        margin: 8px 0;
        background: #5cb85c;
        color: white;
        border: none;
        cursor: pointer;
    }

    .navbar a:hover, .navbar input[type=submit]:hover {
        background-color: #ddd;
        color: black;
    }
</style>

<div class="navbar">
    <a href="${pageContext.request.contextPath}/home">Home</a>
    <a href="${pageContext.request.contextPath}/contact">Contact Us</a>
    <form action="${pageContext.request.contextPath}/logout" method="GET">
        <input type="submit" value="Logout">
    </form>
</div>
