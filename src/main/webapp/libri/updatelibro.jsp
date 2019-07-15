<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.LibroDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Libro</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>
<div class="main">

<%LibroDTO u = (LibroDTO) request.getAttribute("dto");%>


<form id="floatleft" action="LibroServlet?mode=update&id=<%=u.getId_Libro()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nomeLibro">nomeLibro</label>
    </div>
    <div class="col-75">
      <input type="text" id="nomeLibro" name="nomeLibro" value=<%=u.getNomeLibro()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="id_Categoria">id_Categoria</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="id_Categoria" name="id_Categoria" value=<%=u.getId_Categoria()%>> 
    </div>
  </div>
<!--   <div class="row"> -->
<!--     <div class="col-25"> -->
<!--       <label for="type">Usertype</label> -->
<!--     </div> -->
<!--    		 <div class="col-75"> -->
<!--  			<select id="type" name="usertype"> -->
<%--   				<option value="ADMIN" <%if(u.getUsertype().equals("ADMIN")) {%>selected<%}%>>ADMIN</option> --%>
<%--   				<option value="USER" <%if(u.getUsertype().equals("USER")) {%>selected<%}%>>USER</option> --%>
<!-- 			</select> -->
<!--     	</div> -->
<!--   </div> -->
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>