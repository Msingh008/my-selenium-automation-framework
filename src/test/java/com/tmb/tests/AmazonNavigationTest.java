package com.tmb.tests;

import com.tmb.pages.AmazonHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AmazonNavigationTest extends BaseTest {
    @Test
    public void checkHemburgerNaviationInAmazon() throws InterruptedException {
        String pagetitle=new AmazonHomePage().clickOnAmazonHameburgerIcon().clickonTheElementWithText("Fire TV").performClickUsingActions().gettitle();
        System.out.println("Page title is..."+pagetitle);
        Assert.assertTrue(pagetitle.contains("Amazon Prime Video"));
    }

}
