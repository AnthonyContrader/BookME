<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>type your story</title>
<%@ include file="/include/header.jsp"%>
<link rel="stylesheet" href="/css/createstory.css">
	  
</head>

<body>
<%@ include file="/include/navbar.jsp"%>
	<div class="main-container">
		<h1>Create your story</h1>
		<form class="form" method="post" action="/Story/insertStory">
			<input type="text" id="title" name="title" placeholder="Type your title ..." />
			<input type="hidden" name="idcategory" value="<%= request.getAttribute("idcategory") %>">
			<textarea id="plot" name="plot" rows="5" cols="50" placeholder="Type your story ..."></textarea>
			<div class="d-flex justify-content-around mt-3">
				<button type="submit" id="btnsave" class="btn btn-outline-success btn-lg px-4">Save</button>
				<button type="button" id="btncancel" class="btn btn-outline-danger btn-lg" onclick="history.go(-1);return false;">Cancel</button>
			</div>

		</form>

	</div>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>