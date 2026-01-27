package file_handling;

import java.io.File;
import java.io.FileReader;

public class O4_ReadFromTextFile {

	public static void main(String[] args) 
	{
		try
		{
			File  file = new File("E:\\eclipse_coding_projects\\selenium_automation\\Core_java_anjan_bharath\\27th_java_notes\\my_java_notes.txt");
		    
			FileReader fr = new FileReader(file);
			
			
			int ch; 
			
			while(  (ch = fr.read()) != -1)
			{
				System.out.print((char)ch);
			}
			
			fr.close();
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
