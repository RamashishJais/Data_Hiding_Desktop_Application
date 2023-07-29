
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
<div class="tab" style="position:absolute;top:50px;left:130px;width:400px;">

<form action="<%=request.getContextPath()%>/Resources/JSP/User/cancel.jsp">
    <input class="gradientbuttons" type="submit" name="action" value="Cancel" style="position:absolute;top:-45px;left:318px;"/>
</form>
<form id="login" action="<%=request.getContextPath() %>/ComposeMail" enctype="multipart/form-data" method="post">
		
			     <table id="login">
			     	<tr>
			     			<td colspan="3" align="center">Compose Your Mail</td>
			     	</tr>
			     	
			     	<tr>
			     			<td colspan="3" align="center"><hr></td>
			     	</tr>
			     	
			     	<tr>
			     		<td>To</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="text" name="to" style="width:250px" required="yes"></input>
			     		</td>
			     	</tr>
			     	
			     	<tr>
			     		<td>Subject</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="text" name="subject" style="width:250px" required="yes"></input>
			     		</td>
			     	</tr>
			     	
			     	<tr>
			     		<td>Attach File</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="file" name="attached_file" style="width:250px" required="yes"></input>
			     		</td>
			     	</tr>
			     	
			     	<tr>
			     		<td>Message</td>
			     		<td>:</td>
			     		<td></td>
			     	</tr>
			     	
			     	<tr>
			     		<td colspan="3" align="right">
			     				<textarea rows="7" cols="28" name="msg"></textarea>
			     		</td>
			     	</tr>
			     	
			     </table>
				<input class="gradientbuttons" type="submit" name="sub" value="Send Mail" style="position:absolute;top:-45px;left:400px;"/>
			
	</form>
</div>

<%
	}
	if(no == 1)
	{
		
%>

<div class="error" id="message" style="position:absolute;top:10px;left:150px">	
			<p>Opp's,Something Went Wrong Try Again !!!! </p>
</div>

<%
	}
%>
</body>

<%@page import="com.util.Utility"%></html>