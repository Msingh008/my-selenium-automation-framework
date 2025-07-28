package Utilities;

import constants.FrameworkConstants;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelReader {
    private ExcelReader(){
    }


    public static List<Map<String,String>> getDataFromExcelasMap(String sheetname){
        List<Map<String,String>> dataFromexcel=new ArrayList<>();
            try {
                File file = new File(FrameworkConstants.getExcelFilePath());
                FileInputStream fileInputStream=new FileInputStream(file);
                XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
                XSSFSheet sheet = workbook.getSheet(sheetname);
                int rowCount=sheet.getPhysicalNumberOfRows();
                int columnCount=sheet.getRow(0).getPhysicalNumberOfCells();

                for(int i=1;i<rowCount;i++){
                    Map<String,String> data=new HashMap<>();
                for(int j=0;j<columnCount;j++){
                    data.put(sheet.getRow(0).getCell(j).getStringCellValue(),sheet.getRow(i).getCell(j).getStringCellValue());
                }
                dataFromexcel.add(data);
                }

            } catch (FileNotFoundException e) {
                System.out.println("Problem occured while creating fileinputStream");;
            } catch (IOException e) {
                System.out.println("Problem occured while creating workbokk");;
            }
        return dataFromexcel;
    }

}
