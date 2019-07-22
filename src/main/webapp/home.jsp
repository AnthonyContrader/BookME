
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<title>BookME</title>
<!-- MUST BE INCLUDED AFTER TITLE -->
<%@ include file="/include/header.jsp"%>

<style type="text/css">

body{
	background: url(https://images.unsplash.com/photo-1432821596592-e2c18b78144f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80);
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
}


#bookmelogo {
	font-family: Lato;
    color: white;
	font-weight: 700;
    text-align: center;
    padding-top: 15%;
    text-shadow: 0px 4px 3px rgba(0,0,0,0.4),
                    0px 8px 13px rgba(0,0,0,0.1),
                        0px 18px 23px rgba(0,0,0,0.1);
}

</style>

</head>
<body>



<%@ include file="/include/navbar.jsp"%>

	<p class="h1 text-center" id="bookmelogo">HOME PAGE BOOKME</p>
	<!-- MUST BE INCLUDED AT THE END -->
<%@ include file="/include/footer.jsp"%>
</body>
</html>