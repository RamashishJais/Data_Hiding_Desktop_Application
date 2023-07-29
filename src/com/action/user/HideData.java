package com.action.user;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.util.HideProcess;

public class HideData extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String action = "";
		String username = "";
		String dataToHide = "";
		String dataHidingKey = "";
		String inFilePath = "";
		String outFilePath = "";
		String fileName = "",filePath="";
		String ext = "";
		boolean flag = false;
		BufferedImage img = null;
		
		try 
		{
			username = (String) session.getAttribute("user");
			ext = (String) session.getAttribute("file_ext");
			action = request.getParameter("action");
			
			
			if(action.equals("Cancel"))
			{
				System.out.println("The Data Hiding Process Canceled Successfully......");
				request.setAttribute("user",username);
				// rd=request.getRequestDispatcher("/Resources/JSP/User/home.jsp");
				rd = getServletContext().getRequestDispatcher("/Resources/JSP/User/cancel_1.jsp");
				rd.forward(request, response);
			}
			
			if(action.equals("Save Image"))
			{
				System.out.println("Saving The Incrypted Image...........");
				//filePath = request.getRealPath("")+"\\Files\\Encryption\\enc_img."+ext;
				filePath = "/Files/SteganoImages/EncryptedImage.png";
				rd = getServletContext().getRequestDispatcher("/DownloadFile?file_path="+filePath);
				rd.forward(request, response);
			}
			
			if(action.equals("Hide Data"))
			{
				
				String checkAction = request.getParameter("act");
				
				
				if(checkAction.equals("HideData"))
				{
					rd=request.getRequestDispatcher("/Resources/JSP/User/hide_data.jsp");
					rd.forward(request, response);
				}
				else if(checkAction.equals("HideDataAction"))
				{
					System.out.println("Data Hiding Process is in Progress.....");
					dataToHide = request.getParameter("textData");
					dataHidingKey = request.getParameter("hidingKey");
					
					System.out.println("****************** Data Hiding Information ****************");
					System.out.println("Data To Hide : " + dataToHide);
					System.out.println("Data Hiding Key : " + dataHidingKey);
					
					inFilePath = request.getRealPath("")+"\\Files\\Encryption\\enc_img."+ext;
					outFilePath = request.getRealPath("")+"\\Files\\Encryption\\enc_img_data."+ext;
					//inFilePath = request.getRealPath("")+"\\Files\\enc_baby.jpg";
					//outFilePath = request.getRealPath("")+"\\Files\\enc_baby_data.jpg";
					
					img = HideProcess.readImage(inFilePath);
					//
						int length = dataToHide.length();
						dataToHide = length+"~"+dataToHide;
					//
					flag = HideProcess.hideProcess(img,dataHidingKey,dataToHide,outFilePath);
					
					if(flag)
					{
						System.out.println("Data Hiding Process Done Successfully.... ");
						rd=request.getRequestDispatcher("/Resources/JSP/User/hide_data.jsp?no=1");
						rd.forward(request, response);
					}
					else
					{
						System.out.println("Opps,Something Went Wrong While Hiding The Data!!!!!");
						rd=request.getRequestDispatcher("/Resources/JSP/User/hide_data.jsp?no1=1");
						rd.forward(request, response);
					}
					
				}
				
				else if(checkAction.equals("Save File"))
				{
					System.out.println("Saving The Encrypted File With Data.....");
					//filePath = request.getRealPath("")+"\\Files\\Encryption\\enc_img."+ext;
					filePath = "/Files/Encryption/enc_img_data."+ext;
					rd = getServletContext().getRequestDispatcher("/DownloadFile?file_path="+filePath);
					rd.forward(request, response);
				}
				
			}
			
			if(action.equals("Save"))
			{
				System.out.println("Saving The Decrypted File .....");
				filePath = "/Files/Decryption/dec_img."+ext;
				rd = getServletContext().getRequestDispatcher("/DownloadFile?file_path="+filePath);
				rd.forward(request, response);
				System.out.println("Decrypted File Downloaded Successfully......");
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Opps,Exception in User==>HideData Servlet : ");
			e.printStackTrace();
		}
		
	}
}
