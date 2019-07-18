<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME IN THE USERMANAGER PAGE</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">  
		body
		{
		background: rgb(238,174,202);
		background: radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);
		}
</style>
</head>
<body>
<h1 class="h3 mb-3 font-weight-normal">LISTA UTENTI</h1>
<%List<UserDTO> list = (List<UserDTO>) request.getAttribute("allUserDTO");%>
<table>
<% for(UserDTO u : list){ %>
<tr>
<td width='50'>
<%= u.getIdUser() %>
 </td>
<td>
<%= u.getUsername() %>
 </td>
 <td>
<%= u.getEmail() %>
 </td>
 <td>
<%= u.getPassword() %>
 </td>
 
</tr>
<%}%>
</table>




	<form class="form-signin text-primary" action="/User/creaUser" method="post">
		<h1 class="h3 mb-3 font-weight-normal">CREATE NEW USER</h1>

		<label for="inputUser" class="sr-only ">Username</label> <input
			type="text" name="username" id="inputUser" class=" text-primary"
			placeholder="Username" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="password" id="inputPassword"
			class="text-primary" placeholder="Password" required>
			 <label for="inputEmail" class="sr-only">Email</label> <input
			type="text" name="email" id="inputEmail"
			class="text-primary" placeholder="Email" required> 

		<button class="btn btn-dark"  type="submit">CREA</button>
	</form>
	
	
	<form class="form-delete text-danger" action="/User/delete" method="get">
		<h1 class="h3 mb-3 font-weight-normal">CANCELLA USER</h1>

		<label for="deleteUser" class="sr-only">Inserisci ID</label>
		 <input
			type="text" name="id" id="deleteUser" class=" text-danger"
			placeholder="Id utente" required autofocus> </label>
			
			
			<button class="btn btn-primary" type="submit">ELIMINA</button>
	</form>
		
		<a class="btn btn-primary" href="/Home/gobackhome"> <i
							class="nc-icon nc-paper-2"></i>
							<p>Torna alla home</p>
					</a>		
</body>
</html>