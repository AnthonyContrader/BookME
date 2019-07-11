<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link href="css/homeuserStyle.css" rel="stylesheet"> 

</head>

<body>
<!-- <link href="homeuserStyle.css"> -->
<!-- <div class="header">SAMPLE Project  
</div> -->

  
     <div class="topnav" id="myTopnav">
	  <a href="#home" class="active">Home</a>
	  <div class="dropdown">
	    <button class="dropbtn">Categorie 
	      <i class="fa fa-caret-down"></i>
	    </button>
	    <div class="dropdown-content">
	      <a href="#">Biographies</a>
	      <a href="#">Comics</a>
	      <a href="#">Dramatics</a>
	      <a href="#">History</a>
	      <a href="#">Horror</a>
	      <a href="#">Mysteries</a>
	      <a href="#">Religion</a>
	      <a href="#">Romance</a>
	      <a href="#">Sport</a>
	      <a href="#">Travel</a>
	      
	    </div>
	  </div> 
	  <a href="#about">About us</a>
	  <a href="#about">Logout</a>
	  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
	</div>
	
	
	<script>
	function myFunction() {
	  var x = document.getElementById("myTopnav");
	  if (x.className === "topnav") {
	    x.className += " responsive";
	  } else {
	    x.className = "topnav";
	  }
	 }
	</script>



<!-- <div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
   <a href="StoryServlet?mode=storylist">Stories</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>   -->

</body>
</html>