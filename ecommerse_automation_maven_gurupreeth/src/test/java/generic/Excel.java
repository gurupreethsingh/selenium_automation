package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel implements AutomationConstants {

	public static Object getData(String sheetName, int rowNumber, int cellNumber) throws IOException {

		if (sheetName == null || sheetName.trim().isEmpty()) {
			return null;
		}

		if (rowNumber < 0 || cellNumber < 0) {
			return null;
		}

		try (FileInputStream fis = new FileInputStream(new File(EXCEL_SHEET_PATH));
				Workbook wb = WorkbookFactory.create(fis)) {

			Sheet sheet = wb.getSheet(sheetName);
			if (sheet == null)
				return null;

			Row row = sheet.getRow(rowNumber);
			if (row == null)
				return null;

			Cell cell = row.getCell(cellNumber, MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (cell == null)
				return null;

			CellType type = cell.getCellType();
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

			// ✅ If formula, evaluate and use result type/value
			if (type == CellType.FORMULA) {
				CellValue cv = evaluator.evaluate(cell);
				if (cv == null)
					return null;

				switch (cv.getCellType()) {
				case STRING: {
					String s = cv.getStringValue();
					return (s == null || s.trim().isEmpty()) ? null : s.trim();
				}
				case NUMERIC: {
					// For formulas returning dates, use the original cell formatting
					if (DateUtil.isCellDateFormatted(cell)) {
						Date d = cell.getDateCellValue();
						return d; // Date object
					}
					return cv.getNumberValue(); // Double
				}
				case BOOLEAN:
					return cv.getBooleanValue();
				case BLANK:
					return null;
				case ERROR:
					return null; // or return cv.getErrorValue()
				default:
					return null;
				}
			}

			// ✅ Non-formula cells
			switch (type) {
			case STRING: {
				String s = cell.getStringCellValue();
				return (s == null || s.trim().isEmpty()) ? null : s.trim();
			}
			case NUMERIC: {
				if (DateUtil.isCellDateFormatted(cell)) {
					return cell.getDateCellValue(); // Date
				}
				return cell.getNumericCellValue(); // Double
			}
			case BOOLEAN:
				return cell.getBooleanCellValue();
			case BLANK:
			case _NONE:
			case ERROR:
			default:
				return null;
			}
		}
	}
}