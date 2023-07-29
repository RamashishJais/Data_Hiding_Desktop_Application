package com.action.user;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Decryption 
{
	static ArrayList<Integer>totalPix = new ArrayList<Integer>();
	static ArrayList<Integer>totalPix4 = new ArrayList<Integer>();
	static ArrayList<String> totalPix5 = new ArrayList<String>();
	static ArrayList<String> totalPix2 = new ArrayList<String>();
	static ArrayList<String> totalPix3 = new ArrayList<String>();
	static ArrayList<String> sec = new ArrayList<String>();
	static ArrayList<String> sec2 = new ArrayList<String>();
	static BufferedImage image1 = null;
	static BufferedImage image2 = null;
	static BufferedImage image3 = null;
	static BufferedImage image4 = null;
	static int max = 0;
	static int count = 0;
	static int hide_pix_count = 0;
	static int hide_pix_count2 = 0;
	static int MsgLength5 = 0;
	static int secretMsgLength = 0;
	
	public static String getSecretMsg(int pix)
	{
		//getting pixel whose value is equal to the max histogram value
		Decryption d1 = new Decryption();
		int []secBit = new int[Decryption.max];
		Decryption.totalPix.add(pix);
		String pixelBinaryNum = d1.getBinary1(pix);
		String p2 = pixelBinaryNum.substring(6);
		totalPix2.add(p2); //2 bit of pixel value storing in array list
		return totalPix2.toString();
	}
	
	public static String getSecretMsg4(int pix)
	{
		//getting pixel whose value is equal to the max histogram value
		Decryption d1 = new Decryption();
		Decryption.totalPix4.add(pix);
		String pixelBinaryNum = d1.getBinary1(pix);
		// taking starting 6 bit from 8 bit of pixel
		String p2 = pixelBinaryNum.substring(6);
		totalPix5.add(p2); //2 bit of pixel value storing in array list
		return totalPix5.toString();
	}
	
	public static void getSecretMsg2()
	{
		String str5 = "";
		Decryption.totalPix3.clear();
		
		int i3=0;
		Decryption.totalPix3 = (ArrayList<String>) Decryption.totalPix2;
		//String []list4 = new String[Decryption.totalPix3.size()];
		ArrayList<String> al = new ArrayList<String>();
		//String []list5 = new String[list4.length];
		for(int i11=0;i11<Decryption.totalPix3.size();i11++)
		{
			//list4[i11]= totalPix3.get(i11);
			al.add(totalPix3.get(i11));
			System.out.println("al data is : "+al.get(i11));
		}
		for(i3=0;i3<12;i3++)
		{
			str5+= al.get(i3);
			
		}
		int len = str5.length();
		System.out.println("str 5 length is : "+str5);
		String str3="";
		for(int i=0;i<len;i=i+8)
		{
			for(int j=i;j<i+8;j++)
			{
			 char c= str5.charAt(j);
				str3 += c;
			}
			sec.add(str3);
			str3="";
		}
		String ss="";
		String secLen = "";
		char c=0;
		for(String p :sec)
		{
			int num1 = Decryption.Binary2ASCII(p);
			secLen += num1;
		}
		try
		{
			MsgLength5 = Integer.parseInt(secLen.trim());
		}
		catch(NumberFormatException nfe)
		{
			nfe.printStackTrace();
		}
		System.out.println();
	}
	
	
	public static String getSecretMsg5()
	{
		String str5="";
		Decryption.totalPix3.clear();
		int i3=0;
		Decryption.totalPix3 = (ArrayList<String>) Decryption.totalPix5;
		//String []list4 = new String[Decryption.totalPix3.size()];
		//String []list5 = new String[list4.length];
		ArrayList<String> al = new ArrayList<String>();
		al.clear();
		
		for(int i11=0;i11<Decryption.totalPix3.size();i11++)
		{
			//list4[i11]= totalPix3.get(i11);
			al.add(totalPix3.get(i11));
		}
		for(i3=0;i3<Decryption.MsgLength5*4;i3++)
		{
			str5+= al.get(i3);
			System.out.println("Secret message bit is : "+al.get(i3));
		}
		System.out.println("Complete Secret message in binary is : "+str5);
		int len = str5.length();
		String str3="";
		for(int i=0;i<len;i=i+8)
		{
			for(int j=i;j<i+8;j++)
			{
			 char c= str5.charAt(j);
				str3 += c;
			}
			sec2.add(str3);
			System.out.println("Secret message letter binary value is : "+str3);
			str3="";
		}
		String ss = "";
		char c=0;
		for(String p :sec2)
		{
			String str7 = Decryption.BinaryToHex(p);
			int num1 = Decryption.Binary2ASCII(p);
			
			c=(char) num1;
			ss+=c; 
		}
		System.out.println();
		System.out.print("The Secret message is : "+""+ss);
		return ss;
	}
	
	public static String getSecretMsg()
	{
		String secret = Decryption.getSecretMsg5();
		
		return secret;
		
	}
	
	public static String BinaryToHex(String hex)
	{
		  long num = Long.parseLong(hex);
		  long rem;
		  while(num > 0)
		  {
			  rem = num % 10;
			  num = num / 10;
			  if(rem != 0 && rem != 1)
			  {
				  System.out.println("This is not a binary number.");
				  System.out.println("Please try once again.");
				  System.exit(0);
			  }
		  }
		  int i= Integer.parseInt(hex,2);
		  String hexString = Integer.toHexString(i);
		  return hexString;
	}
	
	public static BufferedImage readImage(String fileLocation)
	{
		System.out.println("file location is : "+fileLocation);
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
	
	public static int Binary2ASCII(String str) 
	{
		  long num = Long.parseLong(str);
		  long rem;
		  while(num > 0)
		  {
			  rem = num % 10;
			  num = num / 10;
			  if(rem != 0 && rem != 1)
			  {
				  System.out.println("This is not a binary number.");
				  System.out.println("Please try once again.");
				  System.exit(0);
			  }
		  }
		  		int i= Integer.parseInt(str,2);
		  		System.out.println("Secret message letter Decimal value is : "+i);
		  		return i;
	}
	

	public static void getMaxHistogram(BufferedImage image1) 
	{
		try 
		{
			int width = image1.getWidth();
			int height = image1.getHeight();
			int hi[] = new int[256];
			for (int j = 0; j< height; j++) 
			{
				for (int i = 0; i< width; i++) 
				{
					Color c = new Color(image1.getRGB(i, j));
					int red = (int) (c.getRed());
					int green = (int) (c.getGreen());
					int blue = (int) (c.getBlue());
					int avg = (red + green + blue) / 3;

					hi[avg] = hi[avg] + 1;
				}
			}
		
			/*for (int r = 0; r < 256; r++) 
			{
				//System.out.println(" Index --> " + r + " : Value -->" + hi[r]);
			}*/
			for (int i = 0; i < hi.length; i++) 
			{
				if (hi[i] > max) 
				{
					max = hi[i];
					count = i;
				}
			}
			System.out.println("Index --> " + count + " having Max value is "+ max);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void decryption(BufferedImage image2,BufferedImage image3, String path2)
	{
		Decryption obj1 = new Decryption();
		int[] pix_color2 = new int[4];
		int[] pix_color3 = new int[4];
		int maxCountHisto = Decryption.count;
		try
		{
			int width = image2.getWidth();
			int height = image2.getHeight();
			int width1 = image3.getWidth();
			int height1 = image3.getHeight();
			for (int j = 0; j < height; j++) 
			{
				for (int i = 0; i < width; i++) 
				{
					int pixel2 = image2.getRGB(i, j);
					pix_color2 = obj1.getARGBPixelData(pixel2);
					
					if (pix_color2[0] == maxCountHisto) 
					{
						int pixel3 = image3.getRGB(i, j);
						pix_color3 = obj1.getARGBPixelData(pixel3);
						Color newColor = new Color(pix_color3[0], pix_color3[1], pix_color3[2]);
						image3.setRGB(i, j, newColor.getRGB());
						hide_pix_count ++;
						
						if (hide_pix_count <= 12) 
						{
							Decryption.getSecretMsg(pix_color3[0]);
						}
					}
					else
					{
						pix_color2 = obj1.getARGBPixelData(pixel2);
					Color newColor = new Color(pix_color2[0], pix_color2[1], pix_color2[2]);
					image3.setRGB(i, j, newColor.getRGB());
					}
				}
			}	
			File ouptut = new File(path2);
			ImageIO.write(image3, "jpg", ouptut);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void decryption2(BufferedImage image2,BufferedImage image3, int secLength )
	{
		Decryption obj1 = new Decryption();
		int[] pix_color2 = new int[4];
		int[] pix_color3 = new int[4];
		int maxCountHisto = Decryption.count;
			int width = image2.getWidth();
			int height = image2.getHeight();
			for (int j = 0; j < height; j++) 
			{
				for (int i = 0; i < width; i++) 
				{
					int pixel2 = image2.getRGB(i, j);
					pix_color2 = obj1.getARGBPixelData(pixel2);
					
					if (pix_color2[0] == maxCountHisto) 
					{
						int pixel3 = image3.getRGB(i, j);
						pix_color3 = obj1.getARGBPixelData(pixel3);
						Color newColor = new Color(pix_color3[0], pix_color3[1], pix_color3[2]);
						image3.setRGB(i, j, newColor.getRGB());
						Decryption.hide_pix_count2++;
						if ((Decryption.hide_pix_count2>12) && (Decryption.hide_pix_count2<=secLength)) 
						{
							Decryption.getSecretMsg4(pix_color3[0]);
						}
					}
					
				}
			}	
	}
	
	public static int getDecimalFromBinary(int binary)
	{
        int decimal = 0;
        int power = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int tmp = binary%10;
                decimal += tmp*Math.pow(2, power);
                binary = binary/10;
                power++;
            }
        }
        return decimal;
    }
	
	public static String[] getBinary(String str) 
	{
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
	
	public static int[] getARGBPixelData(int pixel) 
	{
		int[] a = new int[4];
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
}



