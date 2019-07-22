<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME IN THE USERMANAGER PAGE</title>
<%@ include file="/include/header.jsp"%>

<link href="/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">  
		body{
		background-color: rgba(192,192,192,.2);
	}
	#mycont{
		max-width: 500px;
	}
		
		.row div{padding : 5px 5px; border : 1px solid}
</style>

</head>
<body>
<%@ include file="/include/navbar.jsp"%>
<h1 class="display-4 text-center">LISTA UTENTI</h1>


<%List<UserDTO> listUser = (List<UserDTO>) request.getAttribute("allUserDTO");%>

<div class="container-fluid" id="mycont">
<% for(UserDTO u : listUser)
{ %>
<div class="row justify-content-md-center shadow-sm p-1 m-1 bg-white rounded">
	
	<div class="col"><%=u.getId()%></div>
	<div class="col"><%=u.getUsername()%></div>
	<div class="col"><%=u.getPassword()%></div>
	<div class="col"><%=u.getUsertype()%></div>
	<div class="col"><a class="btn btn-danger text-center" href="/User/delete?id=<%=u.getId()%>">Remove</a>
			</div>
</div>
<%}%>
</div>

<div class="row justify-content-md-center container-fluid"> 
	<form class="form-signin text-primary" method="post" action="/User/creaUserByAdminPage" >
	
	
		<h1 class="h3 mb-3 font-weight-normal text-center" > CREATE NEW USER</h1>

		<label for="inputUser" class="sr-only ">Username</label> <input
			type="text" name="username" id="inputUser" class=" text-primary"
			placeholder="Username" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="password" id="inputPassword"
			class="text-primary" placeholder="Password" required>	
			
	
				
			
 			<select id="type" name="usertype">
  				<option value="ADMIN">ADMIN</option>
  				<option value="USER">USER</option>
 
			</select>

		<button class="p-2 btn btn-success"type="submit">Add</button>
		
		</form>
</div>
<%@ include file="/include/footer.jsp"%>	
</body>
</html>