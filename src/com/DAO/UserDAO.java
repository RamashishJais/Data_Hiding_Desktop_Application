/**
 * 
 */
package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.DAO.*;

/**
 * @author 
 *Dec 6, 2011 3:06:03 PM
 *Project:-DNA
 *Package:-com.nitin.process
 *File:-UserDAO.java
 */
public class UserDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static UserDAO userDAO=null;
	private UserDAO()
	{
		
	}
	public static UserDAO getInstance()
	{
		if(userDAO == null)
		{
			userDAO= new UserDAO();
		}
		return userDAO;
	}
	public boolean checkUser(String username,String password)
	{
		
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_user where username='"+username+"' and password='"+password+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	/* Get Profile Details (Starts) */
	
	public ResultSet getProfile(String username)
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where username='"+username+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	
	/* Get Profile Details (Ends) */
	
	public int getID(String username)
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_code from m_user where username='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return i;
	}
	
	
	public int getDepartmentID(String username)
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select dept_code from m_user where username='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDepartmentID(String username): ");
			e.printStackTrace();
		}
		return i;
	}
	
	
	public int getDesignationID(String username)
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select design_code from m_user where username='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDesignationID(String username): ");
			e.printStackTrace();
		}
		return i;
	}
	
	
	public String getUsername(String userName)
	{
		String username = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_name from m_user where username='"+userName+"'");
			while(resultSet.next())
			{
				username=resultSet.getString(1);
			}
			System.out.println("User Name : "+username);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getUser(int userId): ");
			e.printStackTrace();
		}
		return username;
	}
	
	
	public boolean editProfile(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_user set u_name='"+s[1]+"',u_email='"+s[2]+"',u_phone='"+s[3]+"',u_address='"+s[4]+"' where u_code='"+s[0]+"'";
			System.out.println("******* Edit User Profile Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-editProfile() :");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean chnagePass(int id,String cpass) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_user set password='"+cpass+"' where u_code='"+id+"'";
			System.out.println("******* Change User Password Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-chnagePass() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
/* Getting The Image Details (Starts) */
	
	public ResultSet getImageDetails()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_image");
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getImageDetails(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Getting The Image Details(Ends) */
	
/* Getting The Image Details By ID (Starts) */
	
	public ResultSet getImageDetailsById(int imageId)
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_image where img_id='"+imageId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getImageDetailsById(int imageId): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Getting The Image Details By ID(Ends) */
	
/* Check File Existence (Starts)*/
	public boolean checkFileExistence(String fileName)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_image where img_name='"+fileName+"'";
			System.out.println("************* Check File Existence Info **************");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("File Existence Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkFileExistence(String fileName): ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Check File Existence (Ends)*/
	
/* Add Image Details (Starts)*/
	public boolean addImageDetails(String fileName,String subject)
	{
		boolean flag=false;
		String sql = "";
		int i= 0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql ="insert into m_image (img_name,img_subject) values('"+fileName+"','"+subject+"')";
			System.out.println("************* Add Image Info **************");
			System.out.println(sql);
			 i= statement.executeUpdate(sql);
			 if(i>0)
			 {
				 flag = true;
			 }
			System.out.println("Add Image Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->addImageDetails(String fileName,String subject): ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Add Image Details (Ends)*/

/* Getting File Name By fileId (Starts) */
	public String getFileName(int fileId)
	{
		String fileName = "";
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select img_name from m_image where img_id='"+fileId+"'";
			System.out.println("*************** Get File Info ******************");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				fileName=resultSet.getString(1);
			}
			System.out.println("File Name (id = "+fileId + ") : "+fileName);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getFileName(int fileId): ");
			e.printStackTrace();
		}
		return fileName;
	}
/* Getting File Name By fileId (Ends) */	
	
/* Edit Image Details (Starts) */

	public boolean editImageDetails(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_image set img_subject='"+s[1]+"' where img_id='"+s[0]+"'";
			System.out.println("******* Edit Image Details *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Edit Image Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-editImageDetails(String [] s): ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Edit Image Details (Ends) */
	
/* Delete User Details (Starts) */
	
	public boolean deleteImageDetails(int imgId) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "delete from m_image where img_id='"+imgId+"'";
			System.out.println("******* Delete Image Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Delete Image Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in User-deleteImageDetails(int imgId) :" );
			e.printStackTrace();
		}
		return flag;
	}
	
/* Delete User Details (Ends) */
	
/* Update File (Starts)*/
	public boolean updateFile(int fileId,String fileName)
	{
		boolean flag=false;
		String sql = "";
		int i= 0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql ="update m_image set img_name='"+fileName+"' where img_id='"+fileId+"'";
			System.out.println("************* Update Image File Info **************");
			System.out.println(sql);
			 i= statement.executeUpdate(sql);
			 if(i>0)
			 {
				 flag = true;
			 }
			System.out.println("Update Image File Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->updateFile(int fileId,String fileName): ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Update File (Ends)*/
	
	
}
