package com.util;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;
public class ImageProcess 
{
	
	/* Read An Image */
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
	
	/* Splitting a original image into 3 parts (its respective Red,Green and Blue color pixels) */
	public static void processImage(BufferedImage image,String sievingPath,String fileName)
	{
		
		int width = image.getWidth();
        int height = image.getHeight();
       
    	BufferedImage I1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage I2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage I3 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        WritableRaster wr1 = I1.getRaster();
        WritableRaster wr2 = I2.getRaster();
        WritableRaster wr3 = I3.getRaster();
        
        int[] a = new int[4];
        int[] b = new int[4];
        int[] c = new int[4];
        
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = image.getRGB(i, j);
            	a=getARGBPixelData(pixel);
                b=getARGBPixelData(pixel);
                c=getARGBPixelData(pixel);
                // Red
                a[1]=0;
                a[2]=0;
                //a[3]=255;
                //a[3]=0; //do not disturb alpha
                
                //Green
                b[0]=0;
                b[2]=0;
               // b[3]=255;
               // b[3]=0; //do not disturb alpha
                
                //blue
                c[0]=0;
                c[1]=0;
               // c[3]=255;
               // c[3]=0;//do not disturb alpha
                
                
                wr1.setPixel(i, j, a);
                wr2.setPixel(i, j, b);
                wr3.setPixel(i, j, c);
              
            }
        }
        try 
        {
        	/*
        	ImageIO.write(I1, "jpg", new File(sievingPath+"red_"+fileName));//Red
        	ImageIO.write(I2, "jpg", new File(sievingPath+"green_"+fileName));//Green
        	ImageIO.write(I3, "jpg", new File(sievingPath+"blue_"+fileName));//Blue
        	*/
        	
        	ImageIO.write(I1, "bmp", new File(sievingPath+"red_"+fileName));//Red
        	ImageIO.write(I2, "bmp", new File(sievingPath+"green_"+fileName));//Green
        	ImageIO.write(I3, "bmp", new File(sievingPath+"blue_"+fileName));//Blue
        }
        catch (IOException e)
        {
        	System.err.println("Opps,Exception In ImageProcess-processImage(BufferedImage image) :");
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
			System.err.println("Opps,Exception In ImageProcess-getARGBPixelData(int pixel) :");
        	e.printStackTrace();
		}
		return a;
	}
	
	/* Testing The Development */
	
	public static void main(String[] args) 
	{
		
		/*
		String srcfilePath = "C:\\ImageProcessing\\test.jpg";
		BufferedImage img = null;
		
		img =readImage(srcfilePath);
		
		processImage(img);
		
		System.out.println("Done...");
		*/
		
	}
}
