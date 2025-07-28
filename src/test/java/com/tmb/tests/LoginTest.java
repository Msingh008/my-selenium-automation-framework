package com.tmb.tests;

import Utilities.CustomAnnotation;
import Utilities.DataProviderUtility;
import com.tmb.Wrappers.PropertyKeys;
import com.tmb.Wrappers.PropertyReader;
import com.tmb.Wrappers.WrapperMethods;
import com.tmb.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.Map;

public final  class  LoginTest extends BaseTest {
    @Test
    @CustomAnnotation(
            AuthorName = "Manish Singh",testCategory = "Regression"
    )
    public void validateUserLoginAndLogout() {
        boolean flag=new LoginPage().enterUsername(PropertyReader.get(PropertyKeys.USERNAME)).enterPassword(PropertyReader.get(PropertyKeys.PASSWORD).trim()).clickLoginButton()
                .clickOnUserprofile().clickOnLogoutLink()
                .varifyTitle("OrangeHRM");
        Assert.assertTrue(flag);


    }
    @CustomAnnotation(
            AuthorName = "Manish Singh",testCategory = "Regression"
    )
   @Test(dataProvider = "LoginData" ,dataProviderClass = DataProviderUtility.class)
    public void validateLoginwithDifferentSetOfValues(Map<String,String> data){
       System.out.println("Userid and pass for the iteration: "+data);
        String textOnHomePage = loginAndNavigateToHomePage(data).gettextOfDashboardInHomePage();
        Assert.assertEquals("Dashboard",textOnHomePage);
    }
}
