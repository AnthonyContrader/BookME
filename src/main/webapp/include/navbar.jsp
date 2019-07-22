<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> 
	<%@ page import="java.util.List, it.contrader.dto.CategoryDTO"
	import="it.contrader.dto.UserDTO"
	 %>
	
<!DOCTYPE html>
<style>
body {
	background-color: rgba(192, 192, 192, .2);
	height: 100%;
}
html{
	height: 100%;
}
.bg-primary{
	background: rgb(0,143,255);
	background: linear-gradient(0deg, rgba(0,143,255,1) 0%, rgba(0,185,255,1) 100%);
}

.ccolor{
color:#ffffff;
}

</style>
<% 
		UserDTO user = (UserDTO) request.getSession(false).getAttribute("utenteCollegato");
		@SuppressWarnings("unchecked")
    	List<CategoryDTO> categoryList = (List<CategoryDTO>) request.getSession().getAttribute("categoryList");
		CategoryDTO category = (CategoryDTO) request.getAttribute("category");
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
  <a class="navbar-brand ml-5" href="/Home/home">
  <img src="/include/open-book.png" width="30" height="30" class="d-inline-block align-top mr-3" alt="">BookME</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <% for(CategoryDTO c : categoryList){ %>
      <li class="nav-item">
      <% if(category != null && category.equals(c)){ %>
        <a class="nav-link active ccolor" href="/Story/storyRead?id=<%= c.getIdCategory() %>"><%= c.getName() %></a>    
      <% } else { %>
        <a class="nav-link" href="/Story/storyRead?id=<%= c.getIdCategory() %>"><%= c.getName() %></a>    
      <% } %>
      </li>
    <% } %>
    </ul>
    <ul class="navbar-nav">  
      <% if(user!=null && user.getUsertype().toUpperCase().contains("ADMIN")) 
      { %>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle ccolor" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
      <% } 
       if(user!=null) 
      { %>
      <li class="nav-link">
      	<span class="ccolor"><%=user.getUsername() %></span>
      </li>
      <% } %>
      <li class="ccolor">
      <% if(user!=null) 
      { %>
      	<a class="btn btn-outline-light mr-5" href="/Home/logout">Logout</a>
		<% } else {%>
		<a class="btn btn-outline-light mr-5" href="/User/enter">Login/Register</a>
		<% } %>
      </li>
    </ul>
  </div>
</nav>
				