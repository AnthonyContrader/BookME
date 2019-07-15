<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.StoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Story Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>


	<div class="main">
		<%
			List<StoryDTO> list = (List<StoryDTO>) request.getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>trama</th>
				<th>id_Categoria</th>
				<th>id_Storie</th>
			</tr>
			<%
				for (StoryDTO u : list) {
			%>
			<tr>
				<td><a href=StoryServlet?mode=read&id= <%=u.getId_Storie()%>>
						<%=u.getTrama()%>
				</a></td>
				<td><%=u.getId_Categoria()%></td>

				<td><a href=StoryServlet?mode=read&update=true&id=
					<%=u.getId_Storie()%>>Edit</a></td>
				<td><a href=StoryServlet?mode=delete&id= <%=u.getId_Storie()%>>Delete</a>
				</td>

			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="StoryServlet?mode=insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="trama">Trama</label>
				</div>
				<div class="col-75">
					<input type="text" id="trama" name="trama"
						placeholder="inserisci Trama">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="id_Categoria">id_Categoria</label>
				</div>
				<div class="col-75">
					<input type="text" id="id_Categoria" name="id_Categoria"
						placeholder="inserisci id_Categoria">
				</div>
			</div>

			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>