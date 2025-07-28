    package Utilities;

    import constants.FrameworkConstants;
    import org.apache.commons.io.FileUtils;
    import org.openqa.selenium.OutputType;
    import org.openqa.selenium.TakesScreenshot;
    import org.openqa.selenium.WebDriver;
    import org.testng.ITestResult;

    import java.io.File;
    import java.io.IOException;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import java.util.Base64;

    public final class ScreenshotUtils {
        private ScreenshotUtils(){};

        public static void getScreenShotForFailure(WebDriver driver,String storagePath) throws IOException {
            System.out.println("Inside screenshot mehtod............");
           File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            System.out.println("screenshot has been taken.........");
            FileUtils.copyFile(source,new File(storagePath));
            System.out.println("Screenshot has been stored in the path.........");
        }

        public static String getScreenshotAsBase64(WebDriver driver){
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        }

        public static String generateImageName(ITestResult result){
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("DD-MM-YYYY_HH:mm:ss");
            String formattedCurrentTime=LocalDateTime.now().format(dateTimeFormatter);
            System.out.println("Formatted cureent time is: "+formattedCurrentTime);
            return  result.getTestClass().getRealClass().getSimpleName()+"-"+result.getMethod().getMethodName()+"_"+formattedCurrentTime+"img.png";
        }
    }
