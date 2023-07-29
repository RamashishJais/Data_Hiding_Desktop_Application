<html>
<head>
<title>Home</title>
    <link href="<%=request.getContextPath() %>/Resources/CSS/style1.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript">
	function f()
	{
	
	}
	</script>
</head>
<body>
<center>
<img alt="" src="<%=request.getContextPath()%>/Resources/Images/logo.png" width="100%">
</center>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
			 <tbody><tr>
				<td> 
              <div id="tabsE">	
                    <ul>
                       <li><a href="<%=request.getContextPath()%>/Resources/JSP/User/home.jsp" title="Home Page"><span>Home</span></a></li>
                       <li><a href="<%=request.getContextPath()%>/UserProfile" target="myIframe" title="View Admin Profile"><span>Profile</span></a></li>
                      <%--  <li><a href="<%=request.getContextPath()%>/ImageList?submit=get" target="myIframe" title="Add Image For Encryption"><span>Image</span></a></li> --%>
                       <li><a href="<%=request.getContextPath()%>/Resources/JSP/User/browse_image1.jsp" target="myIframe" title="Image Encryption"><span>Data Hiding</span></a></li>
                       <li><a href="<%=request.getContextPath()%>/Resources/JSP/User/browse_image.jsp" target="myIframe" title="Image Decryption"><span>Data Retrieval</span></a></li>
                        <li><a href="<%=request.getContextPath()%>/Resources/JSP/User/compose_mail.jsp" target="myIframe" title="Mail The Random Shares"><span>Email</span></a></li>
                       <li><a href="<%=request.getContextPath()%>/index.jsp?no=5" title="Signout"><span>Logout</span></a></li>
                   </ul>
                </div></td>
	      </tr>
           <tr>
            <td height="6" bgcolor="#4C0D0D"></td>
          </tr>	
	 </tbody></table>
</body>

<iframe allowtransparency="true" id="stframe" class="stframe" name="myIframe" frameborder="0" scrolling="no" width="1025px" height="650px"  src="<%=request.getContextPath()%>/Resources/JSP/Admin/default_page.jsp">
</iframe>
</html>