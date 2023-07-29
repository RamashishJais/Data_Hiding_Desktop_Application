<%@page import="com.action.user.Decryption"%>
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

<script type="text/javascript">
	function openFileOption()
	{
		document.getElementById("file1").click();
	}
	//onclick="openFileOption();return;"

	function openDialog()
	{
		document.execCommand("SaveAs",true,"C:\Documents and Settings\dhs\Desktop\");
	}
</script>
<% 
String str15 = "";
str15 = Decryption.getSecretMsg();
%>
</head>
<body onload="startTimer()">
<%
    
    int no=Utility.parse(request.getParameter("no"));
	String fileName="",decryptedImg="";
	decryptedImg = "DecryptedImage.jpg";
	fileName = request.getAttribute("fileName").toString();
	if(fileName!="")
	/* fileExtension=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));//bmp
    fileExtension = "."+fileExtension;//.bmp */
%>	

<form action="<%=request.getContextPath()%>/SaveFile">
<div align="right" style="position:absolute;top:0px;left:750px">
    <input type="file" id="file1" style="display:none">
	<!-- <input type="submit" name="submit" value="" class="gradientbuttons" /> -->&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="hidden" name="fileName" value="<%=fileName%>">
	
</div>

<div id="a3" align="right" style="position:absolute;top:40px;left:25px;width: 860px;height: 375px;">
			
<p>

	<table id="results" class="tab" border="1" cellpadding="5px" cellspacing="4px" width="860px">
		
		<tr>
			
			<td colspan="6" align="center">
			<font color="#000000" style="font-style: bold" size="5">Decrypted Secret message Details</font>
			</td>
									
		</tr>
		
		<tr align="center">
			
			<td>
				 <table align="center">
				         <tr>
				                 <td align="center">
				                  
				                 
				                 
				                 
				                 
				                 		<%-- <img alt="" src="<%=request.getContextPath()%>/Files/Decryption/decryptedImg" width="300" height="200"> --%>
				                 		
				                 		Secret Message is :
				                
				                 
				                 		 <%= str15 %>
				         		
				                 
				                 </td>
				         </tr>
				 </table>
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
				<p>Image Decrypted successfully ..!</p>
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


