package com.user.util;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class HideProcess 
{
	public static boolean hideProcess(BufferedImage image,String key,String msg,String outFilePath)
	{
		boolean flag = false;
		String key_binary[]=HideProcess.getBinary(key);
		String msg_binary[]=HideProcess.getBinary(msg);
		int[][] imageMatrix=HideProcess.imageMatrix(image,key_binary,msg.length());
		
		
		
		// Printing The Matrix Value
		int width = image.getWidth();
		int height = image.getHeight();
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<height;j++)
			{
				System.out.print(imageMatrix[i][j]);
			}
		System.out.println();
		}
		
		
		if(imageMatrix!=null)
		{
			HideProcess.hideProcess(image,imageMatrix,msg_binary,outFilePath);
			System.out.println("Data Hiding Process Done Successfully .....!");
			flag = true;
		}
		else
			System.err.println("Opp's Somthing went wrong........!");
		
		return flag;
	}
	
	public static String [] getBinary(String str)
	{
		String a[]=new String[str.length()];
		for(int i=0;i<str.length();i++)
		{
			a[i]=Integer.toBinaryString(str.charAt(i));
			if(a[i].length()==0 || a[i].length()==1 || a[i].length()==2 || a[i].length()==3 || a[i].length()==4 || a[i].length()==5 || a[i].length()==6 || a[i].length()==7)
			{
				String zero="";
				int how_many=8-a[i].length();
				for(int j=0;j<how_many;j++)
					zero+="0";
				a[i]=zero+a[i];
			}
//			System.out.println(str.charAt(i)+"------->"+a[i]);
		}
		return a;
	}
	
	public static int[][] imageMatrix(BufferedImage image,String key_binary[],int msglength)
	{
		boolean process_status=false;
		boolean flag=false;
		int width = image.getWidth();
		int height = image.getHeight();
		//System.out.println("Image Width : " + width);
		//System.out.println("Image Height : " + height);
		
		int p_mat[][]=new int[4][4];
		int index=0;//key_binary [] index
		int v=0;//column of img_mat
		int img_mat[][]=new int[width][height];
		for (int i = 0; i < width; i++)
	    {
	         for (int j = 0; j < height; j++) 
	         {
	        	 img_mat[i][j]=0;
	         }
	    }
		for (int i = 0; i < width/2; i++)
		{
			for(int j=0;j<=1;j++)
			{
				if(i%2==0)
				{
					p_mat[0][0]=Integer.parseInt(key_binary[index].substring(0,1));
					p_mat[0][1]=Integer.parseInt(key_binary[index].substring(1,2));
					p_mat[1][0]=Integer.parseInt(key_binary[index].substring(2,3));
					p_mat[1][1]=Integer.parseInt(key_binary[index].substring(3,4));
				}
				else
				{
					p_mat[0][0]=Integer.parseInt(key_binary[index-1].substring(4,5));
					p_mat[0][1]=Integer.parseInt(key_binary[index-1].substring(5,6));
					p_mat[1][0]=Integer.parseInt(key_binary[index-1].substring(6,7));
					p_mat[1][1]=Integer.parseInt(key_binary[index-1].substring(7,8));
				}
				
				System.out.println("======> i,v = " +i+","+v );
				img_mat[i][v]=p_mat[0][0];
				img_mat[i][v+1]=p_mat[0][1];
				img_mat[i+1][v]=p_mat[1][0];
				img_mat[i+1][v+1]=p_mat[1][1];
				
				if(index==key_binary.length)
					flag=true;
				
			}
			v++;v++;
			
			if(index!=key_binary.length && i%2==0)
				index++;
			if(flag)//Start reapting 
			{
				flag=false;
				index=0;
			}
			if((msglength*2)<=getOnes(img_mat,width,height))//Add no of ones needed to hide message
			{
				process_status=true;
				break;
			}
		}
		if(process_status)
			return img_mat;
		else
			return null;
	}
	

	public static boolean hideProcess(BufferedImage image,int[][] imageMatrix,String msg_binary[],String outFilePath)
	{
		boolean result = false;
		int index=0;//index of msg_binary[]
		int index1=0;
		int width = image.getWidth();
		int height = image.getHeight();
		int[] pix_color = new int[4];
		BufferedImage I1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster wr1 = I1.getRaster();
		String msg_bits="";
		System.out.println(" msg_binary : "+msg_binary.length);
		for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = image.getRGB(i, j);
            	pix_color=getARGBPixelData(pixel);
            
            if(imageMatrix[i][j]==1)
            
            {
            	if((index1)<(msg_binary.length)*2)
            	{
            		System.out.println(" imageMatrix[i][j]  : "+imageMatrix[i][j]);
            		System.out.println(i+"-"+j);
            		System.out.println(" (msg_binary.length)*2 : "+(msg_binary.length)*2+" index1 :"+index1);
          		
            		if(index1%2==0)
            		{
            			msg_bits=msg_binary[index].substring(0,1);
            			msg_bits+=msg_binary[index].substring(1,2);
            			msg_bits+=msg_binary[index].substring(2,3);
            			msg_bits+=msg_binary[index].substring(3,4);
            		}
            		else
            		{
            			msg_bits=msg_binary[index-1].substring(4,5);
            			msg_bits+=msg_binary[index-1].substring(5,6);
            			msg_bits+=msg_binary[index-1].substring(6,7);
            			msg_bits+=msg_binary[index-1].substring(7,8);
            		}
//            		for (int k = 0; k < pix_color.length; k++)
//            			System.out.print("--"+pix_color[k]);
            		System.out.println(" msg_bits :"+msg_bits);
            		String pix_binary=getBinary(pix_color[2]);
//            		System.out.println("Original channel===>"+pix_binary);
            		String new_pix_binary=replace(pix_binary,4,msg_bits.charAt(0));
            		new_pix_binary=replace(new_pix_binary,5,msg_bits.charAt(1));
            		new_pix_binary=replace(new_pix_binary,6,msg_bits.charAt(2));
            		new_pix_binary=replace(new_pix_binary,7,msg_bits.charAt(3));
//            		System.out.println("New Channel------->"+new_pix_binary);
            		pix_color[2]=Integer.parseInt(new_pix_binary, 2);
//            		pix_color[0]=0;pix_color[1]=0;pix_color[2]=0;pix_color[3]=0;
//            		for (int k = 0; k < pix_color.length; k++)
            		System.out.print("=="+new_pix_binary);
//            		System.out.println();
      				System.out.println();
            		wr1.setPixel(i, j, pix_color);
            		if(index1%2==0)
            			index++;
            		index1++;
            		System.out.println(" index1 :"+index1+" index :"+index);
            	}
            	}
            	else
            		wr1.setPixel(i, j, pix_color);
            }
        }
		try 
	    {
	      	//ImageIO.write(I1, "png", new File("secretImage.jpg"));
			 //ImageIO.write(I1, "png", new File("C:/ABC/Image/out.jpg"));
			//ImageIO.write(I1, "png", new File("C:/ABC/ImgEnc/enc_out.jpg"));
			ImageIO.write(I1, "png", new File(outFilePath));
	      	result=true;
	    }
	    catch (IOException e)
	    {
	       	System.err.println("image not saved.");
	    }
	    return result;
	}
	
	public static int getOnes(int Imat[][],int width,int height)
	{
		int count=0;
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++) 
            {
				if(Imat[i][j]==1)
					count++;
			}
		}
		return count;
	}
	
	public static String replace(String str, int index, char replace)
	{     
	    char[] chars = str.toCharArray();
	    chars[index] = replace;
	    return String.valueOf(chars);       
	}
	
	public static String getBinary(int no)
	{
		String str=Integer.toBinaryString(no);
		for(int i=0;i<str.length();i++)
		{
			if(str.length()==0 || str.length()==1 || str.length()==2 || str.length()==3 || str.length()==4 || str.length()==5 || str.length()==6 || str.length()==7)
			{
				String zero="";
				int how_many=8-str.length();
				for(int j=0;j<how_many;j++)
					zero+="0";
				str=zero+str;
			}
		}
//		System.out.println("--->"+str);
		return str;
	}
	
	public static int[] getARGBPixelData(int pixel)
	{
		int[] a = new int[4];
		try
		{
			int alpha = (pixel >> 24) & 0x000000FF;
			int red = (pixel >> 16) & 0x000000FF;
			int green = (pixel >>8 ) & 0x000000FF;
			int blue = (pixel) & 0x000000FF;
			a[0]=red;
        	a[1]=green;
        	a[2]=blue;
        	a[3]=alpha;
//        	for (int k = 0; k < a.length; k++)
//    			System.out.print("-"+a[k]);
//        	System.out.println();
		}
		catch(Exception e)
		{
			System.out.println("Error is in ImageProcess getARGBPixelData(int pixel) "+e);
		}
		return a;
	}
	public static BufferedImage readImage(String fileLocation)
	{
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File(fileLocation));
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return img;
    }
	public static String[] extractProcess(BufferedImage image,int[][] imageMatrix)
	{
		int index=0;
		int count=1;
		int width = image.getWidth();
		int height = image.getHeight();
		int[] pix_color = new int[4];
		int ones=HideProcess.getOnes(imageMatrix, image.getWidth(), image.getHeight());
		String [] msg=new String[ones/2];
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = image.getRGB(i, j);
            	pix_color=getARGBPixelData(pixel);
            	if(imageMatrix[i][j]==1)
            	{
//            		for (int k = 0; k < pix_color.length; k++)
//            			System.out.print("--"+pix_color[k]);
//                	System.out.println();
            		String pix_binary=getBinary(pix_color[2]);
            		sb.append(pix_binary.substring(4,5));
            		sb.append(pix_binary.substring(5,6));
            		sb.append(pix_binary.substring(6,7));
            		sb.append(pix_binary.substring(7,8));
            		if(count==0)
            		{
            			msg[index]=sb.toString().trim();
            			sb.delete(0, sb.length());
            			index++;
            			System.out.println(" index :"+index);
            			count=1;
            		}
            		else
            		{
            			count=0;
            		}
            		
            	}
            }
        }
