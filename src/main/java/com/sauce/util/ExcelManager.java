package com.sauce.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public final class ExcelManager {

    private Workbook workbook;
    private Sheet sheet;

    private ExcelManager(){

    }

    static Workbook getWorkbook(String fileName) throws FileNotFoundException {
        String path = Paths.get("src", "test", "data", fileName+".xlsx").toAbsolutePath().toString();
        try(FileInputStream fs = new FileInputStream(path)){
            return new XSSFWorkbook(fs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Sheet getSheet(String fileName, String sheetName) throws FileNotFoundException {
        return getWorkbook(fileName).getSheet(sheetName);
    }


    public static Map<String,String> getData(String fileName, String sheetName, String tc_no) throws FileNotFoundException {
        Map<String, String> data = new HashMap<>();
        Sheet sheet=getSheet(fileName, sheetName);
        int tc=Integer.parseInt(tc_no.substring(tc_no.length()-1));
        Row row =sheet.getRow(tc);
        Row cols =sheet.getRow(0);
        for(int i=0; i<row.getLastCellNum(); i++){
            data.put(cols.getCell(i).getStringCellValue(), row.getCell(i).getStringCellValue());
        }
        return data;
    }


   /* static void main() throws FileNotFoundException {
        Workbook wb = getWorkbook("testData");
        Map<String,String> data=getData("testData","users", "1");
        System.out.println(data);



    }*/
}
