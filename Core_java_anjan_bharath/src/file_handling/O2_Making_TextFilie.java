package file_handling;

import java.io.File;

public class O2_Making_TextFilie {

	public static void main(String[] args) 
	{
		try
		{
			// make a text file
			File  f = new File("E:\\eclipse_coding_projects\\selenium_automation\\Core_java_anjan_bharath\\27th_java_notes\\my_java_notes.txt");
			
			if(!f.exists())
			{
				if(f.createNewFile())
				{
					System.out.println("Text file got created successfully");
				}
				else
				{
					System.out.println("Unable to create the file.");
				}
				
			}
			else
			{
				System.out.println("Text file already exists.");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
