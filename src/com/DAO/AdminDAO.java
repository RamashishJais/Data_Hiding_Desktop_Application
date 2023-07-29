/**
 * 
 */
package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.DAO.DAO;
/**
 * @author 
 
 */
public class AdminDAO
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static AdminDAO adminDAO=null;
	private AdminDAO()
	{
		
	}
	public static AdminDAO getInstance()
	{
		if(adminDAO == null)
		{
			adminDAO= new AdminDAO();
		}
		return adminDAO;
	}
	public boolean checkAdmin(String admin,String pass)
	{
		boolean flag=false;
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where adminid='"+admin+"' and password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->checkAdmin(String admin,String pass): "+ e);
		}
		return flag;
	}
	
/* Get Profile Details (Starts) */
	
	public static ResultSet getProfile(String username)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			
			statement = connection.createStatement();
			
			sql="select * from m_admin where adminid='"+username+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getProfile(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/* Get Profile Details (Ends) */
	
	
	public boolean editProfile(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_admin set name='"+s[1]+"',address='"+s[2]+"',phone='"+s[3]+"',email='"+s[4]+"' where id='"+s[0]+"'";
			System.out.println("******* Edit Profile Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editProfile() :");
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
			sql = "update m_admin set password='"+cpass+"' where id='"+id+"'";
			System.out.println("******* Change Password Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnagePass() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public ResultSet getUsers()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user");
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getUsers(): "+ e);
		}
		return resultSet;
	}
	
	
	
	public String getUser(int id)
	{
		String name="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_name from m_user where u_code='"+id+"'");
			while(resultSet.next())
			{
				name=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getUser(int id): "+ e);
		}
		return name;
	}
	
/* Check User Existence (Starts) */
	
	public boolean checkUserExistence(String username) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_user where username='"+username.trim()+"'";
			System.out.println("******* Check User Existence *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Check User Existence Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-checkUserExistence(String username) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Check User Existence (Ends) */
	
/* Add User Details (Starts) */
	
	public boolean addUserDetails(String username, String password, String name, String email,String address,String city,String mobile) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "insert into m_user (username,password,u_name,u_address,u_city,u_cell,u_email) values('"+username+"','"+password+"','"+name+"','"+address+"','"+city+"','"+mobile+"','"+email+"')";
			System.out.println("******* Add User Details *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Registeration Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-addUserDetails : ");
			e.printStackTrace();
		}
		return flag;
	}

/* Add User Details (Ends) */
	
/* Get Department By Id(Starts) */
	
	public String getDepartmentName(int id)
	{
		String name="";
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select dept_name from m_department where dept_code='"+id+"'";
			System.out.println("****** Get Department Name By Id *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name=resultSet.getString(1);
			}
			
			System.out.println("Department Name : " + name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getDepartmentName(int id): ");
			e.printStackTrace();
		}
		return name;
	}
	
/* Get Department By Id(Ends) */
	
/* Get Designation By Id(Starts) */
	
	public String getDesignationName(int id)
	{
		String name="";
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select desig_name from m_designation where desig_code='"+id+"'";
			System.out.println("****** Get Designation Name By Id *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name=resultSet.getString(1);
			}
			
			System.out.println("Designation Name : " + name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getDesignationName(int id): ");
			e.printStackTrace();
		}
		return name;
	}
	
/* Get Designation By Id(Ends) */
	
