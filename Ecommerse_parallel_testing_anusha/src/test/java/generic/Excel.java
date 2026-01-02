package generic;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel implements AutomationConstants {

    public static Object getData(String sheetName, int rowNumber, int cellNumber) {
        Object value = "";

        try (FileInputStream fis = new FileInputStream(new File(excelSheetPath));
             Workbook wb = WorkbookFactory.create(fis)) {

            Sheet sheet = wb.getSheet(sheetName);
            if (sheet == null) {
                return "";
            }

            Row row = sheet.getRow(rowNumber);
            if (row == null) {
                return "";
            }

            Cell cell = row.getCell(cellNumber);
            if (cell == null) {
                return "";
            }

            CellType ct = cell.getCellType();

            switch (ct) {
                case STRING:
                    value = cell.getStringCellValue().trim();
                    break;

                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        // Simple date formatting (change pattern if needed)
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        value = sdf.format(cell.getDateCellValue());
                    } else {
                        // Avoid scientific notation / .0 issues
                        BigDecimal bd = BigDecimal.valueOf(cell.getNumericCellValue());
                        bd = bd.stripTrailingZeros();
                        value = bd.toPlainString();
                    }
                    break;

                case BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;

                case BLANK:
                    value = "";
                    break;

                default:
                    value = "";
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return value;
    }
}




// package generic;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.IOException;
// import java.text.SimpleDateFormat;

// import org.apache.poi.EncryptedDocumentException;
// import org.apache.poi.ss.usermodel.*;

// public class Excel implements AutomationConstants {

//     // Returns the cell value as a String, using the proper getter for each cell type.
//     public static String getData(String sheetName, int rowNumber, int cellNumber) {
//         FileInputStream fis = null;
//         Workbook wb = null;

//         try {
//             File f = new File(excelSheetPath);
//             fis = new FileInputStream(f);
//             wb = WorkbookFactory.create(fis);

//             Sheet sheet = wb.getSheet(sheetName);
//             if (sheet == null) return "";

//             Row row = sheet.getRow(rowNumber);
//             if (row == null) return "";

//             Cell cell = row.getCell(cellNumber);
//             if (cell == null) return "";

//             switch (cell.getCellType()) {
//                 case STRING:
//                     return cell.getStringCellValue().trim();

//                 case NUMERIC:
//                     if (DateUtil.isCellDateFormatted(cell)) 
//                     {
//                         return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cell.getDateCellValue());
//                     } 
//                     else 
//                     {
//                         double d = cell.getNumericCellValue();
//                         return (d == Math.rint(d)) ? String.valueOf((long) d) : String.valueOf(d);
//                     }

//                 case BOOLEAN:
//                     return String.valueOf(cell.getBooleanCellValue());

//                 case FORMULA:
//                     FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//                     CellValue cv = evaluator.evaluate(cell);
//                     if (cv == null) return "";
//                     switch (cv.getCellType()) {
//                         case STRING:
//                             return cv.getStringValue().trim();
//                         case NUMERIC:
//                             if (DateUtil.isCellDateFormatted(cell)) {
//                                 return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//                                         .format(cell.getDateCellValue());
//                             } else {
//                                 double d2 = cv.getNumberValue();
//                                 return (d2 == Math.rint(d2)) ? String.valueOf((long) d2) : String.valueOf(d2);
//                             }
//                         case BOOLEAN:
//                             return String.valueOf(cv.getBooleanValue());
//                         case BLANK:
//                             return "";
//                         case ERROR:
//                             try {
//                                 return FormulaError.forInt(cv.getErrorValue()).getString();
//                             } catch (Exception e) {
//                                 return "ERROR(" + cv.getErrorValue() + ")";
//                             }
//                         default:
//                             return "";
//                     }

//                 case BLANK:
//                     return "";

//                 case ERROR:
//                     try {
//                         return FormulaError.forInt(cell.getErrorCellValue()).getString();
//                     } catch (Exception e) {
//                         return "ERROR(" + cell.getErrorCellValue() + ")";
//                     }

//                 default:
//                     return "";
//             }

//         } catch (EncryptedDocumentException e) {
//             e.printStackTrace();
//             System.out.println("Workbook is encrypted or invalid.");
//             return "";
//         } catch (IOException e) {
//             e.printStackTrace();
//             System.out.println("I/O error while reading Excel file.");
//             return "";
//         } catch (RuntimeException e) {
//             e.printStackTrace();
//             System.out.println("Unexpected error while reading Excel file.");
//             return "";
//         } finally {
//             if (wb != null) {
//                 try { wb.close(); } catch (IOException ignored) {}
//             }
//             if (fis != null) {
//                 try { fis.close(); } catch (IOException ignored) {}
//             }
//         }
//     }
// }
