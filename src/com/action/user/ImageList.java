/**
 * 
 */
package com.action.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AdminDAO;
import com.DAO.UserDAO;
import com.util.Utility;

/**
 * @author 
 *Apr 10, 2012 3:33:14 PM
 *Project:-Cloud_Computing(RC4)
 *Package:-com.nitin.action.admin
 *File:-UserList.java
 */
public class ImageList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		String fileName = "";
		String path = "";
		
		try
		{
			String submit=request.getParameter("submit").trim();
			
			UserDAO userDAO = UserDAO.getInstance();
			rs = userDAO.getImageDetails();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/Resources/JSP/User/image_list.jsp?no=1");
				rd.forward(request, response);
			}
			if(submit.equals("Add"))
			{
				
				rd=request.getRequestDispatcher("/Resources/JSP/User/add_image.jsp");
				rd.forward(request, response);
				
			}
			
			if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				if(Utility.parse1(request.getParameter("edit1")).equals("YES"))
				{
					String s[]=new String[2];
					s[0]=request.getParameter("id");
					s[1]=request.getParameter("subject");
					
					userDAO.editImageDetails(s);
					
					rs = userDAO.getImageDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/image_list.jsp?no=1&no1=2");
					rd.forward(request, response);
				}
				else if(chk==null)
				{
					rs = userDAO.getImageDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/image_list.jsp?no=1&no1=3");
					rd.forward(request, response);
				}
				else if(chk.length!=1)
				{
					rs = userDAO.getImageDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/image_list.jsp?no=1&no1=4");
					rd.forward(request, response);
				}
				else if(chk.length==1)
				{
					rs = userDAO.getImageDetailsById(Integer.parseInt(chk[0]));
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/image_list.jsp?no=3");
					rd.forward(request, response);
				}
			}
			
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs = userDAO.getImageDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/image_list.jsp?no=1&no1=3");
					rd.forward(request, response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						
						fileName = userDAO.getFileName(Integer.parseInt(chk[i]));
						path = request.getRealPath("") +"\\Files\\Image\\" + fileName;
						
						userDAO.deleteImageDetails(Integer.parseInt(chk[i]));
						
						File file = new File(path);
						if(file.exists())
						{
							file.delete();
						}
					}
					rs = userDAO.getImageDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/image_list.jsp?no=1&no1=5");
					rd.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User ImageList Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in User ImageList Servlet......"+e);
		}
	}
}
