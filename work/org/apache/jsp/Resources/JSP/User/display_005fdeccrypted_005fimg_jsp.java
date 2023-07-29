package org.apache.jsp.Resources.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.action.user.Decryption;
import com.util.Utility;
import java.sql.ResultSet;
import com.DAO.AdminDAO;

public final class display_005fdeccrypted_005fimg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/button.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/style.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/pagination.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction openFileOption()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.getElementById(\"file1\").click();\r\n");
      out.write("\t}\r\n");
      out.write("\t//onclick=\"openFileOption();return;\"\r\n");
      out.write("\r\n");
      out.write("\tfunction openDialog()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.execCommand(\"SaveAs\",true,\"C:\\Documents and Settings\\dhs\\Desktop\\\");\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
 
String str15 = "";
str15 = Decryption.getSecretMsg();

      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");

    
    int no=Utility.parse(request.getParameter("no"));
	String fileName="",decryptedImg="";
	decryptedImg = "DecryptedImage.jpg";
	fileName = request.getAttribute("fileName").toString();
	if(fileName!="")
	/* fileExtension=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));//bmp
    fileExtension = "."+fileExtension;//.bmp */

      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/SaveFile\">\r\n");
      out.write("<div align=\"right\" style=\"position:absolute;top:0px;left:750px\">\r\n");
      out.write("    <input type=\"file\" id=\"file1\" style=\"display:none\">\r\n");
      out.write("\t<!-- <input type=\"submit\" name=\"submit\" value=\"\" class=\"gradientbuttons\" /> -->&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"hidden\" name=\"fileName\" value=\"");
      out.print(fileName);
      out.write("\">\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"a3\" align=\"right\" style=\"position:absolute;top:40px;left:25px;width: 860px;height: 375px;\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("<p>\r\n");
      out.write("\r\n");
      out.write("\t<table id=\"results\" class=\"tab\" border=\"1\" cellpadding=\"5px\" cellspacing=\"4px\" width=\"860px\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td colspan=\"6\" align=\"center\">\r\n");
      out.write("\t\t\t<font color=\"#000000\" style=\"font-style: bold\" size=\"5\">Decrypted Secret message Details</font>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t <table align=\"center\">\r\n");
      out.write("\t\t\t\t         <tr>\r\n");
      out.write("\t\t\t\t                 <td align=\"center\">\r\n");
      out.write("\t\t\t\t                  \r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                 \t\t");
      out.write("\r\n");
      out.write("\t\t\t\t                 \t\t\r\n");
      out.write("\t\t\t\t                 \t\tSecret Message is :\r\n");
      out.write("\t\t\t\t                \r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                 \t\t ");
      out.print( str15 );
      out.write("\r\n");
      out.write("\t\t\t\t         \t\t\r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                 </td>\r\n");
      out.write("\t\t\t\t         </tr>\r\n");
      out.write("\t\t\t\t </table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("  \t </table>\r\n");
      out.write("  \t </p>\r\n");
      out.write("   </div>\r\n");
      out.write(" </form>\r\n");
      out.write("   \r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>Image Decrypted successfully ..!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>Opps,Something Went Wrong! Try Again....</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
