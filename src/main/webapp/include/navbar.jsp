<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> 
	<%@ page import="java.util.List, it.contrader.dto.CategoryDTO"
	import="it.contrader.dto.UserDTO"
	 %>
	
<!DOCTYPE html>

<% UserDTO user = (UserDTO) request.getSession(false).getAttribute("utenteCollegato"); 
   List<CategoryDTO> list = (List<CategoryDTO>) request.getAttribute("categoryList");
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/Home/home">BookME</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <% for(CategoryDTO c : list){ %>
      <li class="nav-item">
        <a class="nav-link" href="/Category/categoryRead?id=<%= c.getIdCategory() %>"><%= c.getName() %></a>    
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
      	<a class="btn btn-outline-light" href="#">Login/Register</a>

      </li>
    </ul>
  </div>
</nav>
				