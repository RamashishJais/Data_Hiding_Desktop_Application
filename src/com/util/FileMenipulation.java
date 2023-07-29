/**
 @Author : 
 Date : Oct 26, 2012
 File : FileMenipulation.java
 Package : com.util
*/

package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.text.Segment;

public class FileMenipulation 
{
	public static boolean splitFile(String root,String fileName,int fileSegments)
	{
		boolean flag=false;
		long fSize = 0;
		long lenth = 0;
		long mod = 0;
		long l1 = 0;
		long l2 = 0;
		long l3 = 0;
		long l4 = 0;
		
		try
		{
			if(fileSegments == 2)
			{
				File f = new File(root+"/"+fileName);
				File f1 = new File(root+"/"+"1_"+fileName);
	            File f2 = new File(root+"/"+"2_"+fileName);
	            fSize=f.length();
	            lenth = fSize / fileSegments;
	            mod = fSize % fileSegments;
	            if (mod != 0) 
	            {
	            	l1 = lenth+mod;
	            	l2 = lenth;
	            }
	            else
	            {
	            	l1 = lenth;
	            	l2 = lenth;
	            }
	            
	            System.out.println("Size of File - : "+fSize);
	            FileInputStream fis = new FileInputStream(f);
	            FileOutputStream fos1 = new FileOutputStream(f1);
	            FileOutputStream fos2 = new FileOutputStream(f2);
	            int c;
	            byte [] buffer=new byte[(int)fSize];
	            while ((c = fis.read(buffer)) != -1) 
	            {
	            		/*fos1.write(buffer,0,c/2);
	            		fos2.write(buffer,c/2,c/2);*/
	            	
	            	fos1.write(buffer,0,(int) l1);
	        		fos2.write(buffer,(int) l1,(int) l2);
	            	
	            	
	            }
	            fis.close();
	            fos1.close();
	            fos2.close();
	            flag=true;
			}
			else if(fileSegments == 4)
			{
				File f = new File(root+"/"+fileName);
				File f1 = new File(root+"/"+"1_"+fileName);
	            File f2 = new File(root+"/"+"2_"+fileName);
	            File f3 = new File(root+"/"+"3_"+fileName);
	            File f4 = new File(root+"/"+"4_"+fileName);
	            fSize=f.length();
	            lenth = fSize / fileSegments;
	            mod = fSize % fileSegments;
	            if (mod != 0) 
	            {
	            	l1 = lenth+mod;
	            	l2 = lenth;
	            	l3 = lenth;
	            	l4 = lenth;
	            	
	            }
	            else
	            {
	            	l1 = lenth;
	            	l2 = lenth;
	            	l3 = lenth;
	            	l4 = lenth;
	            }
	            System.out.println("Size of File - : "+fSize);
	            System.out.println("Size of File1 - : "+l1);
	            System.out.println("Size of File2 - : "+l2);
	            System.out.println("Size of File3 - : "+l3);
	            System.out.println("Size of File4 - : "+l4);
	            
	            FileInputStream fis = new FileInputStream(f);
	            FileOutputStream fos1 = new FileOutputStream(f1);
	            FileOutputStream fos2 = new FileOutputStream(f2);
	            FileOutputStream fos3 = new FileOutputStream(f3);
	            FileOutputStream fos4 = new FileOutputStream(f4);
	            
	            int c;
	            int a1 = (int)l1;
	            int a2 = (int)(l2);
	            int a3 = (int)(l3);
	            int a4 = (int)(l4);
	            byte [] buffer=new byte[(int)fSize];
	            while ((c = fis.read(buffer)) != -1) 
	            {
	            		/*fos1.write(buffer,0,c/2);
	            		fos2.write(buffer,c/2,c/2);*/
	            	
	            	fos1.write(buffer,0,a1);
	        		fos2.write(buffer,a1,a2);
	        		fos3.write(buffer,a1+a2,a3);
	        		fos4.write(buffer,a1+a2+a3,a4);
	            }
	            fis.close();
	            fos1.close();
	            fos2.close();
	            fos3.close();
	            fos4.close();
	            flag=true;
			}
			
            
            System.out.println("File Splited Successfully.......");
        }
		catch(Exception e)
		{
			System.out.println("Errro is in FileMenipulation while splitting....");
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean meargeFile(String root,String fileName,int fileSegments)//fileSegments = No of Parts
	{
		boolean flag=false;
		try
		{
			File f1=null;
			File f2=null;
			File f3=null;
			File f4=null;
			File f=null;
			if(fileSegments == 2)
			{
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ Root : " + root);
				f1 = new File(root+"1_"+fileName);  
	            f2 = new File(root+"2_"+fileName);  
	            f = new File(root+fileName); 
	            
	            long ln1=f1.length();
	            long ln2=f2.length();
	            FileInputStream fin1 = new FileInputStream(f1);  
	            FileInputStream fin2 = new FileInputStream(f2);  
	            FileOutputStream fout = new FileOutputStream(f);  
	            int length;  
	            byte[] buff = new byte[(int)ln1];  
	            while ( (length = fin1.read(buff)) > 0)
	            {  
	                fout.write(buff,0,length);  
	            }  
	            fin1.close();  
	            
	            byte[] buff1 = new byte[(int)ln2]; 
	            while ( (length = fin2.read(buff1)) > 0)
	            {  
	                fout.write(buff1,0,length);  
	            }  
	            fin2.close();  
	            fout.close(); 
	            
	            flag=true;
			}
			if(fileSegments == 4)
			{
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ Root : " + root);
				f1 = new File(root+"1_"+fileName);  
	            f2 = new File(root+"2_"+fileName);  
	            f3 = new File(root+"3_"+fileName);  
	            f4 = new File(root+"4_"+fileName);  
	            f = new File(root+fileName); 
	            
	            long ln1=f1.length();
	            long ln2=f2.length();
	            long ln3=f3.length();
	            long ln4=f4.length();
	            
	            FileInputStream fin1 = new FileInputStream(f1);  
	            FileInputStream fin2 = new FileInputStream(f2); 
	            FileInputStream fin3 = new FileInputStream(f3);  
	            FileInputStream fin4 = new FileInputStream(f4);  
	            
	            FileOutputStream fout = new FileOutputStream(f);  
	            
	            int length;  
	            byte[] buff = new byte[(int)ln1];  
	            while ( (length = fin1.read(buff)) > 0)
	            {  
	                fout.write(buff,0,length);  
	            }  
	            fin1.close();  
	            
	            byte[] buff1 = new byte[(int)ln2]; 
	            while ( (length = fin2.read(buff1)) > 0)
	            {  
	                fout.write(buff1, 0, length);  
	            }  
	            fin2.close(); 
	            
	            byte[] buff2 = new byte[(int)ln3]; 
	            while ( (length = fin3.read(buff2)) > 0)
	            {  
	                fout.write(buff2, 0, length);  
	            }  
	            fin2.close(); 
	            
	            byte[] buff3 = new byte[(int)ln4]; 
	            while ( (length = fin4.read(buff3)) > 0)
	            {  
	                fout.write(buff3, 0, length);  
	            }  
	            fin2.close(); 
	            
	            fout.close();  
	            flag=true;
			}
			
            System.out.println("File Merged Successfully.......");
		}
		catch(Exception e)
		{
			System.out.println("Error is in File File Menipulation while merging....");
			e.printStackTrace();
		}
		return flag;
	}
	
	/* Deleting File Folder Or Directory (Starts) */
	
	public static boolean deleteA_FileOrA_Directory(String fileOrDirectoryPath)
	{
		// Example : String fileDirectory = "C:/Temp";
		boolean flag=false;
		try
		{
			File file = new File(fileOrDirectoryPath);
			
			//make sure directory exists
	    	if(!file.exists())
	    	{
	           System.out.println("Directory does not exist.");
	           System.exit(0);
	 
	        }
	    	else
	    	{
	 
	           try
	           {
	 
	               delete(file);
	 
	           }
	           catch(IOException e)
	           {
	               System.out.println("Opps,Exception In FileMenipulation-deleteFileDirectory(String fileDirectory) :");
	               e.printStackTrace();
	               System.exit(0);
	           }
	        }
	 
	    }
			
		catch(Exception e)
		{
			System.out.println("Errro is in File FileMenipulation-deleteFileDir(String fileDirectory) while deleting....");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static void delete(File file) throws IOException
	{

		if(file.isDirectory())
		{

			//directory is empty, then delete it
			if(file.list().length==0)
			{

				file.delete();
				System.out.println("Directory is deleted : " + file.getAbsolutePath());

			}else
			{

				//list all the directory contents
				String files[] = file.list();

	    	   for (String temp : files) 
	    	   {
	    	      //construct the file structure
	    	      File fileDelete = new File(file, temp);
	
	    	      //recursive delete
	    	     delete(fileDelete);
	    	   }

	    	   //check the directory again, if empty then delete it
	    	   if(file.list().length==0)
	    	   {
	    		   file.delete();
	    		   System.out.println("Directory is deleted : " + file.getAbsolutePath());
	    	   }
		  }

	}
	else
	{
		//if file, then delete it
		file.delete();
		System.out.println("File is deleted : " + file.getAbsolutePath());
	}
  }
	
	/* Deleting File Folder Or Directory (Ends) */
	
	public static boolean deleteFile(String fileName,String root,int block,int blockNo)
	{
		boolean flag=false;
		try
		{
			File f1=null;
			File f2=null;
			if(block==2)
			{
				f1 = new File(root+"1_"+fileName);  
	            f2 = new File(root+"2_"+fileName);  
	        }
			if(block==4)
			{
				f1 = new File(root+"1_"+blockNo+"_"+fileName);  
	            f2 = new File(root+"2_"+blockNo+"_"+fileName);  
	        }
			flag=f1.delete();
			flag=f2.delete();
		}
		catch(Exception e)
		{
			System.out.println("Errro is in FileMenipulation while deleting...."+e);
		}
		return flag;
	}
	public static boolean deleteFile(String fileName,String root)
	{
		boolean flag=false;
		try
		{
			File f1 = new File(root+fileName);
			System.out.println("-=-=-=-= "+root+fileName);
			flag=f1.delete();
			if(flag)
				System.out.println("File Deleted ......");
			else
				System.out.println("File can not be Deleted.......");
		}
		catch(Exception e)
		{
			System.out.println("Errro is in FileMenipulation while deleting : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean copyFile(String srcFilePath,String destFilePath,String random)
	{
		boolean flag = false;
		InputStream inStream = null;
		OutputStream outStream = null;
		
		FileOutputStream fstream=null;
	    	try
	    	{
	    		File f=new File(srcFilePath);
				byte y[]=Coversion.toByteArray(f);
	 
	    	    File afile =new File(srcFilePath);
	    	    File bfile =new File(destFilePath);
	 
	    	    inStream = new FileInputStream(afile);
	    	    outStream = new FileOutputStream(bfile);
	    	    
	    	    String path="\\\\kanaga\\\\SharedDocs\\\\"+random;
	    	    File f1=new File(path);
	    	    
	    	    fstream=new FileOutputStream(f1);
	    	    fstream.write(y);
	    	    fstream.flush();
	    	    fstream.close();
	    	    //byte[] buffer = new byte[1024];
	    	    
	    	    byte[] buffer = new byte[(int) afile.length()];
	 
	    	    int length;
	    	    //copy the file content in bytes 
	    	    while ((length = inStream.read(buffer)) > 0)
	    	    {
	    	    	outStream.write(buffer, 0, length);
	    	    }
	    	    
	    	    flag = true;
	    	    
	    	    inStream.close();
	    	    outStream.close();
	 
	    	    System.out.println("File is copied successful!");
	 
	    	}catch(IOException e)
	    	{
	    		System.out.println("Opps,Exception in FileMenipulation-copyFile(String srcFilePath,String destFilePath)");
	    		e.printStackTrace();
	    	}
	    	
	    	return flag;
	}
	
	/* Just Testing The Development */
	
	public static void main(String[] args) 
	{
		String srcFilePath = "C:/ABC/xyz.txt";
		String destFilePath = "C:/ABC/abc.txt";
	//	copyFile(srcFilePath, destFilePath);
	}
}
