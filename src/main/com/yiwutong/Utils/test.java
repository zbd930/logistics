package com.yiwutong.Utils;

import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        try{
            getExcel();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List getExcel() throws FileNotFoundException, IOException {
        File excelFile = new File("E:\\美国供应商报价.xls");
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(excelFile));
        HSSFSheet sheet = wb.getSheetAt(0);
        List<List<String>> listAll = new ArrayList<List<String>>();
        for (Row row : sheet) {
            List<String> list = new ArrayList<String>();
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING://字符串
                        String  categoryName = cell.getRichStringCellValue().getString();
                        list.add(categoryName);
                        System.out.print(" ");
                        break;
                    case Cell.CELL_TYPE_NUMERIC://数值与日期
                        String axis = Double.toString(cell.getNumericCellValue());
                        list.add(axis);
                        System.out.print(" ");
                        break;
                    default:
                }
            }
            listAll.add(list);
            System.out.println();
        }
        System.out.println(listAll);
        System.out.println(listAll.size());
        return listAll;
    }
}
