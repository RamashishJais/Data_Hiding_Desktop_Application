package com.util;

import java.io.*;

public class Coversion 
{
	public static byte[] toByteArray(File file) 
    {  
        int length = (int) file.length();  
        byte[] array = new byte[length];  
        InputStream in;
		try 
		{
			in = new FileInputStream(file);
			int offset = 0;  
	        while (offset < length) 
	        {  
	            offset += in.read(array, offset, (length - offset));  
	        }  
	        in.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}  
          
        return array;  
    }  
}
