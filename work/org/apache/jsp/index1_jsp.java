package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
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

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<title>Index</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script type = \"text/javascript\">\r\n");
      out.write("// Our own function for message hiding (in Admin Login We used startTimer() from js by including style.js)\r\n");
      out.write("function hideMessage()\r\n");
      out.write("{\r\n");
      out.write("\tdocument.getElementById(\"message\").style.display=\"none\"; \r\n");
      out.write("}\r\n");
      out.write("function startTimer() \r\n");
      out.write("{\r\n");
      out.write("\tvar tim = window.setTimeout(\"hideMessage()\", 2000);  // 5000 milliseconds = 5 seconds\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write(" <script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("\tfunction check()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif(document.f1.username.value.length==0 && document.f1.password.value.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\twindow.location.href = 'index.jsp?no=1';\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f1.username.value.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\twindow.location.href = 'index.jsp?no=2';\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f1.password.value.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\twindow.location.href = 'index.jsp?no=3';\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<link href=\"css/style.css\" rel='stylesheet' type='text/css' />\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t\t<script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\r\n");
      out.write("\t\t<!--webfonts-->\r\n");
      out.write("\t\t<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text.css'/>\r\n");
      out.write("\t\t<!--//webfonts-->\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");

	int no=convert(request.getParameter("no"));
	if(no==1)
	{
		    

      out.write("       \r\n");
      out.write("    \t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:75px;left:400px\">\t\r\n");
      out.write("    \t\t\t<p> Enter Username and Password !</p>\r\n");
      out.write("    \t\t</div>\t\r\n");
      out.write("    \t \r\n");

	}
	if(no==2)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:75px;left:400px\">\t\r\n");
      out.write("    \t\t\t<p> Please,Enter Your Username.!</p>\r\n");
      out.write("    \t</div>\t\r\n");

	}
	if(no==3)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:75px;left:400px\">\t\r\n");
      out.write("    \t\t\t<p> Please,Enter Your Password.!</p>\r\n");
      out.write("    \t</div>\t\r\n");

	}

      out.write('\r');
      out.write('\n');

	if(no==4)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:75px;left:400px\">\t\r\n");
      out.write("    \t\t\t<p> Sorry,Invalid Username/Password!</p>\r\n");
      out.write("    \t</div>\t\r\n");

	}

      out.write('\r');
      out.write('\n');

	if(no==5)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:75px;left:400px\">\t\r\n");
      out.write("\t\t\t<p>Loged out successfully...!</p>\r\n");
      out.write("\t\t</div>\r\n");

	}

      out.write("\r\n");
      out.write(" \r\n");
      out.write("<body onload = \"startTimer()\">\r\n");
      out.write(" <img src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/Images/logo.png\" width=100% ></img>\r\n");
      out.write("\t<div style=\"position:absolute;top:70px;left:400px;\" class=\"main\">\r\n");
      out.write("\t\r\n");
      out.write("  \t\t<form name=\"f1\" id=\"login\" method=\"post\"  action=\"");
      out.print(request.getContextPath());
      out.write("/AdminLogin\"> \r\n");
      out.write("    \t\t<h1><span>Admin</span> <lable> Login </lable> </h1>\r\n");
      out.write("  \t\t\t<div class=\"inset\">\r\n");
      out.write("\t  \t\t\t<p>\r\n");
      out.write("\t    \t\t <label for=\"email\">ADMIN ID</label>\r\n");
      out.write("   \t \t\t\t<input type=\"text\" name = \"username\" placeholder=\"\" required/>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("  \t\t\t\t<p>\r\n");
      out.write("\t\t\t\t    <label for=\"password\">PASSWORD</label>\r\n");
      out.write("\t\t\t\t    <input type=\"password\" name = \"password\" placeholder=\"\" required/>\r\n");
      out.write("  \t\t\t\t</p>\r\n");
      out.write(" \t\t\t </div>\r\n");
      out.write(" \t \r\n");
      out.write("\t\t\t  <p class=\"p-container\">\r\n");
      out.write("\t\t\t    <span><a href=\"index.jsp\">[Are You User?]</a></span>\r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t\t\t   <input type=\"submit\" value=\"Login\" onclick=\"return check();\"> <br>\r\n");
      out.write("\t\t\t  </p>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<div style=\"position:absolute;top:270px;left:11px;font-size:30px;color:red;\">\r\n");
      out.write("    \t<marquee direction=\"left\" width=\"820px\"  dir=\"rtl\" ><strong>HIDING TEXT INSIDE IMAGE USING HISTOGRAM TECHNIQUE</strong> </marquee>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>  \r\n");
      out.write("\t</div>  \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
