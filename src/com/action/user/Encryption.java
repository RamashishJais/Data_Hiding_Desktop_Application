package com.action.user;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Encryption
{
	static String [] concatedArgs;
    static String[] msgInBinary;
	static ArrayList<String> temp = new ArrayList<String>();
	static ArrayList<String> key5 = new ArrayList<String>();
	static ArrayList<Integer> list=new ArrayList<Integer>();
	static ArrayList<Integer> list1=new ArrayList<Integer>();
	static ArrayList<String> sec2 = new ArrayList<String>();
	static BufferedImage image1 = null;
	static BufferedImage image2 = null;
	static BufferedImage image3 = null;
	static BufferedImage image4 = null;
	static BufferedImage image5 = null;
	static int max = 0;
	static int count = 0;
	static int RPH2 = 0;
	static String p1="";
	static String res = "";
	static String pixelBinaryNum="";
	static int num8;
	static int count2 =0;
	static String str2 = "";
	static String str3 = "";
	static int hide_pix_count = 0;
	
	public static int secretBit(int value)
	{
		//sending modified pixel to generate stegano image
		if(count2 < Encryption.RPH2)
		{
			int key = Encryption.list.get(count2);
			
			count2++;
			
			return key;
		}
		else
		{
			return value;
		}
	}
	
	public static void hideSecretText(int num)
	{ 
		Encryption e1 = new Encryption();
	
		pixelBinaryNum = e1.getBinary1(num);//getting pixel value in binary
	    p1=pixelBinaryNum.substring(0, 6);//taking six bit form pixel 8 bit
	}
	
	public static int bitaddition(String num)
	{ 
		//adding six bit form pixel and two bit from secret message
		Encryption e1 = new Encryption();
		int decimal2=0;
		int num5=0;
		res = Encryption.p1+""+num; //adding 6 bit pixel and 2 bit secret message
		System.out.println("Modified pixel binary value is : "+res);
		num5= Integer.parseInt(res); // after addition of bit, changing string to integer
		decimal2=e1.getDecimalFromBinary(num5);//changing binary to decimal and returning the decimal value
		return decimal2;
	}
	
	public static int getDecimalFromBinary(int binary)
	{
		// this method is used to get decimal value from binary values
        int decimal = 0;
        int power = 0;
        while(true)
        {
            if(binary == 0)
            {
                break;
            } 
            else 
            {
                int tmp = binary%10;
                decimal += tmp*Math.pow(2, power);
                binary = binary/10;
                power++;
            }
        }
        return decimal;
    }
	
	public static void encryption(BufferedImage image3)
	{
		// here selecting pixel which is equal to maximum histogram
		Encryption obj1 = new Encryption();
		int[] pix_color = new int[4];
		int maxCountHisto = Encryption.count;
			int width = image3.getWidth();
			int height = image3.getHeight();
			for (int j = 0; j < height; j++) 
			{
				for (int i = 0; i < width; i++) 
				{
					int pixel = image3.getRGB(i, j);
					pix_color = obj1.getARGBPixelData(pixel);
					if (pix_color[0] == maxCountHisto) 
					{
						Encryption.hideSecretText(pix_color[0]); //sending matching pixel for hiding secret bit
					}
				}
			}	
	}
	
	public static int[] getARGBPixelData(int pixel) 
	{
		//here getting RGB pixel value from pixel value
		int []a = new int[4];
		try 
		{
			int alpha = (pixel >> 24) & 0x000000FF;
			int red = (pixel >> 16) & 0x000000FF;
			int green = (pixel >> 8) & 0x000000FF;
			int blue = (pixel) & 0x000000FF;
			a[0] = red;
			a[1] = green;
			a[2] = blue;
			a[3] = alpha;

		} 
		catch (Exception e) 
		{
			System.out.println("Error is in ImageProcess getARGBPixelData(int pixel) "+ e);
		}
		return a;
	}
	
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
	
	public static void getMaxHistogram(BufferedImage image2) 
	{
		try 
		{
			//searching histogram value which is having maximum pixel
			int width = image2.getWidth();
			int height = image2.getHeight();
			int hi[] = new int[256];
			for (int j = 0; j< height; j++) 
			{
				for (int i = 0; i< width; i++) 
				{
					Color c = new Color(image2.getRGB(i, j));
					int red = (int) (c.getRed());
					int green = (int) (c.getGreen());
					int blue = (int) (c.getBlue());
					int avg = (red + green + blue) / 3;

					hi[avg] = hi[avg] + 1;
				}
			}
		
			for (int r = 0; r < 256; r++) 
			{
				//System.out.println(" Histogram --> " + r + " : Value -->" + hi[r]);
			}
			for (int i = 0; i < hi.length; i++) 
			{
				if (hi[i] > max) 
				{
					max = hi[i];
					count = i;
				}
			}
			System.out.println("Histogram --> " + count + " having Max pixel value is "+ max);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String[] getBinary(String str) 
	{
		// changing every string alphabet to 8 bit binary 
		String a[] = new String[str.length()];
		for (int i = 0; i < str.length(); i++) 
		{
			char c = str.charAt(i);
			 a[i] = Integer.toBinaryString(c);
			if (a[i].length() == 0 || a[i].length() == 1 || a[i].length() == 2
					|| a[i].length() == 3 || a[i].length() == 4
					|| a[i].length() == 5 || a[i].length() == 6
					|| a[i].length() == 7) 
			{
				String zero = "";
				int how_many = 8 - a[i].length();
				for (int j = 0; j < how_many; j++)
					zero += "0";
				a[i] = zero + a[i];
			}
		}
		return a;
	}

	public static String getBinary1(int no) 
	{
		// changing integer value to 8 bit binary
		String str = Integer.toBinaryString(no);
		for (int i = 0; i < str.length(); i++) 
		{
			if (str.length() == 0 || str.length() == 1 || str.length() == 2
					|| str.length() == 3 || str.length() == 4
					|| str.length() == 5 || str.length() == 6
					|| str.length() == 7) 
			{
				String zero = "";
				int how_many = 8 - str.length();
				for (int j = 0; j < how_many; j++)
					zero += "0";
				str = zero + str;
			}
		}
		return str;
	}

	public static String getStringLength(int Len) 
	{
		String a = Len + "";
		int L = a.length();

		System.out.println("Len :" + Len);
		System.out.println("L :" + L);

		if (L == 1) 
		{
			a = "00" + a;
		}
		if (L == 2) 
		{
			a = "0" + a;
		}
		return a;
	}
	
	public static void encryption2(BufferedImage image4, String steganoImgPath)
	{
		// selecting pixel which is equal to maximum histogram value after that hiding secret msg value in that pixel and getting back pixel and setting these pixel in stegano image
		System.out.println("stegano image path is : "+steganoImgPath);
		Encryption obj5 = new Encryption();
		int[] pix_color = new int[4];
		int[] pix_color4 = new int[4];
		int maxCountHisto = Encryption.count;
		try
		{
			int width = image4.getWidth();
			int height = image4.getHeight();
			for (int j = 0; j< height; j++) 
			{
				for (int i = 0; i < width; i++) 
				{
					int pixel = image4.getRGB(i, j);
					pix_color = obj5.getARGBPixelData(pixel);
					if ((pix_color[0] == maxCountHisto) && (hide_pix_count < RPH2))
					{
						
						int key77=Encryption.secretBit(pix_color[0]);
						System.out.println("key77 :"+key77);
						
						
						Color newColor = new Color(key77, pix_color[1], pix_color[2]);
						image4.setRGB(i, j, newColor.getRGB());
						int pixel7 = image4.getRGB(i, j);
						pix_color4 = obj5.getARGBPixelData(pixel7);
						list1.add(key77);
						hide_pix_count++;
					}
					else
					{
					Color newColor = new Color(pix_color[0], pix_color[1], pix_color[2]);
					image4.setRGB(i, j, newColor.getRGB());
					}
				}
			}	
			File ouptut = new File(steganoImgPath);
			ImageIO.write(image4, "png", ouptut);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}

