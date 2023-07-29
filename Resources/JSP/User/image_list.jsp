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
    AdminDAO adminDAO = null;
    adminDAO = AdminDAO.getInstance();
    
    int no=Utility.parse(request.getParameter("no"));
    
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    
    int id=0,deptId=0,designId=0;
	String fileName="",subject="";
	
	if(no==1)
	{
%>	

<form action="<%=request.getContextPath()%>/ImageList">

<div align="right" style="position:absolute;top:0px;left:550px">
	<input type="submit" name="submit" value="Add" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="Edit" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="Delete" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
</div>

<div id="a3" align="right" style="position:absolute;top:35px;left:111px;width: 700px;height: 570px;">
			
<p>

	<table id="results" class="tab" border="1" cellpadding="5px" cellspacing="4px" width="700px">
		
		<tr>
			
			<td colspan="6" align="center">
			<font color="#000000" style="font-style: bold" size="5">View Image Details</font>
			</td>
									
		</tr>
							
		
		<tr>
			<th>Select</th>
			<th>Id</th>
			<th>Subject</th>
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
				
				<td><%=id%></td>
				
				<td><%=subject%></td>
				
				<td>
					<img alt="" src="<%=request.getContextPath()%>/Files/Image/<%=fileName%>" width="100px" height="100px">
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
   </div>
 </form>
   

<div id="pageNavPosition" style="position:absolute;top:600px;left:650px"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results',4); 
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
				<p>Image Added successfully ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Image  Updated successfully ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==3)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Select atleast one checkbox !</p>
			</div>
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
	if(no == 2)
	{
%>
		
		<div id="a3" align="right" style="position:absolute;top:5px;left:50px">
						
		 <p>
			<table id="login" align="center">
					
				<form action="<%=request.getContextPath()%>/ImageList">
				<input type="hidden" name="submit" value="Add"></input>
				<input type="hidden" name="add1" value="YES"></input>
					
					<tr>
							<td colspan="7" align="center">
								<font color="#000000" style="font-style: bold" size="5">Add Image Details</font>
							</td>
					</tr>
					
					<tr>
							<td colspan="7" align="center"><hr></hr></td>
					</tr>
					
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
			</form>
			</table>
		</p>
						
</div>
<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Sorry,This Image is already exists  !</p>
				</div>
			<%
		}
		
		if(Utility.parse(request.getParameter("no1"))==2)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Sorry, Somthing went wrong try again!</p>
				</div>
			<%
		}

}

if(no == 3)
{
	
	String hostName="";
	
	
	 if(rs != null)
    {
	    while(rs.next())
		{
	    	id=rs.getInt(1);
			fileName=rs.getString(2);
			subject=rs.getString(3);
		}
    }   
	
%>
		
		<div id="a3" align="right"  style="position:absolute;top:25px;left:200px">
						
		 <p>
			<table id="login" align="center">
					
				<form action="<%=request.getContextPath()%>/ImageList">
				<input type="hidden" name="submit" value="Edit"></input>
			    <input type="hidden" name="edit1" value="YES"></input>
			    <input type="hidden" name="id" value="<%=id %>"></input>
					
					<tr>
							<td colspan="7" align="center">
								<font color="#000000" style="font-style: bold" size="5">Edit Image Details</font>
							</td>
					</tr>
					
					<tr>
							<td colspan="7" align="center"><hr></hr></td>
					</tr>
					
					<tr>
							<td>&nbsp;</td>
					</tr>
					
					
					
					<tr align="center">
							<td width="200px">Subject</td>
							<td width="75px">:</td>
							<td width="200px">
								<input type="text" class="field" name="subject" value="<%=subject%>" required="yes">
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td colspan="7" align="center">
								<input class="button" type="submit"  value="Update"></input>
							</td>
					</tr>
			</form>
			</table>
		</p>
						
</div>
<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
					<p>Sorry, Somthing went wrong try again!</p>
				</div>
			<%
		}
		
		if(Utility.parse(request.getParameter("no1"))==2)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Sorry, Somthing went wrong try again!</p>
				</div>
			<%
		}

}
%>
</body>
</html>


