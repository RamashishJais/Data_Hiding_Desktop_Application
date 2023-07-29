package com.action.admin;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Test extends HttpServlet {
	
	static final String COUNTER_KEY = "D:/Yogendra_test_version5.0/IRDH V 5.0/Files/SteganoImages/EncryptedImage.png";
	  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
	      IOException {
		  
	    HttpSession session = req.getSession(true);
	    int count = 1;
	    Integer i = (Integer) session.getAttribute(COUNTER_KEY);
	    if (i != null) {
	      count = i.intValue() + 5;
	    }
	    
	    FileInputStream in = null;
	    ServletOutputStream out=resp.getOutputStream();

	      try {
	         in = new FileInputStream(COUNTER_KEY);
	        
	         
	         int c;
	         while ((c = in.read()) != -1) {
	            out.write(c);
	         }
	      }finally {
	         if (in != null) {
	            in.close();
	         }
	         if (out != null) {
	            out.close();
	         }
	      }
	   }
	    
	   
	  }
	


