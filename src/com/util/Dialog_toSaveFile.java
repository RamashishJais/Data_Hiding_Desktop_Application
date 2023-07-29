/**
 @Author : 
 Date : Sep 21, 2012
 File : SaveFileAs_Dialog.java
 Package : com.util
*/
package com.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

//  FileDialog example snippet: prompt for a file name (to save)

/* For this App swt.jar is nedded*/
/* download swt.zip and extract it and go to windows dir ang get swt.jar file */

public class Dialog_toSaveFile 
{
	
	
	public static String saveFile(String fileName)
	{
		 String fileLocationToSave = "";
		
		 Display display = new Display();
	     Shell shell = new Shell(display);
	     FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		 dialog.setFilterNames(new String[] {"All Files (*.*)" ,"Text File(.txt)","JPEG(.jpg)","PNG(.png)","Batch Files",});
		 dialog.setFilterExtensions(new String[] { "*.*" ,"*.txt","*.jpg","*.png" ,"*.bat"}); // Window 
		//dialog.setFilterPath("c:\\"); // Windows path
	    dialog.setFilterPath("C:\\Documents and Settings\\dhs\\My Documents\\Downloads"); //Default  Windows path
	    dialog.setFileName(fileName);
	    fileLocationToSave = dialog.open();
	    
	   System.out.println("Save to :" + fileLocationToSave);
	    
	   /* while (!shell.isDisposed())
		{
		      if (!display.readAndDispatch())
		      display.sleep();
		}
	   display.dispose();*/
	   
	  return fileLocationToSave;
	}
	
/* Testing the development */
	
	public static void main(String[] args) 
	{
	   String fileName = "test.txt";
	   String saveTo="";
	   saveTo = saveFile(fileName);
	   System.out.println("Save File To : " + saveTo);
	}
}
