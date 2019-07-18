<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="it.contrader.dto.StoryDTO, it.contrader.dto.CategoryDTO, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stories</title>


<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>

<link rel="stylesheet" href="/css/cardstyle.css">
<link rel="stylesheet" href="/css/buttonaddstory.css">


</head>

<body>

	<%
		List<StoryDTO> lista = (List<StoryDTO>) request.getAttribute("allStoryDTO");
		List<CategoryDTO> categoryList = (List<CategoryDTO>) request.getAttribute("categoryList");
	%>

	<div class="container-fluid content-container filter-container">
		<div class="row filter-btn-row">
			<div class="col-lg-12">
				<a data-filter="all" class="btn btn-blue filter-btn selected">All</a>
				<%
					for (CategoryDTO c : categoryList) {
				%>
				<a data-filter="<%=c.getName()%>" class="btn btn-blue filter-btn"><%=c.getName()%></a>
				<%
					}
				%>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 text-center filtered-cards">
				<div id="card-placeholder"></div>


				<%
					for (StoryDTO s : lista) {
				%>
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
				<%
					}
				%>

			</div>
		</div>
	</div>

	<div id="container-floating">

		<div id="floating-button" data-toggle="tooltip" data-placement="left"
			data-original-title="Create story" onclick="newmail()">
			<p class="plus">+</p>
			<img class="edit"
				src="https://ssl.gstatic.com/bt/C3341AA7A1A076756462EE2E5CD71C11/1x/bt_compose2_1x.png">
		</div>

	</div>

	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>



	<script src="/js/card.js"></script>
	<script src="/js/buttonaddstory.js"></script>



</body>

</html>