<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category View</title>
<%@ include file="/include/header.jsp" %>
</head>
<body>
<%@ include file="/include/navbar.jsp" %> 

<% CategoryDTO c = (CategoryDTO) request.getAttribute("category"); %>
<div class="d-flex">
<p class="h1 mx-auto"><%= c.getName() %></p>
</div>
 <%@ include file="/include/footer.jsp" %> 
</body>
</html>