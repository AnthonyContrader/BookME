<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="it.contrader.dto.StoryDTO,it.contrader.dto.UserDTO, it.contrader.dto.CategoryDTO, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stories</title>
<%@ include file="/include/header.jsp" %>      
      <link rel="stylesheet" href="./style.css">
	  <link rel="stylesheet" href="/css/cardstyle.css">
	 
	  <script>
		  function myFunction() {
			  window.location.href = '/Story/goInsertStory';
			}
	  </script>


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
					<% if(s.getPlot().length() > 50){ %>
						<a href="#" class="more-link">Read more</a>
						<% } %>
						<a class="btn btn-outline-danger btn-sm" href="/Story/deleteStory?id=<%= s.getIdStory() %>">Delete</a>
					</div>
				</div>
				<%
					}
				%>

			</div>
		</div>
	</div>
	

	<script src="/js/card.js"></script>


<%@ include file="/include/footer.jsp" %> 
</body>

</html>