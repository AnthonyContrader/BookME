<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>type your story</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/createstory.css">
</head>

<body>
	<div class="main-container">
		<h1>Create your story</h1>
		<form class="form">
			<input type="text" placeholder="Type your title ..." />
			<textarea id="tarea" name="textarea" rows="5" cols="50"
				placeholder="Type your story ..."></textarea>
			<div class="d-flex justify-content-around mt-3">
				<button type="button" class="btn btn-outline-success btn-lg px-4">Save</button>
				<button type="button" class="btn btn-outline-danger btn-lg">Cancel</button>
			</div>

		</form>

	</div>
</body>
</html>