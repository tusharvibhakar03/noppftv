package com.nopcommerce.login.testsuite;

import com.nopcommerce.login.pages.HomePage;
import com.nopcommerce.login.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;


    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(groups = {"sanit","regression"})
    public void verifyPageNavigation() {
        mouseHoverToElement(By.xpath("//a[@href='/computers']"));
        homePage.selectMenu("computers");
    }
}
