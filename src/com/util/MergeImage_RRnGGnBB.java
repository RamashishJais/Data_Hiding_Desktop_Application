package com.util;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;
public class MergeImage_RRnGGnBB 
{
	
	/* Merge Red Image(red_img1+red_img2 = red_img) */
	public static void mergeRedImage(BufferedImage image,BufferedImage image1,String outDestinationPath,String fileExtension)
	{
		
		int width = image.getWidth();
        int height = image.getHeight();
       
    	BufferedImage I1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster wr1 = I1.getRaster();
        int[] a = new int[4];
        int[] b = new int[4];
        int R;
        int pixel1 = 0;
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = image.getRGB(i, j);
            	pixel1 = image1.getRGB(i, j);
            	a = getARGBPixelData(pixel);
            	b = getARGBPixelData(pixel1);
            	
            	R = a[0]+b[0];
            	
            	a[0] = R;
            	
                wr1.setPixel(i, j, a);
                
            }
        }
        try 
        {
        	//ImageIO.write(I1, "bmp", new File("Image/result/red_img.bmp"));//Red
        	ImageIO.write(I1, "bmp", new File(outDestinationPath+"red_img"+fileExtension));//Red
        	
        }
        catch (IOException e)
        {
        	System.err.println("Opps,Exception in MergeImage_RRnGGnBB-mergeRedImage(BufferedImage image,BufferedImage image1):");
        	e.printStackTrace();
        }
       
	}
	
	/* Merge Green Image(green_img1+green_img2 = green_img) */
	public static void mergeGreenImage(BufferedImage image,BufferedImage image1,String outDestinationPath,String fileExtension)
	{
		
		int width = image.getWidth();
        int height = image.getHeight();
       
    	BufferedImage I1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster wr1 = I1.getRaster();
        int[] a = new int[4];
        int[] b = new int[4];
        int G;
        int pixel1 = 0;
		Random rnd = new Random();
		
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = image.getRGB(i, j);
            	pixel1 = image1.getRGB(i, j);
            	a = getARGBPixelData(pixel);
            	b = getARGBPixelData(pixel1);
            	
            	G = a[1]+b[1];
            	
            	a[1] = G;
            	
                wr1.setPixel(i, j, a);
                
            }
        }
        try 
        {
        	//ImageIO.write(I1, "bmp", new File("Image/result/green_img.bmp"));//Red
        	ImageIO.write(I1, "bmp", new File(outDestinationPath+"green_img"+fileExtension));//Red
        }
        catch (IOException e)
        {
        	System.err.println("Opps,Exception in MergeImage_RRnGGnBB-mergeGreenImage(BufferedImage image,BufferedImage image1):");
        	e.printStackTrace();
        }
       
	}
	
	/* Merge Blue Image(blue_img1+blue_img2 = blue_img) */
	public static void mergeBlueImage(BufferedImage image,BufferedImage image1,String outDestinationPath,String fileExtension)
	{
		
		int width = image.getWidth();
        int height = image.getHeight();
       
    	BufferedImage I1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster wr1 = I1.getRaster();
        int[] a = new int[4];
        int[] b = new int[4];
        int B;
        int pixel1 = 0;
		Random rnd = new Random();
		
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = image.getRGB(i, j);
            	pixel1 = image1.getRGB(i, j);
            	a = getARGBPixelData(pixel);
            	b = getARGBPixelData(pixel1);
            	
            	B = a[2]+b[2];
            	
            	a[2] = B;
            	
                wr1.setPixel(i, j, a);
                
            }
        }
        try 
        {
        	//ImageIO.write(I1, "bmp", new File("Image/result/blue_img.bmp"));//Red
        	ImageIO.write(I1, "bmp", new File(outDestinationPath+"blue_img"+fileExtension));//Red
        }
        catch (IOException e)
        {
        	System.err.println("Opps,Exception in MergeImage_RRnGGnBB-mergeBlueImage(BufferedImage image,BufferedImage image1):");
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
	
	/* Testing The Development */
	
	public static void main(String[] args) 
	{
		String fileExtension = ".jpg";
		String outDestinationPath = "C:\\TestImage\\";
		String red_srcfilePath = "C:\\TestImage\\red_img1.jpg";
		String red_srcfilePath1 = "C:\\TestImage\\red_img2.jpg";
		BufferedImage red_img = null;
		BufferedImage red_img1 = null;
		red_img =readImage(red_srcfilePath);
		red_img1 =readImage(red_srcfilePath1);
		mergeRedImage(red_img,red_img1,outDestinationPath,fileExtension);
		
		String greeen_srcfilePath = "C:\\TestImage\\green_img1.jpg";
		String greeen_srcfilePath1 = "C:\\TestImage\\green_img2.jpg";
		BufferedImage greeen_img = null;
		BufferedImage greeen_img1 = null;
		greeen_img =readImage(greeen_srcfilePath);
		greeen_img1 =readImage(greeen_srcfilePath1);
		mergeGreenImage(greeen_img,greeen_img1,outDestinationPath,fileExtension);
		
		String blue_srcfilePath = "C:\\TestImage\\blue_img1.jpg";
		String blue_srcfilePath1 = "C:\\TestImage\\blue_img2.jpg";
		BufferedImage blue_img = null;
		BufferedImage blue_img1 = null;
		blue_img =readImage(blue_srcfilePath);
		blue_img1 =readImage(blue_srcfilePath1);
		mergeBlueImage(blue_img,blue_img1,outDestinationPath,fileExtension);
		System.out.println("Done...");
		
	}
}
