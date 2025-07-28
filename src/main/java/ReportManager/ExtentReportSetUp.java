    package ReportManager;

    import com.aventstack.extentreports.ExtentReports;
    import com.aventstack.extentreports.ExtentTest;
    import com.aventstack.extentreports.MediaEntityBuilder;
    import com.aventstack.extentreports.Status;
    import com.aventstack.extentreports.markuputils.ExtentColor;
    import com.aventstack.extentreports.markuputils.Markup;
    import com.aventstack.extentreports.markuputils.MarkupHelper;
    import com.aventstack.extentreports.reporter.ExtentSparkReporter;
    import com.aventstack.extentreports.reporter.configuration.Theme;
    import org.apache.commons.io.FileUtils;
    import org.apache.poi.ss.formula.functions.T;
    import org.apache.poi.xssf.usermodel.XSSFSheet;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    import org.openqa.selenium.OutputType;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.io.File;
    import java.io.FileInputStream;
    import java.time.Duration;
    import java.util.Objects;

    public final class ExtentReportSetUp {
        private ExtentReportSetUp(){};
        //private static ExtentTest extentTest;
        private static  ThreadLocal<ExtentTest> tLocalExtenttest=new ThreadLocal<>();


        public static void setExtenttest(ExtentTest test){

            tLocalExtenttest.set(test);
        }

        public static  ExtentTest getExtentTest(){
            return tLocalExtenttest.get();
        }


        public    static  ExtentReports extentReports=null;
        public static ExtentReports getReportSchema(){
            if(Objects.isNull(extentReports)){
            String reportPath = System.getProperty("user.dir") + "/test-reports/extreport.html";
            ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(new File(reportPath));
            extentSparkReporter.config().setReportName("HRM-Test-Report");
            extentSparkReporter.config().setDocumentTitle("Test-Reports");
            extentSparkReporter.config().setTheme(Theme.STANDARD);
             extentReports=new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);

            }
            return extentReports;
// Adding this comment just to check if github hook trigger works or not....
        }

       public static void flushReport(){
            extentReports.flush();
            }

            public  static void logPassDetails(String message){
             getExtentTest().pass( MarkupHelper.createLabel(message, ExtentColor.GREEN));
            }

            public  static void logPassDetails(String message,String base64image){
            getExtentTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(base64image).build());
        }



        public  static void logInfoDetails(String message){
            getExtentTest().info( MarkupHelper.createLabel(message, ExtentColor.GREY));
        }

        public static  void logFailDetails(String message){
            getExtentTest().fail( MarkupHelper.createLabel(message, ExtentColor.RED));
        }


        public static  void logFailDetails(String message,String base64image){
            getExtentTest().fail( MarkupHelper.createLabel(message, ExtentColor.RED));
            System.out.println("Here 1....");
            getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64image).build());
            System.out.println("Here 2....");


        }

    }
