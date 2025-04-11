package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

import java.time.Duration;

import static testCases.BaseClass.driver;

public class TC007_CheckOutTest extends BaseClass
{
    SearchPage searchPage;
    HomePage hp;
    LoginPage loginPage;
    AddToCartPage addToCartPage;
    ShoppingCartPage shoppingCartPagecartPage;
    CheckOutPage checkoutPage;

    @Test
    public void completeCheckoutTest() throws InterruptedException {

        logger.info("---CompleteCheckOut Test Started-----");

        //login

        hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();


        loginPage= new LoginPage(driver);
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        logger.info("User Logged In");

        //search
       Thread.sleep(10);
        searchPage= new SearchPage(driver);
        searchPage.searchForProduct(p.getProperty("searchProductName1"));

        logger.info("User Searched the Product");

        addToCartPage=new AddToCartPage(driver);
        addToCartPage.clickProduct();
        addToCartPage.clickAddToCart();

        logger.info("User added the product to cart");

        //shopping cartpage
        shoppingCartPagecartPage=new ShoppingCartPage(driver);
        shoppingCartPagecartPage.clickShoppingCart();

        logger.info("User is in Shopping cart Page ");


       //checkout
        checkoutPage= new CheckOutPage(driver);
        checkoutPage.clickCheckout();
        checkoutPage.completeCheckoutProcess();

        logger.info("Completed checkout");

        //validations
       Thread.sleep(3000);
        String message = checkoutPage.getSuccessMessage();
        Assert.assertEquals(message, "Your order has been placed!", "Checkout failed or success message missing.");

        logger.info("---CompleteCheckOut Test Finished -----");
    }



}
