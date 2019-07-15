<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PersonaggiDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Personaggi Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>


	<div class="main">
		<%
			List<PersonaggiDTO> list = (List<PersonaggiDTO>) request.getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Nome</th>
				<th>id_Storie</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (PersonaggiDTO u : list) {
			%>
			<tr>
				<td><a href=PersonaggiServlet?mode=read&id=
					<%=u.getId_Personaggio()%>> <%=u.getNome()%>
				</a></td>

				<td><%=u.getId_Storia()%></td>
				<td><a href=UserServlet?mode=read&update=true&id=
					<%=u.getId_Personaggio()%>>Edit</a></td>
				<td><a href=UserServlet?mode=delete&id=
					<%=u.getId_Personaggio()%>>Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="PersonaggiServlet?mode=insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="text">Nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="nome" name="nome"
						placeholder="inserisci nome">
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-25">
					<label for="text">id_Storie</label>
				</div>
				<div class="col-75">
					<input type="text" id="id_Storie" name="id_Storie"
						placeholder="inserisci id_Storie">
				</div>
			</div>
<!-- 			<div class="row"> -->
<!-- 				<div class="col-25"> -->
<!-- 					<label for="type">Usertype</label> -->
<!-- 				</div> -->
<!-- 				<div class="col-75"> -->
<!-- 					<select id="type" name="usertype"> -->
<!-- 						<option value="ADMIN">ADMIN</option> -->
<!-- 						<option value="USER">USER</option> -->

<!-- 					</select> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>