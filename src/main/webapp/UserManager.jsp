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
		body
		{
		background: rgb(238,174,202);
		background: radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);
		}
		
		.row div{padding : 5px 5px; border : 1px solid}
</style>

</head>
<body>
<%@ include file="/include/navbar.jsp"%>
<h1 class="h3 mb-3 font-weight-normal">LISTA UTENTI</h1>


<%List<UserDTO> list = (List<UserDTO>) request.getAttribute("allUserDTO");%>

<div class="container">
<% for(UserDTO u : list)
{ %>
<div class = "row" style= "background : lightblue">
	
	<div class="col-md-3"><%=u.getId()%></div>
	<div class="col-md-3"><%=u.getUsername()%></div>
	<div class="col-md-3"><%=u.getPassword()%></div>
	<div class="col-md-3"><%=u.getUsertype()%></div>
</div>
<%}%>
</div>

	<form class="form-signin text-primary" action="/User/creaUserByAdminPage" method="post">
		<h2 class="h3 mb-3 font-weight-normal" > CREATE NEW USER</h2>

		<label for="inputUser" class="sr-only ">Username</label> <input
			type="text" name="username" id="inputUser" class=" text-primary"
			placeholder="Username" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="password" id="inputPassword"
			class="text-primary" placeholder="Password" required>	
		<label for="inputUserType" class="sr-only ">UserType</label> <input
			type="text" name="usertype" id="inputUser" class=" text-primary"
			placeholder="Usertype" required autofocus>
			
			 

		<button class="btn btn-dark"  type="submit">CREA</button>
	</form>
	
	
	<form class="form-delete text-danger" action="/User/delete" method="get">
		<h2 class="h3 mb-3 font-weight-normal">CANCELLA USER</h2>

		<label for="deleteUser" class="sr-only">Inserisci ID</label>
		 <input
			type="text" name="id" id="deleteUser" class=" text-danger"
			placeholder="Id utente" required autofocus> </label>
			
			
			<button class="btn btn-primary" type="submit">ELIMINA</button>
	</form>
		
			
<%@ include file="/include/footer.jsp"%>	
</body>
</html>