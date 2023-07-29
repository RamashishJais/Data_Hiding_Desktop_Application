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

<style type="text/css">
.resizedTextbox {width: 300px; height: 50px}
</style>
</head>
<body onload="startTimer()">
<%
    AdminDAO adminDAO = null;
    adminDAO = AdminDAO.getInstance();
    int no=Utility.parse(request.getParameter("no"));
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    int id=0,deptId=0,designId=0;
	String fileName="",subject="";
	
	if(no==1)
	{
%>	

<form action="<%=request.getContextPath()%>/EncryptImage">
<div align="right" style="position:absolute;top:0px;left:650px">
	<input type="submit" name="submit" value="Method-1" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<!-- <input type="submit" name="submit" value="Method-2" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp; -->
	
</div>

<div id="a3" align="right" style="position:absolute;top:35px;left:111px;width: 700px;height: 570px;">
			
<p>

	<table id="results" class="tab" border="1" cellpadding="5px" cellspacing="4px" width="700px">
		
		<tr>
			
			<td colspan="6" align="center">
			<font color="#000000" style="font-style: bold" size="5">Encrypt Your Image</font>
			<br>
			</td>
									
		</tr>
		<tr>
			<th>Select</th>
			<th>Image</th>
			
		</tr>

<% 
	
    if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			fileName=rs.getString(2);
			subject=rs.getString(3);
			
%>
			<tr align="center">
				<td>
					<input name="chk" type="checkbox" value="<%=id%>">
				</td>
				
				<td>
					<img alt="" src="<%=request.getContextPath()%>/Files/Image/<%=fileName%>" width="100px" height="120px">
					<br>
					<a href="<%=request.getContextPath() %>/Resources/JSP/User/update_file.jsp?fileId=<%=id%>">ChangeImage</a>
				</td>
						
			</tr>
<%
		}
    }

%>
  	 </table>
  	 </p>
  	 <div align = "left">
  	
  	  Please Enter the Secret Message :<input  type ="text" class="resizedTextbox" name ="secretmsg" placeholder = "Please Enter the Secret Message"/> 
  	  
  	  </div>
   </div>
  
 </form>
 
   

<div id="pageNavPosition" style="position:absolute;top:600px;left:700px"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results',2); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>

<%-- Adding The Server Details --%>

<%
	if(Utility.parse(request.getParameter("no1"))==1)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Image Sieving Process Done successfully ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Something Went Wrong! Try Again....</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==3)
	{
		%>
			<!-- <div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Select atleast one checkbox !</p>
			</div> -->
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==4)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Select only one checkbox to edit!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==5)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Image  Details Deleted successfully ..!</p>
			</div>
		<%
	}
}
	
%>
</body>
</html>


