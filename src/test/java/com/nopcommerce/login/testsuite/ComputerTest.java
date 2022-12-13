package com.nopcommerce.login.testsuite;

import com.nopcommerce.login.pages.*;
import com.nopcommerce.login.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

public class ComputerTest extends BaseTest {
    HomePage homePage;
    DeskTopPage deskTopPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutAsGuestPage checkOutAsGuestPage;
    BillingCheckOutPage checkOutPage;
    ShippingMethodCheckOutPage checkoutPage1;
    PaymentMethodCheckOutPage checkOutPage2;
    PaymentCheckOutPage checkOutPage3;
    ConfirmOrderPage confirmOrderPage;
    CompletedCheckOutPage completedCheckoutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        deskTopPage = new DeskTopPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutAsGuestPage = new CheckOutAsGuestPage();
        checkOutPage = new BillingCheckOutPage();
        checkoutPage1 = new ShippingMethodCheckOutPage();
        checkOutPage2 = new PaymentMethodCheckOutPage();
        checkOutPage3 = new PaymentCheckOutPage();
        confirmOrderPage = new ConfirmOrderPage();
        completedCheckoutPage = new CompletedCheckOutPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() {
        homePage.selectMenu("computers");
        homePage.clickOnDeskTop();
        deskTopPage.selectSortByName("Name: Z to A");
        Map<String, ArrayList> mapArrays = deskTopPage.arrangeProductInDescendingOrder();
        Assert.assertEquals(mapArrays.get("originalProductsName"), mapArrays.get("afterSortByZToAProductsName"));
    }

    @Test(groups = {"smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        homePage.selectMenu("computers");
        homePage.clickOnDeskTop();
        deskTopPage.selectSortByName("Name: A to Z");
        Thread.sleep(2000);
        deskTopPage.clickOnAddToCart();
        Assert.assertEquals(buildYourOwnComputerPage.VerifytheTextBuildyourowncomputer(), "Build your own computer", "Text is not Display");
        buildYourOwnComputerPage.selectProcessor("1");
        buildYourOwnComputerPage.selectRam("5");
        buildYourOwnComputerPage.selectHDDRadio();
        buildYourOwnComputerPage.selectOSRadiVistaPremium();
        buildYourOwnComputerPage.selectSoftware();
        Assert.assertEquals(buildYourOwnComputerPage.VerifythePrice(), "$1,475.00", "Price is not match");
        buildYourOwnComputerPage.clickOnAddToCartButton();
        Assert.assertEquals(buildYourOwnComputerPage.VerifytheMessageOnTopGreenbar(), "The product has been added to your shopping cart", "Message doesnot match");
        buildYourOwnComputerPage.clickOnCloseBar();
        buildYourOwnComputerPage.mouseHoverOnShoppingCart();
        Thread.sleep(2000);
        buildYourOwnComputerPage.clickOnShoppingCart();
        Assert.assertEquals(shoppingCartPage.verifyTheShoppingCartText(), "Shopping cart", "Text is not display");
        shoppingCartPage.updateQuantity();
        shoppingCartPage.updateShoppingCart();
        Assert.assertEquals(shoppingCartPage.verifyTheTotalPrice(), "$2,950.00", "Price is not match");
        shoppingCartPage.clickOnCheckBox();
        shoppingCartPage.clickOnCheckOutButton();
        Assert.assertEquals(checkOutAsGuestPage.VerifyTheWelComeText(), "Welcome, Please Sign In!", "Text is not matched");
        checkOutAsGuestPage.clickOnAsGuestButton();
        //Fill ALl Fields
        checkOutPage.enterBillingFirstName("Tushar");
        checkOutPage.enterBillingLastName("Vibhakar");
        checkOutPage.enterBillingEmailAddress("tv@gmail.com");
        checkOutPage.selectCountryFromDropDown("233");
        checkOutPage.selectStateFromDropDown("0");
        checkOutPage.enterBillingCity("London");
        checkOutPage.enterBillingAddress("5,Cecil Road");
        checkOutPage.enterBillingZipcode("HA3 5RA");
        checkOutPage.enterBillingPhoneNumber("5665995116994");
        checkOutPage.clickOnCheckOutButton();
        checkoutPage1.clickOnRedioButtonBextDayAir();
        checkoutPage1.clickOnContinue();
        checkOutPage2.clickOnCreditCard();
        checkOutPage2.clickOnContinue();
        checkOutPage3.enterCardHolderName("T Vibhakar");
        checkOutPage3.enterCardNumber("5555555555554444");
        checkOutPage3.selectExpiryMonthFromDropDown("5");
        checkOutPage3.selectExpiryYearFromDropDown("2023");
        checkOutPage3.enterCardCode("3101");
        checkOutPage3.clickOnContinueButton();
        Assert.assertEquals(confirmOrderPage.VerifyCreditCardPaymentMethod(), "Credit Card", "Method is not correct");
        Assert.assertEquals(confirmOrderPage.verifyShippingMethod(), "Next Day Air", "method is not correct");
        Assert.assertEquals(confirmOrderPage.verifyTheTotalPrice(), "$2,950.00", "Price is not Match");
        confirmOrderPage.clickOnConFirm();
        Assert.assertEquals(completedCheckoutPage.verifyThankYouText(), "Thank you", "Text isnot Display");
        Assert.assertEquals(completedCheckoutPage.verifySuccessOrderText(), "Your order has been successfully processed!", "Text isnot Display");
        completedCheckoutPage.clickOnContinue();
        Assert.assertEquals(homePage.verifyWelComeText(), "Welcome to our store", "Text isnot Display");
    }
}
