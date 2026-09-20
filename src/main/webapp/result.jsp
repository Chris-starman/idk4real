<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalTime" %>

<!DOCTYPE html>
<html>
<head>
    <title>Display Input</title>
</head>
<body>
<h2>Your Input Result</h2>

<%
    // Retrieve the value from the form input named "username"
    String name = request.getParameter("username");
%>
<%
    // New line: Retrieve the clean value passed from the Servlet. THIS LINE IS THE ONE AI LINE IN THIS FILE
    name = (String) request.getAttribute("usernameAttr");
%>
<!-- Print the value using JSP expression tag -->
<p>At <span id="client-time"></span>, <strong><%= name %></strong> logged in.</p>

</body>
<script>
    document.getElementById('client-time').innerText = new Date().toLocaleTimeString();
</script>
</html>
