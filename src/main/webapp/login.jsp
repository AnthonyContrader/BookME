<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" >
<head>
<meta charset="UTF-8">
<title>Log In</title>

<link rel="stylesheet" href="./style.css">	  <link rel="stylesheet" href="./style21.css">

</head>

<body>

<canvas id="canvas"></canvas>
  <script src='https://codepen.io/Tibixx/pen/BbBxRG.js'></script>
<script src='https://codepen.io/Tibixx/pen/rRBKBm.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/dat-gui/0.7.5/dat.gui.min.js'></script>

<script src="https://code.jquery.com/jquery-2.1.0.min.js" ></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<div id="formWrapper">

<form id="form" class="login" action="/User/login" method="post">

		<h2 align="center">Log In</h2>  
		<div class="form-item">
			<p class="formLabel">Username</p>
			<input type="username" name="username" id="username" class="form-style" autocomplete="off"/>
		</div> 
		<div class="form-item">
			<p class="formLabel">Password</p>
			<input type="password" name="password" id="password" class="form-style" />
			<p class="rup-pass"><a href="#" ><small>Forgot Password ?</small></a></p>	     
			<!-- <div class="pw-view"><i class="fa fa-eye"></i></div> -->
		</div>
		
		<div class="form-item">
			<input type="submit" class="login pull-right" value="Entra">    
        </div>     
        <br>
        <br>
     	<p class="rup-pass"><a href="register.jsp" ><small>Registrati</small></a></p>   
     	

</form>

</div>

    <script  src="./script21.js"></script>    <script  src="./script.js"></script>



</body>
</html>