package generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel implements AutomationConstants {
	public static String getData(String sheetName, int rowNumber, int cellNumber) {
		String value = "";
		try {
			// fetch the data from excel sheet.
			// find the location of the excel sheet.
			File f = new File(excelSheetPath);
			// go inside that excel sheet using FileInputStream class.
			FileInputStream fis = new FileInputStream(f);
			// we will work in that workbook where all the sheets are present.
			Workbook wb = new XSSFWorkbook(fis);
			// get the sheet from where you want to read the data.
			Sheet sheet = wb.getSheet(sheetName);
			// in the homepage sheet name, go to the row number
			Row row = sheet.getRow(rowNumber);
			// from that row. go to the cell number / column number
			Cell cell = row.getCell(cellNumber);
			// from this cell get the string value ,
			value = cell.getStringCellValue();

		} catch (Exception ex) {
			System.out.println("Unable to fetch the data from excel sheet.");
			ex.printStackTrace();
		}
		return value;
	}
}
