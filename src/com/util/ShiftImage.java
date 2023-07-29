package com.util;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class ShiftImage 
{
	public static void main(String asadf[])throws IOException
	{
		/*BufferedImage img1=ImageProcess.readImage("group1.jpg");
		BufferedImage img2=ImageProcess.readImage("group2.jpg");//Key Image
		
		//Column Shuffuling
		coloumShift(img1,img2,"F"); // F = Forward
		
		//Row Shuffuling
		BufferedImage img3=ImageProcess.readImage("F_Col_Out.jpg");
		rowShift(img3,img2,"F");
		
		//Row Re-Shuffuling
		BufferedImage img4=ImageProcess.readImage("F_Row_Out.jpg");
		rowShift(img4,img2,"R"); // R = Reverse
		
		//Column Re-Shuffuling
		BufferedImage img5=ImageProcess.readImage("R_Row_Out.jpg");
		coloumShift(img5,img2,"R");
		*/
		
		System.out.println("Column Shift Revert Back Successfully...");
	}
	
	public static void coloumShift(BufferedImage img,BufferedImage imgx, String xPro,int colorPixelIndex,String shufflingPath,int imgPart,String fileExtension)
	{
		try
		{
			String imgColor="";
			if(colorPixelIndex == 0)
			{
				imgColor="R";//R = Red 
			}
			if(colorPixelIndex == 1)
			{
				imgColor="G";//G = Green 
			}
			if(colorPixelIndex == 2)
			{
				imgColor="B";//B = Blue 
			}
			
			int width = img.getWidth();
			int height = img.getHeight();
			//System.out.println("Width (Columns): " +width);
			//System.out.println("Height (Rows): " + height);
			BufferedImage I1 = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			WritableRaster wr1 = I1.getRaster();
			int[] a = new int[4];
			int[] b = new int[4];
			int odd_c = 0;
			int even_c = width - 1 ;
			int jj = width /2;
			int c = 0;
			for (int i = 0; i < width; i++)
	        {
				int pixel2 = imgx.getRGB(i,jj);
				b=getARGBPixelData(pixel2);	
				
				if (b[colorPixelIndex] % 2 == 0) //b[1] i.e based on green & colorPixelIndex = 0(Red) or 1(Green) or 2(Blue)
				{
					c = even_c;
					even_c--;
				}
				else
				{
					c = odd_c;
					odd_c++;
				}
				if (xPro == "F")
				{
					
				for (int j =0; j < height; j++) 
				{
					int pixel1 = img.getRGB(i,j);
					a=getARGBPixelData(pixel1);	
					wr1.setPixel(c,j,a);
				}
				}
				
				
				if (xPro == "R")
				{
					
					for (int j =0; j < height; j++) 
					{
						int pixel1 = img.getRGB(c,j);
						a=getARGBPixelData(pixel1);	
						wr1.setPixel(i,j,a);
					}
				}

			}
			if (xPro == "F") ImageIO.write(I1, "jpg", new File(shufflingPath+"pre_S"+imgColor+imgPart+fileExtension));
			if (xPro == "R") ImageIO.write(I1, "jpg", new File(shufflingPath+"RS"+imgColor+imgPart+fileExtension));
	    System.out.println("Done..................");       
		}
			
		catch(Exception e)
		{
			System.out.println("Opps,Exception In Test=>rotateImg(BufferedImage img) : ");
			e.printStackTrace();
		}
	}
	
	public static void rowShift(BufferedImage img,BufferedImage imgx, String xPro,int colorPixelIndex,String shufflingPath,int imgPart,String fileExtension)
	{
		try
		{
			String imgColor="";
			
			if(colorPixelIndex == 0)
			{
				imgColor="R";//R = Red 
			}
			if(colorPixelIndex == 1)
			{
				imgColor="G";//G = Green 
			}
			if(colorPixelIndex == 2)
			{
				imgColor="B";//B = Blue 
			}
			
			
			int width = img.getWidth();
			int height = img.getHeight();
			
			System.out.println("Width (Columns): " +width);
			System.out.println("Height (Rows): " + height);
			
			BufferedImage I1 = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			WritableRaster wr1 = I1.getRaster();
			int[] a = new int[4];
			int[] b = new int[4];
			int odd_c = 0;
			int even_c = height - 1 ;
			int jj = height / 2;
			
			int c = 0;
			for (int i = 0; i < height; i++)
	        {
				int pixel2 = imgx.getRGB(jj,i);
				b=getARGBPixelData(pixel2);	
				
				if (b[1] % 2 == 0) //b[1] i.e based on green
				{
					c = even_c;
					even_c--;
				}
				else
				{
					c = odd_c;
					odd_c++;
				}
					
				if (xPro =="F")
				{
					for (int j =0; j < width; j++) 
					{
						int pixel1 = img.getRGB(j,i);
						a=getARGBPixelData(pixel1);	
						wr1.setPixel(j,c,a);
					}
				}
				
				if (xPro =="R")
				{
					for (int j =0; j < width; j++) 
					{
						int pixel1 = img.getRGB(j,c);
						a=getARGBPixelData(pixel1);	
						wr1.setPixel(j,i,a);
					}
				}
				
				
			}
			
			if (xPro == "F") ImageIO.write(I1, "bmp", new File(shufflingPath+"S"+imgColor+imgPart+fileExtension));
			if (xPro == "R") ImageIO.write(I1, "bmp", new File(shufflingPath+"pre_RS"+imgColor+imgPart+fileExtension));
	    
	    System.out.println("Done..................");       
		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception In Test=>rotateImg(BufferedImage img) : ");
			e.printStackTrace();
		}
	}
	
	/* Getting The Column Shift Back (Starts) */
	
	public static void getcoloumShiftBack(BufferedImage img,BufferedImage imgx)
	{
		try
		{
			int width = img.getWidth();
			int height = img.getHeight();
			System.out.println("Width (Columns): " +width);
			System.out.println("Height (Rows): " + height);
			BufferedImage I1 = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			WritableRaster wr1 = I1.getRaster();
			int[] a = new int[4];
			int[] b = new int[4];
			int odd_c = 0;
			int even_c = width - 1 ;
			int jj = width /2; 
			int c = 0;
			for (int i = 0; i < width; i++)
	        {
				int pixel2 = imgx.getRGB(i,jj);
				b=getARGBPixelData(pixel2);	
				
				if (b[1] % 2 == 0) //b[1] i.e based on green
				{
					c = even_c;
					even_c--;
				}
				else
				{
					c = odd_c;
					odd_c++;
				}
					
					
				for (int j =0; j < height; j++) 
				{
					int pixel1 = img.getRGB(i,j);
					a=getARGBPixelData(pixel1);	
					wr1.setPixel(c,j,a);
				}
				
			}
	    ImageIO.write(I1, "bmp", new File("ColBack.jpg"));
	    System.out.println("Done..................");       
		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception In Test=>rotateImg(BufferedImage img) : ");
			e.printStackTrace();
		}
	}
	
	/* Getting The Column Shift Back (Ends) */
	
	
	/* Getting The Row Shift Back (Starts) */
	
	public static void getrowShiftBack(BufferedImage img,BufferedImage imgx)
	{
		try
		{
			int width = img.getWidth();
			int height = img.getHeight();
			System.out.println("Width (Columns): " +width);
			System.out.println("Height (Rows): " + height);
			BufferedImage I1 = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			WritableRaster wr1 = I1.getRaster();
			int[] a = new int[4];
			int[] b = new int[4];
			int odd_c = 0;
			int even_c = height - 1 ;
			int jj = height / 2;
			int c = 0;
			for (int i = 0; i < height; i++)
	        {
				int pixel2 = imgx.getRGB(jj,i);
				b=getARGBPixelData(pixel2);	
				
				if (b[1] % 2 == 0) //b[1] i.e based on green
				{
					c = even_c;
					even_c--;
				}
				else
				{
					c = odd_c;
					odd_c++;
				}
					
					
				for (int j =0; j < width; j++) 
				{
					int pixel1 = img.getRGB(j,i);
					a=getARGBPixelData(pixel1);	
					wr1.setPixel(j,c,a);
				}
				
				
			}
	    ImageIO.write(I1, "bmp", new File("RowBack.jpg"));
	    System.out.println("Done..................");       
		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception In Test=>rotateImg(BufferedImage img) : ");
			e.printStackTrace();
		}
	}
	
	/* Getting The Row Shift Back (Ends) */
	
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
