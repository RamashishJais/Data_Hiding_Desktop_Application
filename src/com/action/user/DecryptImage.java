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
import com.util.ImageProcess;
import com.util.Image_Merge;
import com.util.MergeImage_RRnGGnBB;
import com.util.ShiftImage;

public class DecryptImage extends HttpServlet 
{
	static int count = 0;
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		boolean flag = false;
		String root = "";
		root = request.getRealPath("");
		String fileName = "";
		String path = "";
		String originalImgpath = "";
		String steganoImgpath = "";
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		String xPro = "",fileExtension="";
		UserDAO userDAO = null;
		HttpSession session = request.getSession();
		try
		{
			System.out.println("Existing file getting deleted ");
			String path3 = request.getRealPath("") +"\\Files\\Decryption\\";
			System.out.println("path for deleting decryption existing images : "+path3);
			File f5 = new File(path3);        
			 String[] myFiles;      
	         if(f5.isDirectory())
	         {  
	             myFiles = f5.list(); 
	             System.out.println("my file is : "+myFiles);
	             for (int i=0; i<myFiles.length; i++) 
	             {  
	                  File myFile = new File(f5, myFiles[i]);   
	                    myFile.delete();  
	             }  
	        }  
			
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

	                    }
	                    else
	                    {
	                    	 fileName = item.getName();
	                    	 if(fileName!="")
		                    		fileExtension=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));//bmp
	                    	        fileExtension = "."+fileExtension;//.bmp
			                 //filepath = request.getRealPath("")+"\\Files\\Encryption\\"+fileName;
	                    	 path = root+"\\Files\\Decryption\\"+fileName;
	                    	 System.out.println("file name is************************"+path);
			  	             File f1=new File(path);
			  	             item.write(f1);
			  	             flag = true;
	                    }   
  	                }
  	                System.out.println("Input Files For Decryption are Uploaded Successfully......");
				}
 	            catch (Exception e)
 	            {
					System.out.println("Opps,Exception While Uploading The Input Files For Decryption : " );
					e.printStackTrace();
				}
 			}
			if(flag)
			{
				
				System.out.println("count value is+++++++++++++++ : "+count);
				count++;
				
				originalImgpath = request.getRealPath("") +"\\Files\\Decryption\\"+fileName;
				steganoImgpath = request.getRealPath("") +"\\Files\\Decryption\\EncryptedImage.png";
				System.out.println("original image path is : "+originalImgpath);
				System.out.println("stegano image path is : "+steganoImgpath);
				img1 = Decryption.readImage(originalImgpath);
				img2 = Decryption.readImage(steganoImgpath);
				String path2 = request.getRealPath("") +"\\Files\\DecryptedImage\\DecryptedImage.jpg";
				Decryption.getMaxHistogram(img1);
				Decryption.decryption(img1, img2, path2);
				Decryption.getSecretMsg2();
				
				System.out.println("secret MSG Length is :"+Decryption.MsgLength5);
				Decryption.secretMsgLength = ((Decryption.MsgLength5*4)+12);
				
				
				Decryption.decryption2(img1, img2, Decryption.secretMsgLength);
				//Decryption.getSecretMsg5();
				System.out.println("");
				System.out.println("Image Decrypted Successfully......");
				Decryption.sec.clear();
				Decryption.sec2.clear();
				request.setAttribute("fileName",fileName);
				rd=request.getRequestDispatcher("/Resources/JSP/User/display_deccrypted_img.jsp?no=1");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("Opps,Something Went Wrong While Uploading The Input Files For Decryption!!!!!");
				request.setAttribute("fileName",fileName);
				rd=request.getRequestDispatcher("/Resources/JSP/User/display_deccrypted_img.jsp?no=2");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Exception is in User==>DecryptImage Servlet : ");
			e.printStackTrace();
			out.println("Opps's Exception is in User DecryptImage Servlet......"+e);
		}
	}
}
