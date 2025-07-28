package Utilities;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DataProviderUtility {

  @DataProvider(name = "LoginData", parallel = true)
    public static Object[] getLoginDataSet(){
        List<Map<String, String>> rawData = ExcelReader.getDataFromExcelasMap("TestDataProvider");
        List<Map<String, String>> actualData=new ArrayList<>();
        for(int i=0;i<rawData.size();i++){
            if(rawData.get(i).get("Execution").trim().equalsIgnoreCase("Y")){
             actualData.add(rawData.get(i));
            }
        }
      System.out.println(actualData);
        Object[] arrayOfData = actualData.toArray();
        return arrayOfData;
    }
}
