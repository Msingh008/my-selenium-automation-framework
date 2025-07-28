package com.tmb.Wrappers;

import ReportManager.ExtentReportSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Objects;

public class WrapperMethods {
   private static WebDriver driver=null;
  private static ThreadLocal<WebDriver> dr=new ThreadLocal<>();

public static void setWebDriver(WebDriver driver){
    dr.set(driver);

}

    public static WebDriver getWebDriver(){
        return  dr.get();
    }

    public static void unloadDriver(){
    dr.remove();
    }



    public  static void initilizeDriver(String browser){
        if(Objects.isNull(getWebDriver())){
            if(browser.equalsIgnoreCase("Chrome")){
        driver=new ChromeDriver();
                System.out.println("Chrome browser is Launched");
            }
            else if (browser.equalsIgnoreCase("Firefox")){
                driver=new FirefoxDriver();
                System.out.println("Firefox browser is Launched");

            } else if (browser.equalsIgnoreCase("Edge")){
                driver=new EdgeDriver();
                System.out.println("Edge browser is Launched");

            }
        setWebDriver(driver);
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        getWebDriver().manage().window().maximize();
        getWebDriver().get(PropertyReader.get(PropertyKeys.URL).trim());
    }
       // return  getWebDriver();
    }


    public static void closeDriver(){
        if(Objects.nonNull(getWebDriver())){
        getWebDriver().quit();
        unloadDriver();
    }}
}
