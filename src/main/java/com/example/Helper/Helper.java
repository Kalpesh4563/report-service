package com.example.Helper;

import com.example.model.Product;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class Helper {

    public static String[] header = {"PRODUCT-ID","PRODUCT-NAME","PRODUCT-DESC","PRODUCT-ADDRESS","PRODUCT-LOCATION"};
    public static String sheetName = "product_data";
    
    public static ByteArrayInputStream dataExcel(List<Product> list) throws IOException {

        Workbook book = new HSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Sheet sheet =  book.createSheet(sheetName);

        // Header Row
        Row row = sheet.createRow(0);
        for(int i=0; i<header.length ; i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(header[i]);
        }

        // Value Row
        int rowIndex = 1;
        for(Product p : list){
            Row rowDate = sheet.createRow(rowIndex);
            rowIndex++;

            rowDate.createCell(0).setCellValue(p.getId());
            rowDate.createCell(1).setCellValue(p.getName());
            rowDate.createCell(2).setCellValue(p.getDesc());
            rowDate.createCell(3).setCellValue(p.getAddress());
            rowDate.createCell(4).setCellValue(p.getLocation());
        }

        book.write(out);

        return new ByteArrayInputStream(out.toByteArray());

    }
}
