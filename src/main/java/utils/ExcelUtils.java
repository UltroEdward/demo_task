package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;

    //TODO: fast implementation, need to refactor
    public static Object[][] getTableArray(String FilePath, String SheetName) {
        String[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startRow = 1;
            int totalRows = ExcelWSheet.getLastRowNum();
            int totalColls = ExcelWSheet.getRow(0).getLastCellNum();
            tabArray = new String[totalRows][totalColls];

            for (int rowNum = startRow; rowNum <= totalRows; rowNum++) {
                XSSFRow Row = ExcelWSheet.getRow(rowNum);
                int totalCells = Row.getLastCellNum();

                for (int cell = 0; cell < totalCells; cell++) {
                    String cellValue = getCellData(rowNum, cell);
                    tabArray[rowNum - 1][cell] = cellValue;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tabArray;
    }

    //TODO: fast implementation, need to refactor
    public static String getCellData(int RowNum, int ColNum) {
        Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
        CellType dataType = Cell.getCellType();
        if (dataType.getCode() == 3) {
            return "";
        } else {
            String CellData = Cell.getStringCellValue();
            return CellData;
        }
    }
}