/* Edit User Details (Starts) */

	public boolean editUserDetails(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_user set username='"+s[1]+"',password='"+s[2]+"',u_name='"+s[3]+"',u_address='"+s[4]+"',u_city='"+s[5]+"',u_cell='"+s[6]+"',u_email='"+s[7]+"' where u_code='"+s[0]+"'";
			System.out.println("******* Edit User Details *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Edit User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editUserDetail(String [] s): ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Edit User Details (Ends) */
	
	public static ResultSet getSpecificUserDetails(int id)
	{
		String name="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_code='"+id+"'");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getSpecificUserDetails(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Delete User Details (Starts) */
	
	public boolean deleteUserDetails(int userId) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "delete from m_user where u_code='"+userId+"'";
			System.out.println("******* Delete User Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Delete User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in Admin-deleteUserDetails(int userId) :" );
			e.printStackTrace();
		}
		return flag;
	}
	
/* Delete User Details (Ends) */
	
	
/* Get Department Details (Starts) */
	
	public static ResultSet getDepartmentDetails()
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from m_department";
			System.out.println("******* Department Info *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getDepartmentDetails(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Department Details (Ends) */
	
	
/* Get Designation Details (Starts) */
	
	public static ResultSet getDesignationDetails()
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from m_designation";
			System.out.println("******* Designation Info *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getDesignationDetails(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Designation Details (Ends) */
	
/* Get Department Details (Starts) */
	
	public ResultSet getDepartments()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_department");
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getDepartments(): "+ e);
		}
		return resultSet;
	}
	
/* Get Department Details (Ends) */
	

/* Get Designation Details (Starts) */
	
	public ResultSet getDesignations()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_designation");
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getDesignations(): "+ e);
		}
		return resultSet;
	}
	
/* Get Department Details (Ends) */
	
	

	
/* Add Upload Transaction (Starts) */
	
	public boolean addUploadTransaction(String ufileName,String ufileType, String udate,String subject,int cloudId) 
	{
		boolean flag=false;
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="insert into m_file_upload (f_name,f_type,f_upload_date,f_subject,cloud_id) values('"+ufileName+"','"+ufileType+"','"+udate+"','"+subject+"','"+cloudId+"')";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Upload Transaction Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-addUploadTransaction.....");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Add Upload Transaction (Ends) */	

/* Get Upload File Details(Starts) */

	public ResultSet getUploadFiles()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_file_upload");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getUploadFiles() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Upload File Details(Ends) */
	
/* Get Upload File Details By fileId(Starts) */

	public ResultSet getUploadFiles(int fileId)
	{
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_file_upload where f_code='"+fileId+"'";
			System.out.println("@@@@@@@@@@@ Upload Info @@@@@@@@@@@@@@@");
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getUploadFiles() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Upload File Details By fileId(Ends) */
	
/* Delete Uploaded File Details (Starts) */
	
	public boolean deleteUploadedFiles(int uploadId) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "delete from m_file_upload where f_code='"+uploadId+"'";
			System.out.println("******* Delete Uploaded File Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Delete UploadedFile Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUploadedFiles(int uploadId) :" );
			e.printStackTrace();
		}
		return flag;
	}
	
/*  Delete Uploaded File Details (Ends) */
	

/* Get Max User ID(Starts)*/	
	
	public int getMaxUserID()
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select max(u_code) from m_user");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("Max User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO--> getMaxUserID(): ");
			e.printStackTrace();
		}
		return i;
	}
	
/* Get Max User ID(Ends)*/	
	

	
/* Get File Name(Starts) */
	
	public String getFileName(int fileId)
	{
		String fileName="";
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select f_name from m_file_upload where f_code='"+fileId+"'";
			System.out.println("****** Get File Name By Id *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				fileName=resultSet.getString(1);
			}
			
			System.out.println("File Id : "+fileId+"\nFile Name : " + fileName);
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getLastKeyUpdatedDate(): ");
			e.printStackTrace();
		}
		return fileName;
	}
	
/* Get File Name(Ends) */
	
/* Get Upload File Details(Starts) */

	public boolean downloadAuthentication(int fileId,int deptId,int designationId)
	{
		boolean flag = false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_acess_control where f_code='"+fileId+"' and dept_code='"+deptId+"' and desig_code='"+designationId+"'";
			System.out.println("*********** Login Authentication Info **************");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag = true;
			}
			
			System.out.println("Download Authentication Status : " + flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-downloadAuthentication() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Get Upload File Details(Ends) */

	
}
