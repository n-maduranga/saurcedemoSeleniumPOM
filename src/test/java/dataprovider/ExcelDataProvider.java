package dataprovider;

import org.testng.annotations.DataProvider;
import utils.ExcelUtil;

public class ExcelDataProvider {

    @DataProvider(name = "excelData")
    public static Object[][] getCheckoutData() {
        String filePath = System.getProperty("user.dir")+"/src/test/resources/testdata/TestData.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtil.getDataFromExcel(filePath, sheetName);
    }
}
