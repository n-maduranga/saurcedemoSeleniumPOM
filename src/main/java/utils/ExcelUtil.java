package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelUtil {


    public static Object[][] getDataFromExcel(String filePath,String sheetName){
        Object[][] data = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount-1][colCount];
            for(int i=1;i<rowCount;i++){
                Row row = sheet.getRow(i);
                for(int j=0;j<colCount;j++){
                    Cell cell = row.getCell(j);
                    data[i-1][j] = getCellValue(cell);
                }
            }
    workbook.close();
        } catch (IOException e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return data;
    }

    private static Object getCellValue(Cell cell) {

        if (cell == null) return "";

        switch (cell.getCellType()) {

            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                }
                return String.valueOf((long) cell.getNumericCellValue());

            case BOOLEAN:
                return cell.getBooleanCellValue();

            case FORMULA:
                return cell.getCellFormula();

            default:
                return "";
        }
    }
    }

