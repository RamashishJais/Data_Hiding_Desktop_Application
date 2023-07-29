
<html>
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
    //String fileExtension = (String) session.getAttribute("file_ext");
%>

<body onload="startTimer()">

<%
	if(no == 0)
	{
%>

<form id="login" action="<%=request.getContextPath() %>/EncryptImage" enctype="multipart/form-data" method="post">
		
			<div class="tab" style="position:absolute;top:50px;left:130px;width:400px;">
			     
			     <table id="login">
			     	<tr>
			     			<td colspan="3" align="center">Browse Image File For Encryption</td>
			     	</tr>
			     	
			     	<tr>
			     			<td colspan="3" align="center"><hr></td>
			     	</tr>
			     	
			     	<tr>
			     		<td>Encryption Image</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="file" name="file" style="width:250px"></input>
			     		</td>
			     	</tr>
			     	
			     	<tr>
			     		<td>Enter Secret Key</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="text" name="encryption_key" style="width:250px"></input>
			     		</td>
			     	</tr>
			     	
			     </table>
			     
				<input class="gradientbuttons" type="submit" value="Encrypt Image" style="position:absolute;top:-45px;left:375px;"/>
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
    <input class="gradientbuttons" type="submit" name="action" value="Hide Data" style="position:absolute;top:-45px;left:390px;"/>
    <input type="hidden" name="act" value="HideData" />
    
	<table id="login">
		<tr>
				<td colspan="3" align="center">
					<font color="green" size="5">Image Encrypted Successfully.....</font>
				</td>
		</tr>
		<tr></tr>
		<tr>
				<td align="center">
						<img alt="" src="<%=request.getContextPath()%>/Files/Image/in_img.jpg" width="200px" height="200px">
						<br>
						Original Image
				</td>
				<td width="11px"></td>
				<td align="center">
						<img alt="" src="<%=request.getContextPath()%>/Files/SteganoImages/encryptedImage.jpg>" width="200px" height="200px">
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
<%@page import="com.util.Utility"%></html>