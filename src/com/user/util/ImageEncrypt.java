package com.user.util;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;


public class ImageEncrypt 
{
	public static int R=4;
	public static void main(String asdf[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String inFilePath = "";
		String outFilePath = "";
		BufferedImage img = null;
//		System.out.println("Please Enter the photo name....");
//		String source=br.readLine();
		System.out.println("Enter The Key");
		String key=br.readLine();
		int xor=XOR(key);

		
		/*
		//Encrypting The File
		inFilePath="C:/ABC/ImgEnc/baby.jpg";
		outFilePath="C:/ABC/ImgEnc/enc.jpg";
		img = readImage(inFilePath);
		processImage(img,xor,"Encrypt",outFilePath);
		System.out.println("Image Encrypted Successfully....");
		*/
		
		
		//Decrypting The Encrypted Image
		inFilePath="C:/ABC/ImgEnc/enc.jpg";
		outFilePath="C:/ABC/ImgEnc/dec.jpg";
		img = readImage(inFilePath);
		processImage(img,xor,"Decrypt",outFilePath);
		System.out.println("Image Decrypted Successfully....");
		
	}
	
	public static int XOR(String key) 
	{
		char a[]=key.toCharArray();
		char result = 0;
		for(int i=0;i<key.length();i++)
			result=(char) (result^a[i]);
		return result;
	}
	public static BufferedImage readImage(String fileLocation)
	{
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File(fileLocation));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return img;
    }
	
	public static void processImage(BufferedImage image,int xor,String type,String out)
	{
		int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage I1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster wr1 = I1.getRaster();
        int[] a = new int[4];
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = image.getRGB(i, j);
            	a=getARGBPixelData(pixel);
            	if(type.equalsIgnoreCase("Encrypt"))
            	{
            		a[0]=makeBinary(a[0]^xor,"Encrypt");
            		a[1]=makeBinary(a[1]^xor,"Encrypt");
            		a[2]=makeBinary(a[2]^xor,"Encrypt");
            		a[3]=makeBinary(a[3]^xor,"Encrypt");
            	}
            	else if(type.equalsIgnoreCase("Decrypt"))
            	{
            		a[0]=makeBinary(a[0],"Decrypt")^xor;
            		a[1]=makeBinary(a[1],"Decrypt")^xor;
            		a[2]=makeBinary(a[2],"Decrypt")^xor;
            		a[3]=makeBinary(a[3],"Decrypt")^xor;
            	}
            	wr1.setPixel(i, j, a);
            }
        }
        try
        {
        	ImageIO.write(I1, "png", new File(out));
        }
        catch(Exception e)
        {
        	System.err.println("image not saved.");
        }
	}
	public static int makeBinary(int no,String type)
	{
		int xor=0;
		String str=Integer.toBinaryString(no);
		String result="";
		if(str.length()<8)
		{
			String zero="";
			int how_many=8-str.length();
			for(int j=0;j<how_many;j++)
				zero+="0";
			result=zero+str;
		}
		else
			result=str;
		int condition=0;
		if(type.equalsIgnoreCase("Encrypt"))
			condition=R;
		else if(type.equalsIgnoreCase("Decrypt"))
			condition=8-R;
		for(int i=0;i<condition;i++)
			result=rotate(result);
		return Integer.parseInt(result,2);
	}
	
	public static String rotate(String str)
	{
		char temp[]=str.toCharArray();
		char t;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<temp.length;i++)
		{
			t=temp[i];
			temp[i]=temp[temp.length-1];
			temp[temp.length-1]=t;
			sb.append(temp[i]);
		}
		return sb.toString();
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
		}
		catch(Exception e)
		{
			System.out.println("Error is in ImageProcess getARGBPixelData(int pixel) "+e);
		}
		return a;
	}
}
