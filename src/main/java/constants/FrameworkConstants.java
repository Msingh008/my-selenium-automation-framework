package constants;

import com.tmb.Wrappers.PropertyKeys;
import com.tmb.Wrappers.PropertyReader;

import java.time.LocalDateTime;
import java.util.Map;

public final class FrameworkConstants {

    private FrameworkConstants(){

    }
   private static final String DRIVERPATH= System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe";
   private static final int explicitWaitDuration=20;
   private   static String  screenShotFolderPath=System.getProperty("user.dir")+    "/Screenshots/image_"+LocalDateTime.now()+".jpg";
   static  ThreadLocal<String> sPathLocal=new ThreadLocal<>();

    private static void setspathLocal(String path){
        sPathLocal.set(path);
    }


    public static String getsPathLocal() {
        return sPathLocal.get();
    }

    ;
   private  static final String excelFilePath="D:\\OneDrive - Coforge Limited\\TestExecutor.xlsx";

   public static String getExcelFilePath(){
       return excelFilePath;

   }


   public static int getExplicitWaitDuration(){
       return explicitWaitDuration;
   }
    public static  String getDriverpath(){
        return DRIVERPATH;
    }

    public static String getScreenShotFolderPath(){

        System.out.println("Screenshot folder path is : "+screenShotFolderPath);
       setspathLocal(screenShotFolderPath);

       return getsPathLocal();
    }
}
