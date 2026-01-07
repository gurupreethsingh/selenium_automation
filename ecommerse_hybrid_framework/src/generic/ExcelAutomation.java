package generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelAutomation implements AutomationConstants
{
   public static Object getData(String sheetName, int rowNumber, int cellNumber)
   {
	   Object value = null;
	   
	   try
	   {
		   // mention the file location. 
		   File f  = new File(excelSheetPath);
		   // go inside the file. 
		   FileInputStream fis = new FileInputStream(f);
		   // create our workbook inside the file. 
		   Workbook wb = WorkbookFactory.create(fis);
		   
		   Sheet sh = wb.getSheet(sheetName);
		   Row r = sh.getRow(rowNumber);
		   Cell cell = r.getCell(cellNumber);
		      
		   CellType ct = cell.getCellType();
		   
		   switch(ct)
		   {
		   case STRING: 
		   {
			   value = cell.getStringCellValue();
			   break;
		   }
		   case NUMERIC:
		   {
			   value = cell.getNumericCellValue();
			   break;
		   }
		   case BOOLEAN:
		   {
			   value = cell.getBooleanCellValue();
			   break;
		   }
		      case FORMULA:
                  try {
                      value = cell.getNumericCellValue();
                  } catch (IllegalStateException e) {
                      value = cell.getStringCellValue();
                  }
                  break;

              case BLANK:
                  value = "";
                  break;

              case ERROR:
                  value = "ERROR_CELL";
                  break;

              default:
                  value = "UNKNOWN_CELL_TYPE";
                  break;
		   }
	   }
	   catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   
	   return value; 
   }
}
