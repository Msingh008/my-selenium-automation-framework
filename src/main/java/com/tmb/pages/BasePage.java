package com.tmb.pages;

import ReportManager.ExtentReportSetUp;
import com.tmb.Wrappers.WrapperMethods;
import constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected void performClick(By by,String fieldName){
        explicitelyWaitFor(by,ExplicitWaitParameter.CLICKABLE);
        WrapperMethods.getWebDriver().findElement(by).click();
        ExtentReportSetUp.logInfoDetails("User has clicked on "+fieldName+" button...");
    }

    protected void sendKeysTo(By by,String value,String inputFieldName){
        explicitelyWaitFor(by,ExplicitWaitParameter.VISIBILITY);
        WrapperMethods.getWebDriver().findElement(by).sendKeys(value);
        ExtentReportSetUp.logInfoDetails("Value: "+value+" entered in the "+inputFieldName);

    }
    private void explicitelyWaitFor(By by,ExplicitWaitParameter waitParameter){
        WebDriverWait wait=new WebDriverWait(WrapperMethods.getWebDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitDuration()));
        switch (waitParameter){
            case PRESENCE->
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            case CLICKABLE ->
                    wait.until(ExpectedConditions.elementToBeClickable(by));
            case VISIBILITY ->
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            case INVISIBILITY ->
                wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        }
    }

    protected String getPageTitle(){
      return   WrapperMethods.getWebDriver().getTitle();
    }
}
