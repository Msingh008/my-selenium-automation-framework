    package Listeners;

    import ReportManager.ExtentReportSetUp;
    import Utilities.CustomAnnotation;
    import Utilities.ExcelReader;
    import Utilities.ScreenshotUtils;
    import com.aventstack.extentreports.MediaEntityBuilder;
    import com.tmb.Wrappers.PropertyKeys;
    import com.tmb.Wrappers.PropertyReader;
    import com.tmb.Wrappers.WrapperMethods;
    import constants.FrameworkConstants;
    import org.openqa.selenium.TakesScreenshot;
    import org.testng.IAnnotationTransformer;
    import org.testng.ITestContext;
    import org.testng.ITestListener;
    import org.testng.ITestResult;
    import org.testng.annotations.ITestAnnotation;

    import java.awt.*;
    import java.io.File;
    import java.io.FileInputStream;
    import java.io.IOException;
    import java.lang.reflect.Constructor;
    import java.lang.reflect.Method;
    import java.util.List;
    import java.util.Map;
    import java.util.Properties;

    public class TestListeners implements IAnnotationTransformer, ITestListener {
        int count =1;
        List<Map<String, String>> data = ExcelReader.getDataFromExcelasMap("TestManager");

        public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
            for (int i = 0; i < data.size(); i++) {

             /*   if (data.get(i).get("TestCaseName").equalsIgnoreCase(testMethod.getName()) &&
                        !data.get(i).get("Execution").equalsIgnoreCase("Y")) {
                      annotation.setEnabled(false);
                                   annotation.setDescription(data.get(i).get("TestCase Description"));
                                   break;
                      // annotation.setInvocationCount(1);  */
                if(data.get(i).get("TestCaseName").equalsIgnoreCase(testMethod.getName())){
                    if(data.get(i).get("Execution").equalsIgnoreCase("Y")){
                        annotation.setInvocationCount(Integer.parseInt(data.get(i).get("InvocationCount")));
                        System.out.println("Method form datasheet "+data.get(i).get("TestCaseName"));
                        System.out.println("Current method form annotation transformer "+testMethod.getName());
                    }else { annotation.setEnabled(false);
                        System.out.println("Method form datasheet inside else "+data.get(i).get("TestCaseName"));
                        System.out.println("Current method form annotation transformer "+testMethod.getName());
                    };
                }

                }
            }



        public void onTestStart(ITestResult result) {
                  ExtentReportSetUp.setExtenttest(ExtentReportSetUp.extentReports.createTest(result.getName()));
          //  ExtentReportSetUp.logInfoDetails(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).testCategory());
          //  ExtentReportSetUp.logInfoDetails(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).AuthorName());

            ExtentReportSetUp.logInfoDetails(result.getMethod().getMethodName()+" execution has started!...");
            ExtentReportSetUp.logInfoDetails(result.getMethod().getDescription());
        }

        public void onTestSuccess(ITestResult result) {
            if(PropertyReader.get(PropertyKeys.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes")){
                ExtentReportSetUp.logPassDetails(result.getName()+" has passed successfully!...",ScreenshotUtils.getScreenshotAsBase64(WrapperMethods.getWebDriver()));
            }else
              ExtentReportSetUp.logPassDetails(result.getName()+" has passed successfully!...");
        }

        public void onTestFailure(ITestResult result) {

            ExtentReportSetUp.logFailDetails(result.getName()+" has failed");
            try {
                ExtentReportSetUp.logFailDetails("Reason for failure is..",ScreenshotUtils.getScreenshotAsBase64(WrapperMethods.getWebDriver()));
               // ScreenshotUtils.getScreenShotForFailure(WrapperMethods.getWebDriver(),FrameworkConstants.getScreenShotFolderPath());
               // System.out.println("Screenshot taken............");
              //  ExtentReportSetUp.logFailDetails("reason for failure....",FrameworkConstants.getScreenShotFolderPath());
              //  System.out.println("Screenshot stored............");

            } catch (Exception e) {
                System.out.println("Something went wrong while taking screenshot....");
                throw new RuntimeException(e);
            }
        }

        public void onStart(ITestContext context) {
            if(ExtentReportSetUp.extentReports==null){
                ExtentReportSetUp.getReportSchema();
            }
        }

        public void onFinish(ITestContext context) {
            ExtentReportSetUp.flushReport();
            try {
                Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "/test-reports/extreport.html").toURI());
            } catch (IOException e) {
                System.out.println("Something went wrong in opening the report in the browser!...");
            }

        }



    }
