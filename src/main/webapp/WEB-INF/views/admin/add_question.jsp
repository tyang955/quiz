<%--
  Created by IntelliJ IDEA.
  User: tianhaoyang
  Date: 11/6/23
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <title>Add New Question</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/questions/add" method="POST">
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" required><br>

    <label for="category">Category:</label>
    <select id="category" name="categoryId" required>
        <c:forEach var="category" items="${categories}">
            <option value="${category.categoryId}">${category.name}</option>
        </c:forEach>
    </select><br>

    <c:forEach begin="1" end="4" varStatus="loop">
        <label for="choice${loop.index}">Choice ${loop.index}:</label>
        <input type="text" id="choice${loop.index}" name="choices[${loop.index - 1}].description" required><br>
        <input type="radio" id="correctChoice${loop.index}" name="correctChoice" value="${loop.index - 1}">
        <label for="correctChoice${loop.index}">Correct Answer</label><br>
    </c:forEach>

    <input type="checkbox" id="isActive" name="isActive" value="true">
    <input type="hidden" name="_isActive" value="false"/>
    <label for="isActive">Is Active?</label><br>


    <input type="submit" value="Add Question">
</form>

</body>
</html>
