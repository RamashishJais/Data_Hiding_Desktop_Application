
<%@page import="com.user.util.Utility"%><html>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/message.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/contact.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/login.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/button.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/pagination.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
</head>

<%
	int no=Utility.parse(request.getParameter("no"));
    String fileExtension = (String) session.getAttribute("file_ext");
%>

<body onload="startTimer()">

<%
	if(no == 0)
	{
%>

<form id="login" action="<%=request.getContextPath() %>/EncryptImage_2" enctype="multipart/form-data" method="post">
		
			<div class="tab" style="position:absolute;top:50px;left:130px;width:400px;">
			     
			     <table id="login">
			     	<tr>
			     			<td colspan="3" align="center">Browse Image File For Hiding Secret Message</td>
			     	</tr>
			     	
			     	<tr>
			     			<td colspan="3" align="center"><hr></td>
			     	</tr>
			     	
			     	<tr>
			     		<td>Original Image</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="file" name="file" style="width:250px"></input>
			     		</td>
			     	</tr>
			     	
			     	<tr>
			     		<td>Secret Message </td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="text" name="encryption_key" placeholder="Enter Secret Message" required autocomplete="off" style="width:250px"></input>
			     		</td>
			     	</tr>
			     	
			     </table>
			     
				<input class="gradientbuttons" type="submit" value="Hide Secret Message in Image" style="position:absolute;top:-45px;left:270px;"/>
			</div>
			
</form>

<%
	}
	else if(no == 1)
	{
		
%>
<div class="tab" style="position:absolute;top:50px;left:130px;width:450px;">
    
    <form action="<%=request.getContextPath()%>/HideData">
    <input class="gradientbuttons" type="submit" name="action" value="Cancel" style="position:absolute;top:-45px;left:195px;"/>
    <input class="gradientbuttons" type="submit" name="action" value="Save Image" style="position:absolute;top:-45px;left:280px;"/>
    
	<table id="login">
		<tr>
				<td colspan="3" align="center">
					<font color="green" size="5">Secret message hiding process done Successfully.....</font>
				</td>
		</tr>
		<tr></tr>
		<tr>
				<td align="center">
						<img alt="" src="<%=request.getContextPath()%>/Files/Image/<%=fileExtension%>" width="200px" height="200px">
						<br>
						Original Image
				</td>
				<td width="11px"></td>
				<td align="center">
						<img alt="" src="<%=request.getContextPath()%>/Files/SteganoImages/EncryptedImage.png" width="200px" height="200px">
						<br>
						Encrypted Image
				</td>
		</tr>
	</table>
   </form>
</div>
<%
	}
%>
</body>
</html>