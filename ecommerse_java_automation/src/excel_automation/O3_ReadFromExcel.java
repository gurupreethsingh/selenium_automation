package excel_automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class O3_ReadFromExcel {

    public static String getData(String sheetName, int rowNumber, int cellNumber) {
        String value = null;
        FileInputStream fis = null;
        Workbook wb = null;

        try {
            // Define the path of the Excel file
            String rootFolder = System.getProperty("user.dir");
            File file = new File(rootFolder + "\\project_documents.xlsx");

            // Open file input stream
            fis = new FileInputStream(file);

            // Load workbook
            wb = WorkbookFactory.create(fis);

            // Access cell
            Sheet sheet = wb.getSheet(sheetName);
            if (sheet == null || sheet.getRow(rowNumber) == null || sheet.getRow(rowNumber).getCell(cellNumber) == null) {
                return ""; // No such sheet, row, or cell
            }

            Cell cell = sheet.getRow(rowNumber).getCell(cellNumber);
            CellType cellType = cell.getCellType();

            switch (cellType) {
                case STRING:
                    value = cell.getStringCellValue();
                    break;

                case NUMERIC:
                    value = String.valueOf(cell.getNumericCellValue());
                    break;

                case BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;

                case FORMULA:
                    try {
                        value = String.valueOf(cell.getNumericCellValue());
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

        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
            value = "EXCEPTION_OCCURED";
        } finally {
            // Close resources
            try {
                if (wb != null) {
                    wb.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return value;
    }
}
