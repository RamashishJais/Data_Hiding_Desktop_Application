package com.action.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.util.CL_SendMail;

public class ComposeMail extends HttpServlet
{
	/* Send Mail Paarameters Starts */
	//private static String toEmailId="testmycvsprojects@gmail.com";
	private static String toEmailId="";
	private static  String subject="";
	private static  String message="";
	private static  String attachedFilePath="";
	private static  String fromEmailId="rj2671130@gmail.com";
	private static  String password="Ashish@2022";
	private static  String hostname="smtp.gmail.com";
	private static  String portnumber="465";
	/* Send Mail Paarameters Ends */
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		boolean flag = false;
		String s = "";
		String fileName = "";
		String ext="";
		String filepath = "";
		ArrayList list =  new ArrayList();
		
		String inFilePath = "";
		String outFilePath = "";
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		
		try 
		{
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart)
 			{
 				FileItemFactory factory = new DiskFileItemFactory();
 	            ServletFileUpload upload = new ServletFileUpload(factory);
 	            
 	            try 
 	            {
 	            	List items = upload.parseRequest(request);
  	                Iterator iterator = items.iterator();
  	                while (iterator.hasNext()) 
  	                {
  	                	FileItem item = (FileItem) iterator.next();
  	                	
  	                	
	                    if (item.isFormField()) 
	                    {
	                    	s = item.getString();
	                    	list.add(s);//All Form Field Values
	                    	
	                    }
	                    else
	                    {
	                    	 fileName = item.getName();
	                    	 if(fileName!="")
		                    		ext=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));
			                 filepath = request.getRealPath("")+"\\Files\\Attachments\\"+fileName;
	                    	 //filepath = request.getRealPath("")+"\\Files\\Attachments\\in_img."+ext;
			  	             File f1=new File(filepath);
			  	             item.write(f1);
			  	             flag = true;
			  	             System.out.println("File Attachment Process Done Successfully......");
	                    }
	                        
  	                }
  	                
  	                System.out.println("********* Composing Mail Information *********");
  	                System.out.println("File Name : " + fileName);
  	                System.out.println(list);
  	                
				}
 	            catch (Exception e)
 	            {
					System.out.println("Opps,Exception While Attaching The File : " );
					e.printStackTrace();
				}
 			}
			
			/* Sending The Mail (Starts) */
			
			if(flag)
			{
				//Send Mail
				
				toEmailId = list.get(0).toString();
				subject = list.get(1).toString();
				message = list.get(2).toString();
				attachedFilePath = filepath;
				message.replace("\n","<br>");
				
				flag = CL_SendMail.sendPersonalizedMail(toEmailId, fromEmailId, password, subject,message, attachedFilePath, hostname, portnumber);
				if(flag)
				{
					System.out.println("Mail Sent Successfully To : " + toEmailId);
					rd = getServletContext().getRequestDispatcher("/Resources/JSP/User/cancel.jsp?no=1");
					rd.forward(request, response);
				}
				else
				{
					System.out.println("Opps,Something Went Wrong While Sending The Mail!!!!");
					rd=request.getRequestDispatcher("/Resources/JSP/User/compose_mail.jsp?no=1");
					rd.forward(request, response);
				}
				
			}
			else
			{
				System.out.println("Opps,Something Went While Attaching The File!");
				rd=request.getRequestDispatcher("/Resources/JSP/User/compose_mail.jsp?no1=1");
				rd.forward(request, response);
			}
			
			/* Sending The Mail (Ends) */
			
		} 
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In User==>ComposeMail Servlet : ");
			e.printStackTrace();
			rd=request.getRequestDispatcher("/Resources/JSP/User/compose_mail.jsp?no1=1");
			try {
				rd.forward(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
