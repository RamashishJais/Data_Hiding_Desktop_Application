package com.util;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;
public class AlterImage 
{
	/* Splitting Red Image Into 2 Parts*/
	public static void splitRedImage(BufferedImage redImage,String divisionPath,String fileName)
	{
		
		int width = redImage.getWidth();
        int height = redImage.getHeight();
       
    	BufferedImage I1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage I2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        WritableRaster wr1 = I1.getRaster();
        WritableRaster wr2 = I2.getRaster();
        
        int[] a = new int[4];
        int[] b = new int[4];
        
        int R,randR,R1,R2;
        
		Random rnd = new Random();
		
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = redImage.getRGB(i, j);
            	a = getARGBPixelData(pixel);
            	b = getARGBPixelData(pixel);
            	
            	R = a[0];//Red
            	if(R>0)
            	{
            		randR = rnd.nextInt(R);
                	R1 = R - randR;
                	R2 = randR;
            	}
            	else
            	{
            		R1 = 0;
                	R2 = 0;
            	}
            	
            	a[0] = R1;
            	b[0] = R2;
            	
               
                wr1.setPixel(i, j, a);
                wr2.setPixel(i, j, b);
                
                
              
            }
        }
        try 
        {
        	//ImageIO.write(I1, "jpg", new File("C:\\TestImage\\red_img1.jpg"));
        	//ImageIO.write(I2, "jpg", new File("C:\\TestImage\\red_img2.jpg"));
        	
        	ImageIO.write(I1, "bmp", new File(divisionPath+"red_div1_"+fileName));//
        	ImageIO.write(I2, "bmp", new File(divisionPath+"red_div2_"+fileName));//
        }
        catch (IOException e)
        {
        	System.err.println("Opps,Exception in AltertImage-splitRedImage(BufferedImage image) : ");
        	e.printStackTrace();
        }
       
	}
	
	
	/* Splitting Green Image Into 2 Parts*/
	public static void splitGreenImage(BufferedImage greenImage,String divisionPath,String fileName)
	{
		
		int width = greenImage.getWidth();
        int height = greenImage.getHeight();
       
    	BufferedImage I1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage I2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster wr1 = I1.getRaster();
        WritableRaster wr2 = I2.getRaster();
        int[] a = new int[4];
        int[] b = new int[4];
        int G=0,randG,G1=0,G2=0;
		Random rnd = new Random();
		
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = greenImage.getRGB(i, j);
            	a = getARGBPixelData(pixel);
            	b = getARGBPixelData(pixel);
            	
            	G = a[1];
            	
            	if(G > 0)
            	{
	            	randG = rnd.nextInt(G);
	            	G1 = G - randG;
	            	G2 = randG;
            	}
            	else
            	{
            		G1 = 0;
            		G2 = 0;
            	}
            	
            	a[1] = G1;
            	b[1] = G2;
               
                wr1.setPixel(i, j, a);
                wr2.setPixel(i, j, b);
                
                
              
            }
        }
        try 
        {
        	//ImageIO.write(I1, "jpg", new File("C:\\TestImage\\green_img1.jpg"));
        	//ImageIO.write(I2, "jpg", new File("C:\\TestImage\\green_img2.jpg"));
        	
        	ImageIO.write(I1, "bmp", new File(divisionPath+"green_div1_"+fileName));
        	ImageIO.write(I2, "bmp", new File(divisionPath+"green_div2_"+fileName));
        }
        catch (IOException e)
        {
        	System.err.println("Opps,Exception in AltertImage-splitGreenImage(BufferedImage image) : ");
        	e.printStackTrace();
        }
       
	}
	
	/* Splitting Blue Image Into 2 Parts*/
	public static void splitBlueImage(BufferedImage blueImage,String divisionPath,String fileName)
	{
		
		int width = blueImage.getWidth();
        int height = blueImage.getHeight();
       
    	BufferedImage I1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage I2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster wr1 = I1.getRaster();
        WritableRaster wr2 = I2.getRaster();
        int[] a = new int[4];
        int[] b = new int[4];
        int B,randB,B1,B2;
		Random rnd = new Random();
		
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = blueImage.getRGB(i, j);
            	a = getARGBPixelData(pixel);
            	b = getARGBPixelData(pixel);
            	
            	B = a[2];
            	
            	if (B > 0 )
            	{
	            	randB = rnd.nextInt(B);
	            	B1 = B - randB;
	            	B2 = randB;
            	}
            	else
            	{
            		B1 = 0;
            		B2 = 0;
            	}
            	
            	a[2] = B1;
            	b[2] = B2;
               
                wr1.setPixel(i, j, a);
                wr2.setPixel(i, j, b);
                
            }
        }
        try 
        {
        	//ImageIO.write(I1, "jpg", new File("C:\\TestImage\\blue_img1.jpg"));
        	//ImageIO.write(I2, "jpg", new File("C:\\TestImage\\blue_img2.jpg"));
        	
        	ImageIO.write(I1, "bmp", new File(divisionPath+"blue_div1_"+fileName));
        	ImageIO.write(I2, "bmp", new File(divisionPath+"blue_div2_"+fileName));
        }
        catch (IOException e)
        {
        	System.err.println("Opps,Exception in AltertImage-splitBlueImage(BufferedImage image) : ");
        	e.printStackTrace();
        }
       
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
	
		/*
		 * it's a so-called mask.. The thing is, you get the RGB value all in one integer, with one byte for each component..
		 *  Something like 0xAARRGGBB (alpha, red, green, blue). By and-ing with 0xFF, you keep just the last part, which is blue. For other channels, you'd use:
		 */
		}
		catch(Exception e)
		{
			System.out.println("Opps,Exception in AlterImage-getARGBPixelData(int pixel) : ");
			e.printStackTrace();
			
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
        	System.out.println("Opps,Exception in AlterImage-readImage(String fileLocation) : ");
            e.printStackTrace();
        }
        return img;
    }
	
	
	/* Testing The Development */
	
	public static void main(String[] args) 
	{
		/*
		String srcfilePath = "C:\\TestImage\\image1.jpg";
		String srcfilePath1 = "C:\\TestImage\\image2.jpg";
		String srcfilePath2 = "C:\\TestImage\\image3.jpg";
		*/
		String srcfilePath = "C:\\TestImage\\image1.bmp";
		String srcfilePath1 = "C:\\TestImage\\image2.bmp";
		String srcfilePath2 = "C:\\TestImage\\image3.bmp";
		
		
		BufferedImage img = null;
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		
		img =readImage(srcfilePath);
		img1 =readImage(srcfilePath1);
		img2 =readImage(srcfilePath2);
		
		//splitRedImage(img);
		//splitGreenImage(img1);
		//splitBlueImage(img2);
		
		System.out.println("Done...");
		
	}
}
