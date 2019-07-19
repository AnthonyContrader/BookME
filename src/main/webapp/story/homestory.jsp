<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="it.contrader.dto.StoryDTO,it.contrader.dto.UserDTO, it.contrader.dto.CategoryDTO, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stories</title>


<%@ include file="/include/header.jsp" %>

<link rel="stylesheet" href="/css/cardstyle.css">
<link rel="stylesheet" href="/css/buttonaddstory.css">


</head>

<body>
<%@ include file="/include/navbar.jsp" %>
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
					</div>
					<div class="card-link-container">
						<a href="#" class="more-link">Read more</a>
					</div>
				</div>
				<%
					}
				%>

			</div>
		</div>
	</div>
	<% if(user!=null && (user.getUsertype().toUpperCase().contains("ADMIN") || user.getUsertype().toUpperCase().contains("USER")))
	   {
	%>
	<div id="container-floating">

		<div id="floating-button" data-toggle="tooltip" data-placement="left"
			data-original-title="Create story" onclick="newmail()">
			<p class="plus">+</p>
			<img class="edit"
				src="https://ssl.gstatic.com/bt/C3341AA7A1A076756462EE2E5CD71C11/1x/bt_compose2_1x.png">
		</div>

	</div>
	<% } %>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>



	<script src="/js/card.js"></script>
	<script src="/js/buttonaddstory.js"></script>


<%@ include file="/include/footer.jsp" %> 
</body>

</html>