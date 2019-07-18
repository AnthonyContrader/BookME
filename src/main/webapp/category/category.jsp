<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, it.contrader.dto.CategoryDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category List</title>
<%@ include file="/include/header.jsp" %>
</head>
<style type="text/css">
	
	#mycont{
		max-width: 500px;
	}
</style>
<body>
<%@ include file="/include/navbar.jsp" %> 
    <script type="text/javascript">
		function getNewName(){
			var name = prompt("Enter a new category name:","new name");
			var arr = document.querySelectorAll(".newName");
			for (var i = 0; i < arr.length; i++) {
				  arr[i].value = name;
				}
		}
	</script>
	
	<h1 class="display-4 text-center">Category List</h1>
	
	<div class="container-fluid" id="mycont">
		<% for(CategoryDTO c : list){ %>
		<div class="row justify-content-md-center shadow-sm p-1 m-1 bg-white rounded">
			<div class="col">
				<a href="/Category/categoryRead?id=<%=c.getIdCategory()%>"><%= c.getName() %></a>
			</div>
			<div class="col">
				<form action="/Category/categoryUpdate?id=<%=c.getIdCategory()%>" method="post">
					<input type="hidden" name="newName" class="newName">
					<button type="submit" class="btn btn-primary text-center"
						onclick="getNewName()">Edit</button>
				</form>
			</div>
			<div class="col">
				<a class="btn btn-danger text-center" href="/Category/categoryDelete?id=<%=c.getIdCategory()%>">Remove</a>
			</div>
		</div>
		<% } %>
		<div class="row justify-content-md-center">
			<div class="col">
				<form action="/Category/categoryInsert" method="post">
					<table class="mt-3">
						<tr>
							<td>
								<input class="p-2" type="text" name="categoryName">
							</td>
							<td>
								<button class="p-2 btn btn-success"type="submit">Add</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
<%@ include file="/include/footer.jsp" %> 
</body>
</html>