//		for (int k = 0; k < msg.length; k++)
//			System.out.println("--"+(char)Integer.parseInt(msg[k],2));
		return msg;
	}
	public static String extractProcess(BufferedImage image,String key,int length)
	{
		String data = "";
		String key_binary[]=HideProcess.getBinary(key);
		int[][] imageMatrix1=HideProcess.imageMatrix(image,key_binary,length);
		String msg1[]=HideProcess.extractProcess(image,imageMatrix1);
		for (int k = 0; k < msg1.length; k++)
		{
			System.out.print((char)Integer.parseInt(msg1[k],2));
			data +=(char)Integer.parseInt(msg1[k],2);
			
			System.out.println("Extracted Data : " + data);
		}
		
		return data;
	}
	
/* Testing The Deve */	
	
	public static void main(String asdf[])throws IOException
	{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String inFilePath = "";
		String outFilePath = "";
		String key = "";
		String data = "";
		BufferedImage img = null;
		
		
		// Hiding The Data In Image
		inFilePath = "C:/ABC/Image/baby.jpg";
		outFilePath = "C:/ABC/ImgEnc/enc_out.jpg";
		img = HideProcess.readImage(inFilePath);
		System.out.print("Enter The Data Hiding Key : ");
		key=br.readLine();
		System.out.print("Enter The Text Data To Hide : ");
		data=br.readLine();
		hideProcess(img,key,data,outFilePath);
		
		
		// Extracting  The Data From Image
		inFilePath = "C:/ABC/ImgEnc/enc_out.jpg";
		//inFilePath = "C:/ABC/Image/out.jpg";
		img = HideProcess.readImage(inFilePath);
		System.out.print("Enter The Data Extraction Key : ");
		key=br.readLine();
		System.out.print("Enter The Text Data (For lenth Purpose) : ");
		data=br.readLine();
		System.out.print("Extracted Data : ");
		extractProcess(img,key,data.length());
		
		
		
	   
	}
}
