package com.action.user;

import java.io.*;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Download extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		//ServletContext context = null;
		InputStream is = null;
		OutputStream os = null;
		boolean flag=false;
		String filePath="",fileName = "";
		
			//response.setContentType("application/html");   // see new MIME type
			 
		    ServletContext ctx = getServletContext();
	        filePath = req.getParameter("file_path");
	        //File file = new File(filePath);
		    try {
		        String path=req.getRequestURI();
		        if (path.endsWith(".jpg"))     resp.setContentType("image/jpeg");
		        if (path.endsWith(".html"))     resp.setContentType("text/html");
		        path=path.substring(1);
		        InputStream data=Download.class.getClassLoader().getResourceAsStream(filePath);
		        ServletOutputStream out=resp.getOutputStream();
		        try {
		          if (data != null) {
		            byte[] buffer=new byte[1024];
		            int n;
		            while ((n=data.read(buffer)) > 0)         out.write(buffer,0,n);
		          }
		     else {
		            out.write(("could not get resource " + path + "").getBytes());
		          }
		        }
		      finally {
		          data.close();
		        }
		      }
		     catch (  Throwable t) {
		        //log.error(t,t);
		        throw new IOException(t);
		      }
	}
}
	       /* fileName = file.getName();
	       // System.out.println("---------------- File Dowmload Info -------------------");
	        System.out.println("File Name : " + fileName);
	        System.out.println("File Path : " +filePath);
	        System.out.println("--------------------------------------------------------");
	        context = getServletContext();
	        //is = context.getResourceAsStream("/Files/Encryption/enc_img.jpg");
	       is = context.getResourceAsStream("/Files/SteganoImages/EncryptedImage.png");
	        System.out.println("************************88"+is);
	        if(is.available()==0)
			{
	        	System.out.println("IS empty");
	        	PrintWriter out = response.getWriter();
	        	//response.setContentType("text/html");
				out.println("Download Process Failed,Try Again!!!!!");
			}
	        else
	        {
	            response.setContentType("image/jpeg");
	            response.setHeader("Content-Disposition","attachment; filename=\""+fileName+"\"");
	           
	            os = response.getOutputStream(); 
	            
	            int read =0;  
				byte[] bytes = new byte[1024];  
				
				while((read = is.read(bytes)) != -1)  
				{  
				
					 os.write(bytes, 0,read );  
					 flag=true;
				}  
				os.flush();  
				os.close();
	           // response.flushBuffer();
	        }
	    }
		finally 
		{
	        if (is != null) 
	        {
	            try 
	            {
	                is.close();
	            } 
	            catch (IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
	    }
		 if (flag == true) 
		 {
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/EncryptImage");
				rd.forward(request, response);
		 }*/
	//}
//}
