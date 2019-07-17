<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, it.contrader.dto.CategoryDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category List</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div>
	<% List<CategoryDTO> list = (List<CategoryDTO>) request.getAttribute("categories"); %>
	<table>
		<% for(CategoryDTO c : list){ %>
		<tr>
			<td>
				<a href="/Category/categoryRead?id=<%=c.getIdCategory()%>"><%= c.getName() %></a>
			</td>
			<td>
				<a href="/Category/categoryUpdate?id=<%=c.getIdCategory()%>">Edit</a>
			</td>
			<td>
				<a href="/Category/categoryDelete?id=<%=c.getIdCategory()%>">Remove</a>
			</td>
		</tr>
		<% } %>
	</table>
	</div>
	<div>
	<form action="/Category/categoryInsert" method="post">
		<input type="text" name="categoryName">
		<button type="submit">Add</button>
	</form>
	</div>
	
</body>
</html>