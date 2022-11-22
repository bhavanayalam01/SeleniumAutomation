package com.info6255.group8;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class ReadExcelData {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ReadExcelData() {
        try {
            File sourceFile = new File("C:\\Users\\swapn\\Desktop\\UserData.xlsx");
            FileInputStream file = new FileInputStream(sourceFile);
            workbook = new XSSFWorkbook(file);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getData(int sheetNumber, int row, int column) {
        sheet = workbook.getSheetAt(sheetNumber);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public int getRowCount(int sheetIndex) {
        int row = workbook.getSheetAt(sheetIndex).getLastRowNum();
        row += 1;
        return row;
    }
}
