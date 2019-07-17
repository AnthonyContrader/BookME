<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="it.contrader.dto.StoryDTO, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stories</title>


<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>

<link rel="stylesheet" href="/css/cardstyle.css">


</head>

<body>

    <%
		List<StoryDTO> lista = (List<StoryDTO>) request.getAttribute("allStoryDTO");
	%>
	
	<div class="container-fluid content-container filter-container">
		<div class="row filter-btn-row">
			<div class="col-lg-12">
				<a data-filter="all" class="btn btn-blue filter-btn selected">All</a>
				<a data-filter="adult" class="btn btn-blue filter-btn">Fantasy</a> <a
					data-filter="animals" class="btn btn-blue filter-btn">Fiction</a> <a
					data-filter="art" class="btn btn-blue filter-btn">Western</a> <a
					data-filter="food" class="btn btn-blue filter-btn">Romance</a> <a
					data-filter="free" class="btn btn-blue filter-btn">Biography</a> <a
					data-filter="kids" class="btn btn-blue filter-btn">Mystery</a> <a
					data-filter="music" class="btn btn-blue filter-btn">Horror</a> <a
					data-filter="new" class="btn btn-blue filter-btn">Musical</a> 
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 text-center filtered-cards">
				<div id="card-placeholder"></div>

			
			    <% for (StoryDTO s : lista) { %>
				<div class="card" data-filter="Story">
					<div class="card-img-container"></div>
					<div class="card-text-container">
						<h2 class="card-title"><%=s.getTitle()%></h2>
						<p class="card-body"><%=s.getPlot()%></p>
					</div>
					<div class="card-link-container">
						<a class="more-link">Read more</a>
					</div>
				</div>
				<% } %>

			</div>
		</div>
	</div>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>



	<script src="/js/card.js"></script>




</body>

</html>