<%@page import="com.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.DAO.AdminDAO"%>
<%@page import="com.DAO.UserDAO"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%><html>
<head>
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

<%!
	String subject = "";
%>

<%
	if(request.getParameter("subject") != null)
	{
		subject = request.getParameter("subject");
	}
    System.out.println("Subject : " + subject);
%>

<div id="a2" style="position:absolute;top:30px;left:250px" class="c">
	<form name="f1" action="<%=request.getContextPath()%>/ReadFile?subject=<%=subject%>" method="post" enctype="multipart/form-data">
	<table id="login" align="center">
	    
	    <h1 align="center"><font color="#000000" style="font-style: bold" size="5">Select Image File To Add</font></h1>
	    
		<hr size="10" color="#5E74D8"></hr>
		
		<tr>
				<td>&nbsp;</td>
		</tr>
	    
		<tr id="label" align="center">
		    
			<td align="center" colspan="3">
				
					<input type="file" class="field2" name="file" required="required" width="150px"></input>
				
			</td>
		</tr>
		
		<tr>
				<td>&nbsp;</td>
		</tr>
		
		<tr>
				<td>&nbsp;</td>
		</tr>
		
		<tr align="center">
			<td align="center" colspan="3">
					<input type="submit" class="button" value="Add Image" onclick="return check();"></input>
			</td>
	    </tr>
	
	</table>
	</form>
	</div>
</body>
</html>