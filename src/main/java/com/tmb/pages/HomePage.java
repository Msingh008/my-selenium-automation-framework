        package com.tmb.pages;

        import ReportManager.ExtentReportSetUp;
        import com.tmb.Wrappers.WrapperMethods;
        import org.openqa.selenium.By;

        public class HomePage extends BasePage{
            By userProfileDrpDwn= By.xpath("//img[@src=\"/web/index.php/pim/viewPhoto/empNumber/7\"]");
            By linkLogout=By.linkText("Logout");


            public  HomePage clickOnUserprofile(){
                 performClick(userProfileDrpDwn,"\'User profile dropdown\'");
                ExtentReportSetUp.logInfoDetails("Clicked on user profile icon.....");
                 return this;
            }
            public LoginPage clickOnLogoutLink(){
                    performClick(linkLogout,"Logout");
                    ExtentReportSetUp.logInfoDetails("Clicked on logout button....");
                    return new LoginPage();
            }

            public String gettextOfDashboardInHomePage(){
                String dashboardText = WrapperMethods.getWebDriver().findElement(By.xpath("//h6[text()='Dashboard']")).getText();
                return  dashboardText;
            }
        }
