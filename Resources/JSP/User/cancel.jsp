
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
%>

<body onload="startTimer()">

<%
if(no == 0)
{
%>

	<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
				<p>Process Canceled Successfully.....</p>
	</div>	

<%
}
if(no == 1)
{
%>

	<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
				<p>Mail Sent Successfully.....</p>
	</div>	

<%
}
if(no == 2)
{
%>

	<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
				<p>Decrypted Image Saved Successfully.....</p>
	</div>	

<%
}
%>
</body>

<%@page import="com.util.Utility"%></html>