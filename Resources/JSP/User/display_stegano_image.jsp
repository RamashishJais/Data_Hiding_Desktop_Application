<%@page import="com.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.DAO.AdminDAO"%><html>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/pagination.js"></script>

</head>
<body onload="startTimer()">
<%
    
    int no=Utility.parse(request.getParameter("no"));
	String fileName="",stegano_img="";
	fileName = request.getAttribute("fileName").toString();
	stegano_img = "EncryptedImage.png";
	

%>	

<form action="<%=request.getContextPath()%>/EncryptImage">
<div align="right" style="position:absolute;top:11px;left:650px">
	 <input class="gradientbuttons" type="submit" name="submit" value="Save Image" style="position:absolute;top:-5px;left:50px;"/>
	<input type="hidden" name="fileName" value="<%=fileName%>">
	
</div>

<div id="a3" align="right" style="position:absolute;top:50px;left:111px;width: 700px;height: 300px;">
			
<p>
	<table id="results" class="tab" border="1" cellpadding="5px" cellspacing="4px" width="700px">
		
		<tr>
			
			<td colspan="6" align="center">
			<font color="#000000" style="font-style: bold" size="5">Image Details</font>
			</td>
									
		</tr>
		<tr>
			<th>Original Image</th>
			<th>Stegano Image</th>
		</tr>
		<tr align="center">
			<td>
				<img alt="" src="<%=request.getContextPath()%>/Files/Image/<%=fileName%>" width="100px" height="120px">
			</td>
			
			<td>
				<img alt="" src="<%=request.getContextPath()%>/Files/SteganoImages/<%=stegano_img%>" width="100px" height="120px">
			</td>
		</tr>
  	 </table>
  	 </p>
   </div>
 </form>
   
<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Image Steganography Process Done successfully ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Something Went Wrong! Try Again....</p>
			</div>
		<%
	}
	
%>
</body>
</html>


