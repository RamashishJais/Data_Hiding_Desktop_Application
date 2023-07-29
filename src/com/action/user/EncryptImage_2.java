package com.action.user;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.user.util.ImageEncrypt;



public class EncryptImage_2 extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		boolean flag = false;
		String s = "";
		String fileName = "";
		String ext="";
		String filepath = "";
		ArrayList list =  new ArrayList();
		
		String inFilePath = "";
		String outFilePath = "";
		String msg = "";
		int xor = 0;
		BufferedImage img = null;
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
	                    	 System.out.println("file name is ++++++++++++++++++++"+fileName);
	                    	 //session.setAttribute("fileName", fileName);
	                    	 if(fileName!="")
		                    		ext=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));
			                 //filepath = request.getRealPath("")+"\\Files\\Encryption\\"+fileName;
	                    	 filepath = request.getRealPath("")+"\\Files\\Image\\"+fileName;
	                    	 System.out.println("file path for original image :"+filepath);
			  	             File f1=new File(filepath);
			  	             item.write(f1);
			  	             flag = true;
			  	             System.out.println("File Uploaded Successfully......");
			  	             session.setAttribute("file_ext",fileName);
	                    }
	                        
  	                }
  	                
  	                msg = list.get(0).toString();
  	                System.out.println("Secret Message is : " + msg);
				}
 	            catch (Exception e)
 	            {
					System.out.println("Opps,Exception While Uploading The File : " );
					e.printStackTrace();
				}
 			}
			
			/* Encrypting The Uploaded File (Starts) */
			
			if(flag)
			{
				//Encrypting The File
				
				inFilePath = request.getRealPath("")+"\\Files\\Image\\"+fileName;
				outFilePath = request.getRealPath("")+"\\Files\\SteganoImages\\EncryptedImage.png";
				
				
				img = Encryption.readImage(inFilePath);
            	Encryption.getMaxHistogram(img);
            	Encryption.encryption(img);
            	int maxPixelCount = Encryption.max;// number of pixel value contains by max histogram 
            	System.out.println("max pixel count is :"+maxPixelCount);
            	int maxCountHisto = Encryption.count;//histogram which is having maximum number of pixel
            	System.out.println("Histogram having max pixel count is :"+maxCountHisto);
            	int secMsgLen = msg.length();
            	String xsecMsgLen;
            	xsecMsgLen = Encryption.getStringLength(secMsgLen);
            	String []key1= new String[xsecMsgLen.length()];
            	char c[]= new char[xsecMsgLen.length()];
            	for(int i=0;i<xsecMsgLen.length();i++)
            	{
            		c[i]=xsecMsgLen.charAt(i);
            		int xsecMsgLen2 = Integer.parseInt(""+c[i]);
            		key1[i] = Encryption.getBinary1(xsecMsgLen2);
            	}
            	String msg2 = xsecMsgLen + msg;
            	int secMsgLen2 = msg2.length();
            	Encryption.RPH2 = secMsgLen2 * 4;
            	System.out.println("Entered secret msg is : " + msg);
            	System.out.println("Entered secret msg2 is : " + msg2);
            	System.out.println("Secret Message Length is : " + xsecMsgLen);
				System.out.println("Secret Message Length is : " + secMsgLen2);
				System.out.println("Required Pixel to Hide (RPH) value is : " + Encryption.RPH2);
				Encryption.hide_pix_count = 0;
				if (maxPixelCount < Encryption.RPH2) 
				{
					System.out.println("Secret Message size is too big, Histogram count is not sufficient, Please select another Image");
				} 
				else 
				{
					Encryption.msgInBinary = new String[msg.length()];
					Encryption.msgInBinary = Encryption.getBinary(msg);//passing message to get corresponding binary values
					System.out.println("Entered message binary value is : ");
					Encryption.temp.addAll(Arrays.asList(key1));
					Encryption.temp.addAll(Arrays.asList(Encryption.msgInBinary));
					Encryption.concatedArgs = Encryption.temp.toArray(new String[key1.length+Encryption.msgInBinary.length]);
					for (String i4 : Encryption.concatedArgs) 
					{
						Encryption.str2+= i4;
					}
					int len2 = Encryption.str2.length();
				
					for(int j=0;j<len2;j=j+2)
					{
						for(int i=j;i<j+2;i++)
						{
							char c2= Encryption.str2.charAt(i);
							Encryption.str3 += c2;	
						}
						Encryption.sec2.add(Encryption.str3);
						Encryption.str3="";
					}
				
					for(String t :Encryption.sec2)
					{
						System.out.println("Two bit of secret message is : "+t);
						Encryption.list.add(Encryption.bitaddition(t));//sending two-two bit secret message 
					}
					for(int y : Encryption.list)
					{
						System.out.println("Modified pixel decimal value is: "+y);
					}
				

					 String path1 = request.getRealPath("") +"\\Files\\SteganoImages\\EncryptedImage.png";
					Encryption.encryption2(img, path1);
				
				
				
					for(int i=0;i<Encryption.RPH2;i++)
					{
						System.out.println("The "+ i+" Pixel decimal value which is hiding in image is :"+Encryption.list1.get(i));
					}
				}
				//request.setAttribute("fileName",fileName);
				System.out.println("Secret message hiding process done Successfully....");
				rd=request.getRequestDispatcher("/Resources/JSP/User/browse_image1.jsp?no=1");
				rd.forward(request, response);	
			}
			else
			{
				System.out.println("Opps,Something Went While Uploading The File!");
			}
			
			/* Encrypting The Uploaded File (Ends) */
			
		} 
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In User==>EncryptImage Servlet : ");
			e.printStackTrace();
		}
	}
}
