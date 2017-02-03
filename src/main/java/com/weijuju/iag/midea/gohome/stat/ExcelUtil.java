package com.weijuju.iag.midea.gohome.stat;/**
 * Created by zhangyin on 2016/9/20.
 */


import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * excel生成工具类
 *
 * @author zhangyin
 * @create 2016-09-20
 */
public class ExcelUtil {

    XSSFWorkbook workbook;

    public ExcelUtil() {
        try {
            workbook = new XSSFWorkbook();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  <T> void generateSheet(String sheetName, List<T> list, String[] title, String [] key){
        if(title.length!=key.length){
            throw new IllegalArgumentException("标题列跟属性列的长度应当一致");
        }
        try {
            XSSFSheet sheet = workbook.createSheet(sheetName);
            int row=0;
            XSSFRow titleRow = sheet.createRow(row++);
            for (int i = 0; i < title.length; i++) {
                sheet.autoSizeColumn(i);
                XSSFCell cell = titleRow.createCell(i);
                cell.setCellValue(title[i]);
            }
            for(int i=0;i<list.size();i++) {
                T t=list.get(i);
                XSSFRow valueRow = sheet.createRow(row++);
                Map<String, String> stringStringMap = EntityUtils.objectToHash(t);
                for (int j = 0; j < key.length; j++) {
                    XSSFCell cell = valueRow.createCell(j);
                    String value;
                    value=stringStringMap.get(key[j]);
                    if(StringUtils.isEmpty(value)){
                        char c=key[j].charAt(0);
                       if(Character.isUpperCase(c)){
                           String substring = key[j].substring(1);
                           String s = Character.toLowerCase(c) + "" + substring;
                           value=stringStringMap.get(s);
                       }
                    }
                    cell.setCellValue(value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(OutputStream os){
        try {
            workbook.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
