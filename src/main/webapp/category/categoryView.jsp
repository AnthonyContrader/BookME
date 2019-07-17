<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.contrader.dto.CategoryDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category View</title>
<%@ include file="/include/header.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %> 
 <% CategoryDTO category = (CategoryDTO) request.getAttribute("category"); %>
 <h2><%= category.getName() %></h2>
 <%@ include file="/include/footer.jsp" %> 
</body>
</html>