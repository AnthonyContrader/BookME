<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> 
	<%@ page import="java.util.List, it.contrader.dto.CategoryDTO"
	import="it.contrader.dto.UserDTO"
	 %>
	
<!DOCTYPE html>
<style>
body {
  background-color: rgba(192, 192, 192, .2);
}
.bg-primary{
	background: rgb(25,16,182);
	background: linear-gradient(0deg, rgba(25,16,182,1) 0%,
				rgba(12,12,153,1) 35%,
				rgba(22,152,199,1) 85%,
				rgba(28,174,204,1) 100%);
}

</style>
<% 
		UserDTO user = (UserDTO) request.getSession(false).getAttribute("utenteCollegato");
		@SuppressWarnings("unchecked")
    	List<CategoryDTO> categoryList = (List<CategoryDTO>) request.getSession().getAttribute("categoryList");
	
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
  <a class="navbar-brand" href="/Home/home">
  <img src="/include/open-book.png" width="30" height="30" class="d-inline-block align-top mr-3" alt="">BookME</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <% for(CategoryDTO c : categoryList){ %>
      <li class="nav-item">
        <a class="nav-link" href="/Story/storyRead?id=<%= c.getIdCategory() %>"><%= c.getName() %></a>    
      </li>
    <% } %>
    </ul>
    <ul class="navbar-nav">  
      <% if(user!=null && user.getUsertype().toUpperCase().contains("ADMIN")) 
      { %>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Utilities
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/User/userManagement">Users</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/Category/categoryManagement">Categories</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/Story/viewStory">Stories</a>
        </div>
      </li>
      <% } %>
      <li>
      <% if(user!=null) 
      { %>
      	<a class="btn btn-outline-light" href="/Home/logout">Logout</a>
		<% } else {%>
		<a class="btn btn-outline-light" href="/User/enter">Login/Register</a>
		<% } %>
      </li>
    </ul>
  </div>
</nav>
				