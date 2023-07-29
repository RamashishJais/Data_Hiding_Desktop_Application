<html>
<%! 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
} 
%>
<head>
<title>Index</title>

<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />

<script type = "text/javascript">
// Our own function for message hiding (in Admin Login We used startTimer() from js by including style.js)
function hideMessage()
{
	document.getElementById("message").style.display="none"; 
}
function startTimer() 
{
	var tim = window.setTimeout("hideMessage()", 2000);  // 5000 milliseconds = 5 seconds
}
</script>

 <script language="javascript">

	function check()
	{
		if(document.f1.username.value.length==0 && document.f1.password.value.length==0)
		{
			window.location.href = 'index.jsp?no=1';
			return false
		}
		if(document.f1.username.value.length==0)
		{
			window.location.href = 'index.jsp?no=2';
			return false
		}
		if(document.f1.password.value.length==0)
		{
			window.location.href = 'index.jsp?no=3';
			return false
		}
	}
	
</script>

		<meta charset="utf-8">
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--webfonts-->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text.css'/>
		<!--//webfonts-->
</head>

<%
	int no=convert(request.getParameter("no"));
	if(no==1)
	{
		    
%>       
    		<div class="error" id="message" style="position:absolute;top:75px;left:400px">	
    			<p> Enter Username and Password !</p>
    		</div>	
    	 
<%
	}
	if(no==2)
	{
%>
		<div class="error" id="message" style="position:absolute;top:75px;left:400px">	
    			<p> Please,Enter Your Username.!</p>
    	</div>	
<%
	}
	if(no==3)
	{
%>
		<div class="error" id="message" style="position:absolute;top:75px;left:400px">	
    			<p> Please,Enter Your Password.!</p>
    	</div>	
<%
	}
%>
<%
	if(no==4)
	{
%>
		<div class="error" id="message" style="position:absolute;top:75px;left:400px">	
    			<p> Sorry,Invalid Username/Password!</p>
    	</div>	
<%
	}
%>
<%
	if(no==5)
	{
%>
		<div class="success" id="message" style="position:absolute;top:75px;left:400px">	
			<p>Loged out successfully...!</p>
		</div>
<%
	}
%>
 
<body onload = "startTimer()">
 <img src="<%=request.getContextPath() %>/Resources/Images/logo.png" width=100% ></img>
	<div style="position:absolute;top:70px;left:400px;" class="main">
	
  		<form name="f1" id="login" method="post"  action="<%=request.getContextPath()%>/AdminLogin"> 
    		<h1><span>Admin</span> <lable> Login </lable> </h1>
  			<div class="inset">
	  			<p>
	    		 <label for="email">ADMIN ID</label>
   	 			<input type="text" name = "username" placeholder="" required/>
				</p>
  				<p>
				    <label for="password">PASSWORD</label>
				    <input type="password" name = "password" placeholder="" required/>
  				</p>
 			 </div>
 	 
			  <p class="p-container">
			    <span><a href="index.jsp">[Are You User?]</a></span>
			   
			   <input type="submit" value="Login" onclick="return check();"> <br>
			  </p>
		</form>
		<div style="position:absolute;top:270px;left:11px;font-size:30px;color:red;">
    	<marquee direction="left" width="820px"  dir="rtl" ><strong>HIDING TEXT INSIDE IMAGE USING HISTOGRAM TECHNIQUE</strong> </marquee>
		</div>
	</div>  
	</div>  
</body>
</html>