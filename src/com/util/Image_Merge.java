package com.util;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;
public class Image_Merge 
{
	/* Reading The Image */
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
	
	/* Getting back original one from the three images. */
	public static void mergeImage(BufferedImage image,BufferedImage image1,BufferedImage image2,String outFileLocation,String outFileName)
	{
		
		int width = image.getWidth();
        int height = image.getHeight();
       
    	BufferedImage I1 = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
       
        WritableRaster wr1 = I1.getRaster();
       
        int[] a = new int[4];
        int[] b = new int[4];
        int[] c = new int[4];
        
        int[] d = new int[4];
     
        	
		
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = image.getRGB(i, j);
            	int pixel1 = image1.getRGB(i, j);
            	int pixel2 = image2.getRGB(i, j);
            	
            	a = getARGBPixelData(pixel);
            	b = getARGBPixelData(pixel1);
            	c = getARGBPixelData(pixel2);
            	
            	d[0]=a[0];
            	d[1]=b[1];
            	d[2]=c[2];
            	//d[3]=255;
            	
            	/*
	            	System.out.println("Red "+d[0]);
	            	System.out.println("Green "+d[1]);
	            	System.out.println("Blue "+d[2]);
	            	System.out.println("Alpha "+d[3]);
            	*/
            	                
                wr1.setPixel(i,j, d);
              
            }
        }
        try 
        {
        	//ImageIO.write(I1, "jpg", new File("Image/result/final.jpg"));//Merged Image
        	ImageIO.write(I1, "bmp", new File(outFileLocation+outFileName));//Merged Image
        	
        }
        catch (IOException e)
        {
        	System.err.println("image not saved.");
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
	
	/* Testing The Development */
	
	public static void main(String[] args) 
	{
		String srcfilePath = "C:\\TestImage\\red_img.jpg";
		String srcfilePath1 = "C:\\TestImage\\green_img.jpg";
		String srcfilePath2 = "C:\\TestImage\\blue_img.jpg";
		String outFileLocation = "C:\\TestImage";
		String outFileName="Out.jpg";
		BufferedImage img = null;
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		
		img =readImage(srcfilePath);
		img1 =readImage(srcfilePath1);
		img2 =readImage(srcfilePath2);
		mergeImage(img,img1,img2,outFileLocation,outFileName);
		
		System.out.println("Done...");
		
	}
}
