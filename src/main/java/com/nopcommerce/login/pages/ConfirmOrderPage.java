package com.nopcommerce.login.pages;

import com.nopcommerce.login.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ConfirmOrderPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Credit Card')]")
    WebElement paymentMethod;
    @CacheLookup
    @FindBy(xpath = "//div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]")
    WebElement shippingtMethod;
    @CacheLookup
    @FindBy(xpath = "//tbody/tr[4]/td[2]/span[1]/strong[1]")
    WebElement price;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    WebElement confirmButton;
    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]")
    WebElement secondDayAir;
    @CacheLookup
    @FindBy(xpath = "//tbody/tr[4]/td[2]/span[1]/strong[1]")
    WebElement verifyPrice;

    public ConfirmOrderPage() {
        PageFactory.initElements(driver, this);
    }
    public String VerifyCreditCardPaymentMethod() {
        Reporter.log("Verify credit card payment method" + paymentMethod.toString());
        return getTextFromElement(paymentMethod);
    }

    public String verifyShippingMethod() {
        Reporter.log("Verify shipping method" + shippingtMethod.toString());
        return getTextFromElement(shippingtMethod);
    }

    public String verifyTheTotalPrice() {
        Reporter.log("verify total price" + price.toString());
        return getTextFromElement(price);
    }

    public void clickOnConFirm() {
        Reporter.log("click on confirm" + confirmButton.toString());
        clickOnElement(confirmButton);
    }

    public String VerifyShippingMethod2ndDayAir() {
        Reporter.log("verify shipping method" + secondDayAir.toString());
        return getTextFromElement(secondDayAir);
    }

    public String VerifyTheNokiaTotalPrice() {
        Reporter.log("verify nokia total price" + verifyPrice.toString());
        return getTextFromElement(verifyPrice);
    }
}
