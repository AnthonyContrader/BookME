<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.LibroDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Libro Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>


	<div class="main">
		<%
			List<LibroDTO> list = (List<LibroDTO>) request.getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>nomeLibro</th>
				<th>id_Categoria</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (LibroDTO u : list) {
			%>
			<tr>
				<td><a href=LibroServlet?mode=read&id= <%=u.getId_Libro()%>>
						<%=u.getNomeLibro()%>
				</a></td>
				<td><%=u.getId_Categoria()%></td>
				<td><a href=LibroServlet?mode=read&update=true&id=
					<%=u.getId_Libro()%>>Edit</a></td>
				<td><a href=LibroServlet?mode=delete&id=<%=u.getId_Libro()%>>Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="LibroServlet?mode=insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="text">nomeLibro</label>
				</div>
				<div class="col-75">
					<input type="text" id="nomeLibro" name="nomeLibro"
						placeholder="inserisci nomeLibro">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="text">id_Categoria</label>
				</div>
				<div class="col-75">
					<input type="text" id="id_Categoria" name="id_Categoria"
						placeholder="inserisci id_Categoria">
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