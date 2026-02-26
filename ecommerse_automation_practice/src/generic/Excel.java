package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel implements AutomationConstants {
	public static String getData1(String sheetName, int rowNumber, int cellNumber) {
		String value = "";
		try {
			File f = new File(excelSheetPath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet(sheetName);
			Row row = sheet.getRow(rowNumber);
			Cell cell = row.getCell(cellNumber);
			value = cell.getStringCellValue();

		} catch (Exception ex) {
			System.out.println("Unable to fetch the data from excel sheet.");
			ex.printStackTrace();
		}
		return value;
	}

	public static int getDataNumberData(String sheetName, int rowNumber, int cellNumber) {
		double value = 0;
		try {
			File f = new File(excelSheetPath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet(sheetName);
			Row row = sheet.getRow(rowNumber);
			Cell cell = row.getCell(cellNumber);
			value = cell.getNumericCellValue();

		} catch (Exception ex) {
			System.out.println("Unable to fetch the data from excel sheet.");
			ex.printStackTrace();
		}
		return (int) value;
	}

	public static Object getData(String sheetName, int rowNumber, int cellNumber) throws IOException {
		Object value = null;
		FileInputStream fis = null;
		Workbook wb = null;
		try {
			File f = new File(excelSheetPath);
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet(sheetName);
			Row row = sheet.getRow(rowNumber);
			Cell cell = row.getCell(cellNumber);

			CellType cellType = cell.getCellType();

			switch (cellType) {
			case STRING: {
				value = cell.getStringCellValue();
				break;
			}
			case NUMERIC: {
				if (DateUtil.isCellDateFormatted(cell)) {
					value = cell.getDateCellValue();
				} else {
					value = cell.getNumericCellValue();
				}
				break;
			}
			case BOOLEAN: {
				value = cell.getBooleanCellValue();
				break;
			}

			case FORMULA: {
				FormulaEvaluator fe = wb.getCreationHelper().createFormulaEvaluator();
				CellValue cellValue = fe.evaluate(cell);
				if (cellValue == null) {
					value = null;
				}

				switch (cellType) {
				case STRING: {
					value = cell.getStringCellValue();
					break;
				}
				case NUMERIC: {
					value = cell.getNumericCellValue();
					break;
				}
				case BOOLEAN: {
					value = cell.getBooleanCellValue();
					break;
				}
				default: {
					value = null;
				}

				}
			}

			case BLANK: {
				value = null;
				break;
			}
			case _NONE: {
				value = null;
				break;
			}
			case ERROR: {
				value = null;
				break;
			}

			default: {
				value = null;
			}
			}
		} catch (Exception ex) {
			System.out.println("Unable to fetch the data from excel sheet.");
			ex.printStackTrace();
		}

		finally {
			if (wb != null) {
				wb.close();
			}
			if (fis != null) {
				fis.close();
			}
		}

		return value;
	}

	public static Object getDataFromCell(String sheetName, int rowNumber, int cellNumber) {
		Object value = null;
		FileInputStream fis = null;
		Workbook wb = null;

		try {
			File f = new File(excelSheetPath);
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);

			Sheet sheet = wb.getSheet(sheetName);
			if (sheet == null)
				return null;

			Row row = sheet.getRow(rowNumber);
			if (row == null)
				return null;

			Cell cell = row.getCell(cellNumber, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (cell == null)
				return null;

			CellType cellType = cell.getCellType();

			switch (cellType) {
			case STRING:
				value = cell.getStringCellValue();
				break;

			case BOOLEAN:
				value = cell.getBooleanCellValue();
				break;

			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					value = cell.getDateCellValue();
				} else {
					value = cell.getNumericCellValue();
				}
				break;

			case FORMULA: {
				FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
				CellValue cellValue = evaluator.evaluate(cell);
				if (cellValue == null)
					return null;

				switch (cellValue.getCellType()) {
				case STRING:
					value = cellValue.getStringValue();
					break;
				case NUMERIC:
					value = cellValue.getNumberValue();
					break;
				case BOOLEAN:
					value = cellValue.getBooleanValue();
					break;
				default:
					value = null;
					break;
				}
				break;
			}

			case BLANK:
			case _NONE:
			case ERROR:
			default:
				value = null;
				break;
			}

		} catch (Exception ex) {
			System.out.println("Excel read error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (wb != null)
					wb.close();
			} catch (Exception ignored) {
			}
			try {
				if (fis != null)
					fis.close();
			} catch (Exception ignored) {
			}
		}

		return value;
	}
}
