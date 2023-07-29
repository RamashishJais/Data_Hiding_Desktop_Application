/**
 * 
 */
package com.action.user;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AdminDAO;
import com.DAO.UserDAO;
import com.util.AlterImage;
import com.util.ImageProcess;
import com.util.Image_Merge;
import com.util.ShiftImage;
import com.util.Utility;

public class EncryptImage extends HttpServlet 
{
	static String msg = null;
	static String action = null;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		msg = request.getParameter("secretmsg");
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		
		String root = "";
		String fileName = "";
		String path = "";
		String filePath = "";
		String steganoImgPath = "";
		String downloadSteganoImgPath = "";
		BufferedImage img = null;
		String xPro = "",fileExtension="";
		UserDAO userDAO = null;
		HttpSession session = request.getSession();  
		
		 
		try
		{
			
				String submit=request.getParameter("submit").trim();
			
				userDAO = UserDAO.getInstance();
			
				rs = userDAO.getImageDetails();
				String userHomeFolder = "C:/Documents and Settings/Admin/My Documents/Downloads";
			
				root = request.getRealPath("");
				steganoImgPath = root+"\\Files\\SteganoImages\\";
				downloadSteganoImgPath = root+"\\Files\\Download\\";
				
				if(submit.equals("Save Image"))
				{
					System.out.println("Saving The Incrypted Image...........");
					//filePath = request.getRealPath("")+"\\Files\\Encryption\\enc_img."+ext;
					filePath = "/Files/SteganoImages/EncryptedImage.png";
					rd = getServletContext().getRequestDispatcher("/DownloadFile?file_path="+filePath);
					rd.forward(request, response);
				}
			
				if(submit.equals("get"))
				{
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/encrypt_image.jsp?no=1");
					rd.forward(request, response);
				}
				if(submit.equals("Method-1"))
				{
					String []chk=request.getParameterValues("chk");
				
					if(chk==null)
					{
						rs = userDAO.getImageDetails();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/Resources/JSP/User/encrypt_image.jsp?no=1&no1=3");
						rd.forward(request, response);
					}
					else if(chk.length!=1)
					{
						rs = userDAO.getImageDetails();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/Resources/JSP/User/encrypt_image.jsp?no=1&no1=4");
						rd.forward(request, response);
					}
					else if(chk.length==1)
					{
						int id = Integer.parseInt(chk[0]);
						fileName = userDAO.getFileName(id);
					
						path = request.getRealPath("") +"\\Files\\Image\\" + fileName;
					
						steganoImgPath = request.getRealPath("") +"\\Files\\SteganoImages\\";
					
						System.out.println("********* Stegano image Info **********");
						System.out.println("          Id : " +id);
						System.out.println("        File : " +fileName);
						System.out.println("        Path : " +path);
						System.out.println("Stegano image Path : " +steganoImgPath);
					
					
						File file = new File(path);
					
						if(file.exists())
						{
						
							if ( session.getAttribute( "waitPage" ) == null ) 
							{  
					    	   session.setAttribute( "waitPage", Boolean.TRUE );  
					    	   out.println( "<html><head>" );  
					    	   out.println( "<title>Please Wait...</title>" );  
					       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
					    	   out.println( "</head><body bgcolor=''>" );  
					    	   out.println( "<br><br><br>" );
					    	   out.print( "<center><img src='Resources/Images/status_processing.gif'></img><br><br>");
					    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
					    	   out.println("<font color='white' size='5'>");
					    	   out.println( "Image Sieving is in Process......  " );
					    	   out.println("</font><br>");
					    	   out.println( "Please wait....</h1></center");  
					    	   out.close();  
							}  
							else
							{
								session.removeAttribute( "waitPage" );  
							
								/* Deleting the old files from Stegano directory Directory(Starts) */
							 	File f = new File(request.getRealPath("") +"\\Files\\SteganoImages\\");   
							 	
							 	String[] myFiles;      
					            if(f.isDirectory())
					            {  
					                myFiles = f.list();  
					                for (int i=0; i<myFiles.length; i++) 
					                {  
					                    File myFile = new File(f, myFiles[i]);   
					                    myFile.delete();  
					                }  
					             }  
					            /* Deleting the old files from Stegano Directory(Ends) */
							
					            try 
					            {
					            	img = Encryption.readImage(path);
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
									request.setAttribute("fileName",fileName);
									rd=request.getRequestDispatcher("/Resources/JSP/User/display_stegano_image.jsp?no=1");
									rd.forward(request, response);
								
									System.out.println("Stegano Image Process Done.....");
					            }
					            catch (Exception e)
					            {
					            	System.out.println("Opps,Exception in User-EncryptImage Servlet stegano Image :");
					            	e.printStackTrace();
					            }
							}
					}
					else
					{
						rs = userDAO.getImageDetails();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/Resources/JSP/User/encrypt_image.jsp?no=1&no1=2");
						rd.forward(request, response);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

