package com.nopcommerce.login.pages;


import com.nopcommerce.login.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CheckOutAsGuestPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Welcome, Please Sign In!']")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//button[text()= 'Checkout as Guest']")
    WebElement guestButton;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement registerTab;

    public CheckOutAsGuestPage() {
        PageFactory.initElements(driver, this);
    }
    public String VerifyTheWelComeText() {
        Reporter.log("Verify welcome text" + welcomeText.toString());
        return getTextFromElement(welcomeText);
    }

    public void clickOnAsGuestButton() {
        Reporter.log("Click on As guest button " + guestButton.toString());
        clickOnElement(guestButton);
    }

    public void clickOnARegisterTab() {
        Reporter.log("click on register tab" + registerTab.toString());
        clickOnElement(registerTab);
    }
}
