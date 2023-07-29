package com.action.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFile extends HttpServlet
{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		ServletContext context = null;
		InputStream is = null;
		OutputStream os = null;
		String filePath="",fileName = "";
		try 
		{
			
	        
	        filePath = request.getParameter("file_path");
	        File file = new File(filePath);
	        fileName = file.getName();
	        System.out.println("---------------- File Dowmload Info -------------------");
	        System.out.println("File Name : " + fileName);
	        System.out.println("File Path : " +filePath);
	        System.out.println("--------------------------------------------------------");
	        context = getServletContext();
	        //is = context.getResourceAsStream("/Files/Encryption/enc_img.jpg");
	       is = context.getResourceAsStream(filePath);
	        
	        if(is.available()==0)
			{
	        	PrintWriter out = response.getWriter();
	        	response.setContentType("text/html");
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
					os.write(bytes, 0, read);  
				}  
				os.flush();  
				os.close();
	            response.flushBuffer();
	        }
	    }
		catch (IOException e) 
		{
	        System.out.println("Opps,Exception in Common=>DownloadFile : ");
			e.printStackTrace();
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
	}
}
