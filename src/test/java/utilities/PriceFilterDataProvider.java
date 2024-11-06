package utilities;

import org.testng.annotations.DataProvider;

public class PriceFilterDataProvider {
    @DataProvider(name = "priceRanges")
    public Object[][] getPriceRanges() {
        String filePath = "F:\\Assignment\\PriceRanges.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtilities.getExcelData(filePath, sheetName);
    }
}
