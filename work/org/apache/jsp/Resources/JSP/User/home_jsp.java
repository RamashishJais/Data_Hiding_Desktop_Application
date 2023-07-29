package org.apache.jsp.Resources.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Home</title>\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/style1.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
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
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tfunction f()\r\n");
      out.write("\t{\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<center>\r\n");
      out.write("<img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/logo.png\" width=\"100%\">\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t <tbody><tr>\r\n");
      out.write("\t\t\t\t<td> \r\n");
      out.write("              <div id=\"tabsE\">\t\r\n");
      out.write("                    <ul>\r\n");
      out.write("                       <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/User/home.jsp\" title=\"Home Page\"><span>Home</span></a></li>\r\n");
      out.write("                       <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/UserProfile\" target=\"myIframe\" title=\"View Admin Profile\"><span>Profile</span></a></li>\r\n");
      out.write("                      ");
      out.write("\r\n");
      out.write("                       <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/User/browse_image1.jsp\" target=\"myIframe\" title=\"Image Encryption\"><span>Data Hiding</span></a></li>\r\n");
      out.write("                       <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/User/browse_image.jsp\" target=\"myIframe\" title=\"Image Decryption\"><span>Data Retrieval</span></a></li>\r\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/User/compose_mail.jsp\" target=\"myIframe\" title=\"Mail The Random Shares\"><span>Email</span></a></li>\r\n");
      out.write("                       <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp?no=5\" title=\"Signout\"><span>Logout</span></a></li>\r\n");
      out.write("                   </ul>\r\n");
      out.write("                </div></td>\r\n");
      out.write("\t      </tr>\r\n");
      out.write("           <tr>\r\n");
      out.write("            <td height=\"6\" bgcolor=\"#4C0D0D\"></td>\r\n");
      out.write("          </tr>\t\r\n");
      out.write("\t </tbody></table>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<iframe allowtransparency=\"true\" id=\"stframe\" class=\"stframe\" name=\"myIframe\" frameborder=\"0\" scrolling=\"no\" width=\"1025px\" height=\"650px\"  src=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/Admin/default_page.jsp\">\r\n");
      out.write("</iframe>\r\n");
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
