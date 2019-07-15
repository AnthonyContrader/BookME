<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.StoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Story</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>

<div class="main">
<%StoryDTO u = (StoryDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>trama</th>
		<th>id_Categoria</th>
	</tr>
	<tr>
		<td><%=u.getTrama()%></td>
		<td> <%=u.getId_Categoria()%></td>

	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>