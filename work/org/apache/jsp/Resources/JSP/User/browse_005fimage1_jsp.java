package org.apache.jsp.Resources.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.user.util.Utility;

public final class browse_005fimage1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/contact.css\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/login.css\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/button.css\" type=\"text/css\"/>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/pagination.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/style.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");

	int no=Utility.parse(request.getParameter("no"));
    String fileExtension = (String) session.getAttribute("file_ext");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\r\n");

	if(no == 0)
	{

      out.write("\r\n");
      out.write("\r\n");
      out.write("<form id=\"login\" action=\"");
      out.print(request.getContextPath() );
      out.write("/EncryptImage_2\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"tab\" style=\"position:absolute;top:50px;left:130px;width:400px;\">\r\n");
      out.write("\t\t\t     \r\n");
      out.write("\t\t\t     <table id=\"login\">\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t\t<td colspan=\"3\" align=\"center\">Browse Image File For Hiding Secret Message</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t\t<td colspan=\"3\" align=\"center\"><hr></td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td>Original Image</td>\r\n");
      out.write("\t\t\t     \t\t<td>:</td>\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<input class=\"field\" type=\"file\" name=\"file\" style=\"width:250px\"></input>\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td>Secret Message </td>\r\n");
      out.write("\t\t\t     \t\t<td>:</td>\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<input class=\"field\" type=\"text\" name=\"encryption_key\" placeholder=\"Enter Secret Message\" required autocomplete=\"off\" style=\"width:250px\"></input>\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     </table>\r\n");
      out.write("\t\t\t     \r\n");
      out.write("\t\t\t\t<input class=\"gradientbuttons\" type=\"submit\" value=\"Hide Secret Message in Image\" style=\"position:absolute;top:-45px;left:270px;\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");

	}
	else if(no == 1)
	{
		

      out.write("\r\n");
      out.write("<div class=\"tab\" style=\"position:absolute;top:50px;left:130px;width:450px;\">\r\n");
      out.write("    \r\n");
      out.write("    <form action=\"");
      out.print(request.getContextPath());
      out.write("/HideData\">\r\n");
      out.write("    <input class=\"gradientbuttons\" type=\"submit\" name=\"action\" value=\"Cancel\" style=\"position:absolute;top:-45px;left:195px;\"/>\r\n");
      out.write("    <input class=\"gradientbuttons\" type=\"submit\" name=\"action\" value=\"Save Image\" style=\"position:absolute;top:-45px;left:280px;\"/>\r\n");
      out.write("    \r\n");
      out.write("\t<table id=\"login\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<font color=\"green\" size=\"5\">Secret message hiding process done Successfully.....</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Image/");
      out.print(fileExtension);
      out.write("\" width=\"200px\" height=\"200px\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\tOriginal Image\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td width=\"11px\"></td>\r\n");
      out.write("\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/SteganoImages/EncryptedImage.png\" width=\"200px\" height=\"200px\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\tEncrypted Image\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("   </form>\r\n");
      out.write("</div>\r\n");

	}

      out.write("\r\n");
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
