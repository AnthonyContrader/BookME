<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.contrader.dto.CategoryDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category View</title>
</head>
<body>
 <% CategoryDTO category = (CategoryDTO) request.getAttribute("category"); %>
 <h2><%= category.getName() %></h2>
</body>
</html>