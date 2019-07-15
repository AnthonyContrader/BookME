<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PersonaggiDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>
<div class="main">

<%PersonaggiDTO u = (PersonaggiDTO) request.getAttribute("dto");%>


<form id="floatleft" action="PersonaggiServlet?mode=update&id=<%=u.getId_Personaggio()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome" name="nome" value=<%=u.getNome()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="text">id_Storie</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="text" name="id_Storie" value=<%=u.getId_Storia()%>> 
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