<%--
  Created by IntelliJ IDEA.
  User: tianhaoyang
  Date: 11/6/23
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
  .navbar {
    overflow: hidden;
    padding: 0 10px;
  }

  .navbar a {
    float: left;
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
  }

  .navbar form {
    float: right;
  }

  .navbar input[type="submit"] {
    padding: 10px 20px;
    margin: 8px 0;
    border: none;
    background-color: #f44336;
    color: white;
    cursor: pointer;
  }

  .navbar input[type="submit"]:hover {
    background-color: #c0392b;
  }
</style>
<div class="navbar">
  <a href="${pageContext.request.contextPath}/admin/home">Home</a>
  <form action="${pageContext.request.contextPath}/logout" method="GET">
    <input type="submit" value="Logout">
  </form>
</div>
