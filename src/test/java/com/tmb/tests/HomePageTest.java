package com.tmb.tests;

import com.tmb.Wrappers.PropertyKeys;
import com.tmb.Wrappers.PropertyReader;
import com.tmb.Wrappers.WrapperMethods;
import com.tmb.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
public class HomePageTest extends BaseTest{
    @Test
    public void varifyPresenceOfDashboardOnhomPage(){
       String dashboard= loginAndNavigateToHomePage().gettextOfDashboardInHomePage();
        Assert.assertEquals(dashboard,"Dashboard");
    }
}
