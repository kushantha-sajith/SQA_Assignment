package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
    public static Object[][] getExcelData(String filePath, String sheetName) {
        List<Object[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();

            // Skip the header row by starting from row index 1
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Object[] rowData = new Object[2]; // Assuming two columns for min and max price
                    Cell cell1 = row.getCell(0);
                    Cell cell2 = row.getCell(1);

                    // Check and handle the first cell (min price)
                    if (cell1 != null) {
                        if (cell1.getCellType() == CellType.NUMERIC) {
                            rowData[0] = (int) cell1.getNumericCellValue(); // Convert Double to Integer
                        } else if (cell1.getCellType() == CellType.STRING) {
                            rowData[0] = Integer.parseInt(cell1.getStringCellValue()); // Parse string as Integer
                        }
                    } else {
                        rowData[0] = null; // Explicitly set to null if cell is empty
                    }

                    // Check and handle the second cell (max price)
                    if (cell2 != null) {
                        if (cell2.getCellType() == CellType.NUMERIC) {
                            rowData[1] = (int) cell2.getNumericCellValue(); // Convert Double to Integer
                        } else if (cell2.getCellType() == CellType.STRING) {
                            rowData[1] = Integer.parseInt(cell2.getStringCellValue()); // Parse string as Integer
                        }
                    } else {
                        rowData[1] = null; // Explicitly set to null if cell is empty
                    }

                    // Add rowData to data only if neither element is null
                    if (rowData[0] != null && rowData[1] != null) {
                        data.add(rowData);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert List<Object[]> to Object[][] for DataProvider compatibility
        return data.toArray(new Object[0][0]);
    }
}