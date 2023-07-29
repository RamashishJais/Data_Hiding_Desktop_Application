<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Encryption method option</title>
</head>
<body>
<center>
<p><h2>Please Select the Secret Message Hiding Method</h2></p>
<form action="<%=request.getContextPath()%>/Resources/JSP/User/browse_image1.jsp">
<!-- <div align="left" style="position:absolute;top:0px;left:650px"> -->
	<input type="submit" name="submit" value="Method-1" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
 </form>
 <br>
 <br>
 <form action="<%=request.getContextPath()%>/EncryptImage_2">
<input type="submit" name="submit" value="Method-2" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
 </form>
 </center>
</body>
</html>