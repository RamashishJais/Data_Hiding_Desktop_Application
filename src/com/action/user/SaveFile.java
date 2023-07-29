/**
 * 
 */
package com.action.user;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.DAO.UserDAO;
import com.util.FileMenipulation;
import com.util.ImageProcess;
import com.util.Image_Merge;
import com.util.MergeImage_RRnGGnBB;
import com.util.ShiftImage;

public class SaveFile extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		boolean flag = false;
		
		String root = "";
		String fileName = "",fileExtension="";
		String path = "";
		String srcFilePath = "";
		String destFilePath = "";
		
		try
		{
			fileName = request.getParameter("fileName");
			if(fileName!="")
        		fileExtension=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));//bmp
    	        fileExtension = "."+fileExtension;//.bmp
    	        
			root = request.getRealPath("");
			fileName = "decrepted_img"+fileExtension;
			srcFilePath = root+"\\Files\\Decryption\\"+fileName;
			destFilePath="C:\\Users\\ADMIN\\Downloads\\"+fileName;
			//flag = FileMenipulation.copyFile(srcFilePath, destFilePath);
			System.out.println("saved file name is "+fileName);
			
			if(flag)
			{
				System.out.println("Decrypted Image Saved Successfully.....");
				//rd = getServletContext().getRequestDispatcher("/Resources/JSP/User/cancel.jsp?no=2");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("Opps,Exception While Saving The Decrypted Image!!!!!");
				//rd = getServletContext().getRequestDispatcher("/Resources/JSP/User/display_deccrypted_img.jsp?no=2");
				rd = getServletContext().getRequestDispatcher("/Resources/JSP/User/cancel.jsp?no=2");
				rd.forward(request,response);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Exception is in User==>SaveFile Servlet : ");
			e.printStackTrace();
			out.println("Opps's Exception is in User==>SaveFile Servlet......"+e);
		}
	}
}
