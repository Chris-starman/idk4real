<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>User Input Form</title>
</head>
<body>
<h2>Enter Your Name</h2>
<!-- The form sends data result.jsp using POST -->
<form action="result.jsp" method="POST">
    <form action="process" method="POST">
    <label for="username">Name:</label>
    <input type="text" id="username" name="username">
    <input type="submit" value="Submit">
    </form>
</form>
</body>
</html>