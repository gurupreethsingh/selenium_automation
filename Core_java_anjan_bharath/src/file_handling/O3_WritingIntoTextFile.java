package file_handling;

import java.io.File;
import java.io.FileWriter;

public class O3_WritingIntoTextFile {

	public static void main(String[] args) 
	{
		try
		{
			File  file = new File("E:\\eclipse_coding_projects\\selenium_automation\\Core_java_anjan_bharath\\27th_java_notes\\my_java_notes.txt");
			
			String notes = "\nThis is my third day notes.";
			
			FileWriter fw = new FileWriter(file, true);   // true mean append mode 
			
			fw.write(notes);
			fw.close();
			System.out.println("Notes written successfully.");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
