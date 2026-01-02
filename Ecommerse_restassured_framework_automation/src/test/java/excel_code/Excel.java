package excel_code;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel 
{ 
	
	public static Object getData(String sheetName, int rowNumber, int cellNumber)
	{String excelSheetPath = "";
		Object value = null; 
		try
		{
			File f = new File(excelSheetPath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			
			Cell cell = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber);
			CellType ct = cell.getCellType();
			
			switch(ct)
			{
			case STRING : 
			{
				value = cell.getStringCellValue();
				break; 
			}
			case NUMERIC : 
			{
				if(DateUtil.isCellDateFormatted(cell))
				{
					value = cell.getDateCellValue().toString();
				}
				else
				{
					value = cell.getNumericCellValue();
					break; 
				}
				
			}
            case BOOLEAN:
            {
            	 value = cell.getBooleanCellValue();
                 break;
            }
            case BLANK:
            {
            	 value = "BLANK";
                 break;
            }
            
            case ERROR:
            {
            	 value = "ERROR: " + cell.getErrorCellValue();
                 break;
            }
            
            case FORMULA:
            {
                // Get the formula result type
                switch (cell.getCachedFormulaResultType()) {
                    case STRING:
                        value = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        value = String.valueOf(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        value = String.valueOf(cell.getBooleanCellValue());
                        break;
                    default:
                        value = "Unsupported formula result type";
                }
                break;
            }
               
            default:
            {
            	 value = "Unknown Cell Type";
            }
        
 			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return value;
	}

}
