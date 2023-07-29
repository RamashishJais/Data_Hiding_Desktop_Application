<%@page import="com.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.DAO.AdminDAO"%>
<%@page import="com.DAO.UserDAO"%><html>
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
    
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    int id=0,userId=0,fileId=0,deptId=0,designationId=0;
	String date="",time="",status="",username="";
	
	AdminDAO adminDAO = AdminDAO.getInstance();
	UserDAO userDAO = UserDAO.getInstance();
    username = (String) session.getAttribute("username");
	
%>	

<div id="a4" align="right" style="position:absolute;top:50px;left:1px;width: 750px;height: 300px;">
			
<p>

	<table id="results" class="tab" border="1" cellpadding="5px" cellspacing="4px" width="750px">
		
		<tr>
			
			<td colspan="6" align="center">
			<font color="#000000" style="font-style: bold" size="5">User Transaction Details</font>
			</td>
									
		</tr>
							
		
		<tr>
			<th>Date</th>
			<th>File</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Status</th>
		</tr>

<% 
	
    if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			date=rs.getString(2);
			time=rs.getString(3);
			userId=rs.getInt(4);
			fileId=rs.getInt(5);
			deptId=rs.getInt(6);
			designationId=rs.getInt(7);
			status=rs.getString(8);
			
%>
			<tr align="center">
						<td><%=date%></td>
						<td><%=userDAO.getFileName(fileId)%></td>
						<td><%=adminDAO.getDepartmentName(deptId)%></td>
						<td><%=adminDAO.getDesignationName(designationId)%></td>
						<td><%=status%></td>
						
			</tr>
<%
		}
    
}
%>
  	 </table>
  	 </p>
   </div>
 </form>
   

<div id="pageNavPosition" style="position:absolute;top:350px;left:550px"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results',6); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>

</body>
</html>


