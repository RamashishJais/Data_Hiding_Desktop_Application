
<%@page import="com.util.Utility"%><html>
<head>
    <link href="<%=request.getContextPath() %>/Resources/CSS/style1.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
</head>

<script language="javascript">

	function check()
	{
		if(document.f1.file.value.length==0)
		{
			alert("Please Select a File");
			return false
		}
		else
		{
			return true;
		}
	}
</script>

<body onload="startTimer()">

<div id="a2" style="position:absolute;top:30px;left:150px" class="c">
	<form name="f1" action="<%=request.getContextPath()%>/Resources/JSP/User/select_file.jsp">
	<table id="login" align="center">
	    
	    <h1 align="center"><font color="#000000" style="font-style: bold" size="5">Add Image For Encryption</font></h1>
	    
		<hr size="10" color="#5E74D8"></hr>
		
					<tr>
							<td colspan="3" align="center"><hr></hr></td>
					</tr>
					
					<tr>
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td width="200px">Subject :</td>
							<td width="75px">:</td>
							<td width="200px">
								<input type="text" class="field" name="subject" required="yes">
							</td>
							
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td colspan="7" align="center">
								<input class="button" type="submit"  value="Select File" onclick="return check();"></input>
							</td>
					</tr>
		
	
	</table>
	</form>
	</div>
	<% 
	if(Utility.parse(request.getParameter("no"))==1)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Sorry,This File is already Exists,Select Other File!</p>
			</div>
		<%
	}
	
	if(Utility.parse(request.getParameter("no"))==2)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Something Went Wrong Try Again...!</p>
			</div>
		<%
	}
	
	%>
</body>
</html>