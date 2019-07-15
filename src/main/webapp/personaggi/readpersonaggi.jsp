<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PersonaggiDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Personaggi</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>

<div class="main">
<%PersonaggiDTO u = (PersonaggiDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>nome</th>
		<th>id_Storie</th>	</tr>
	<tr>
		<td><%=u.getNome()%></td>
		<td> <%=u.getId_Storia()%></td>

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