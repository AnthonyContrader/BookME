<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.StoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Story</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>
<div class="main">

<%StoryDTO s = (StoryDTO) request.getAttribute("dto");%>


<form id="floatleft" action="StoryServlet?mode=update&id=<%=s.getId_Storie()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="story">Trama</label>
    </div>
    <div class="col-75">
      <input type="text" id="trama" name="trama" value=<%=s.getTrama()%>>
    </div>
  </div>
 
     <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>