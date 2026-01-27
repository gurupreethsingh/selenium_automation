package file_handling;

import java.io.File;

public class O1_MakingFolders {

	public static void main(String[] args) 
	{
		// make a folder 
		try
		{
			File f = new File("27th_java_notes");
			
			if(!f.exists())
			{
				if(f.mkdir()) {
					System.out.println("Folder created successfully.");
				}
			}
			else
			{
				System.out.println("folder already exists");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
