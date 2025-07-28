package com.tmb.pages;

import com.tmb.Wrappers.WrapperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class AmazonHomePage extends  BasePage {
    private By amazonHameburgerIcon = By.xpath("//i[@class=\"hm-icon nav-sprite\"]");
    String rawXpath = "//div[text()='%s']/parent::a";
  By amazonPrime=By.xpath("//a[text()='Amazon Prime Video']");
    private By getElementAsPerInput(String text) {
        return By.xpath(rawXpath.replace("%s",text));
    }

    public String gettitle()  {
      return   getPageTitle();
    }

    public AmazonHomePage performClickUsingActions(){
        Actions actions=new Actions(WrapperMethods.getWebDriver());
        actions.moveToElement(WrapperMethods.getWebDriver().findElement(amazonPrime)).click().perform();
  return  this;
    }

    public AmazonHomePage clickOnAmazonPrime(){
        performClick(amazonPrime,"Amazon Prime Video");
        return  this;
    }
    public AmazonHomePage clickOnAmazonHameburgerIcon() {
        performClick(amazonHameburgerIcon, "amazonHameburgerIcon");
        return this;
    }

    public AmazonHomePage clickonTheElementWithText(String inputText) {
        performClick(getElementAsPerInput(inputText), inputText);
        return  this;
    }


}
