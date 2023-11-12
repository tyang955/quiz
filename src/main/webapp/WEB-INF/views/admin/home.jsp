<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Home</title>
    <style>
        body {

            font-family: 'Arial', sans-serif;
            background-color: #a8d5ba;
            margin: 0;
            padding: 20px;
            color: #333;
        }

        h1 {
            color: #444;
            text-align: center;
            margin-bottom: 50px;
        }

        .nav-link {
            display: block;
            margin: 10px 0;
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            text-align: center;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .nav-link:hover {
            background-color: #0056b3;
        }

        .navbar {
            margin-bottom: 30px;
        }

    </style>
</head>
<body>
<h1>Welcome Admin!</h1>
<jsp:include page="/WEB-INF/views/admin/navbar.jsp" />

<div class="navbar">
    <a class="nav-link" href="/admin/user_management">User Management</a>
</div>
<div class="navbar">
    <a class="nav-link" href="/admin/quiz_result_management">Quiz Result Management</a>
</div>
<div class="navbar">
    <a class="nav-link" href="/admin/question_management">Question Management</a>
</div>
<div class="navbar">
    <a class="nav-link" href="/admin/contact_us_management">Contact Us Management</a>
</div>

</body>
</html>
