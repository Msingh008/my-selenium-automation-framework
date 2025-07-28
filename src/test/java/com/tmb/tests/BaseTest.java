package com.tmb.tests;

import com.tmb.Wrappers.PropertyKeys;
import com.tmb.Wrappers.PropertyReader;
import com.tmb.Wrappers.WrapperMethods;
import com.tmb.pages.HomePage;
import com.tmb.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public class BaseTest {

    protected BaseTest(){

    }
    @BeforeMethod
    public void setUp(Object [] data,Method method){
        System.out.println("I am inside Befor method and Launching browser for method "+method.getName());
        try{
            System.out.println("Printing data in Object array.... "+Arrays.asList(data[0]));
            Map<String,String> dataAsMap=(Map<String,String>)data[0];
            WrapperMethods.initilizeDriver(dataAsMap.get("Browser"));
        } catch (Exception e) {
            System.out.println("As method is not linked to data provider.So moving ahead with default browser as per config.prop file....");
            WrapperMethods.initilizeDriver(PropertyReader.get(PropertyKeys.BROWSER));

        }


    }


    @AfterMethod
    public void tearDown(){
        WrapperMethods.closeDriver();
    }

    public HomePage loginAndNavigateToHomePage(){
        new LoginPage().enterUsername(PropertyReader.get(PropertyKeys.USERNAME))
                .enterPassword(PropertyReader.get(PropertyKeys.PASSWORD).trim())
                .clickLoginButton();
        return new HomePage();
    }

    public HomePage loginAndNavigateToHomePage(Map<String,String> credentials){
        new LoginPage().enterUsername(credentials.get("UserName"))
                .enterPassword(credentials.get("Password"))
                .clickLoginButton();
        return new HomePage();
    }

}
