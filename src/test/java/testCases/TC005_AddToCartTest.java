package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddToCartPage;
import pageObjects.SearchPage;

public class TC005_AddToCartTest extends BaseClass
{
    SearchPage searchPage ;
    AddToCartPage addToCartPage;

    @Test
    public void addtocart()  {

        logger.info("----AddToCart Test Started-----");
        searchPage= new SearchPage(driver);
        searchPage.searchForProduct(p.getProperty("searchProductName1"));;
        addToCartPage=new AddToCartPage(driver);
        addToCartPage.clickProduct();
        addToCartPage.clickAddToCart();
        String expectedmsg ="Success: You have added MacBook to your shopping cart!";
        String msg = addToCartPage.verifymsg();
        Assert.assertTrue(msg.contains("Success"),"Add to cart failed");

        logger.info("----AddToCart Test Finished ----");
    }
}
