package com.tmb.pages;

import com.tmb.Wrappers.WrapperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends  BasePage{

   private By inputFieldUserName=By.xpath("//input[@name='username']");
   private By inputFieldPassword=By.xpath("//input[@name='password' and @type='password']");
   private By buttonLogin=By.xpath("//button[@type='submit']");

    public LoginPage enterUsername(String userName){
        sendKeysTo(inputFieldUserName,userName,"UserName");
        return this;
    }

    public LoginPage enterPassword(String password){
                sendKeysTo(inputFieldPassword,password,"Password field");
                return this;
    }
    public HomePage clickLoginButton(){
          performClick(buttonLogin,"Login button");
        System.out.println("Clicked on login button");
          return new HomePage();
    }
    public boolean varifyTitle(String expectedTitle){
        if(WrapperMethods.getWebDriver().getTitle().equals(expectedTitle)){
            return true;
        }
        return false;
    }
}
