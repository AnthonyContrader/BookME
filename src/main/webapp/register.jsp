<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Register</title>

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

<form id="form" class="login" action="/User/creaUser" method="post">

		<h2 align="center">Registrati</h2>  
		<div class="form-item">
			<p class="formLabel">Username</p>
			<input type="username" name="username" id="username" class="form-style" autocomplete="off"/>
		</div> 
		<div class="form-item">
			<p class="formLabel">Password</p>
			<input type="password" name="password" id="password" class="form-style" />	     
			<!-- <div class="pw-view"><i class="fa fa-eye"></i></div> -->
		</div>
		
		<div class="row">
    <div class="col-25">
      <label for="type">Usertype</label>
    </div>
   		 <div class="col-75">
 			<select id="type" name="usertype">
  				<option value="ADMIN">ADMIN</option>
  				<option value="USER">USER</option>
 
			</select>
    	</div>
  </div>
		<br>
		<div class="form-item">
			<input type="submit" class="login pull-right" value="Registrati">    
        </div>     
        <br>
        <br>
       
     	<p class="rup-pass"><a href="login.jsp" ><small>Log In</small></a></p>   

</form>

</div>

    <script  src="./script21.js"></script>    <script  src="./script.js"></script>

</body>
</html>