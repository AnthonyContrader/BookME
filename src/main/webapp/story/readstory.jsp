<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="it.contrader.dto.StoryDTO,it.contrader.dto.UserDTO, it.contrader.dto.CategoryDTO, java.util.List"%>
<!DOCTYPE html>
<html>
<head>

<title>Stories</title>


<%@ include file="/include/header.jsp"%>

<link rel="stylesheet" href="/css/cardstyle.css">
<link rel="stylesheet" href="/css/buttonaddstory.css">

</head>

<body>
	<%@ include file="/include/navbar.jsp"%>
	
	<script>
		function myFunction() {
			window.location.href = '/Story/goInsertStory?idcategory=<%= category.getIdCategory() %>';
		}
	</script>
	<%
		@SuppressWarnings("unchecked")
		List<StoryDTO> storyList = (List<StoryDTO>) request.getAttribute("storyList");
	%>

	<div class="container-fluid content-container filter-container">
		
		<div class="row">
			<div class="col-sm-12 text-center filtered-cards">

				<%
					for (StoryDTO s : storyList) {
				%>
				<div class="card" data-filter="Story">
					<div class="card-img-container"></div>
					<div class="card-text-container">
						<h2 class="card-title"><%=s.getTitle()%></h2>
						<p class="card-body"><%=s.getPlot()%></p>
						<p class=""><small>Created by <%=s.getAuthor() %></small></p>
					</div>
					<div class="card-link-container">
						<% if(s.getPlot().length() > 50){ %>
						<a href="#" class="more-link">Read more</a>
						<% } %>
					</div>
				</div>
				<%
					}
				%>

			</div>
		</div>
	</div>



	<nav aria-label="Stories navigation">
		<ul class="pagination justify-content-center">
			<li class="page-item disabled"><a class="page-link" href="#"
				tabindex="-1" aria-disabled="true">Previous</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
	</nav>



	<%
		if (user != null && (user.getUsertype().toUpperCase().contains("ADMIN")
				|| user.getUsertype().toUpperCase().contains("USER"))) {
	%>
	<div id="container-floating">

		<div id="floating-button" data-toggle="tooltip" data-placement="left"
			data-original-title="Create story" onclick="myFunction()">
			<p class="plus">+</p>
			<img class="edit"
				src="https://ssl.gstatic.com/bt/C3341AA7A1A076756462EE2E5CD71C11/1x/bt_compose2_1x.png">
		</div>

	</div>
	<%
		}
	%>
	
	
	<script src="/js/buttonaddstory.js"></script>
	<script src="/js/card.js"></script>
	
	<%@ include file="/include/footer.jsp"%>
</body>

</html>