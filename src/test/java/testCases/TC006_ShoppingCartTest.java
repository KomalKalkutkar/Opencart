package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddToCartPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;

public class TC006_ShoppingCartTest extends BaseClass
{
    SearchPage search ;
    AddToCartPage addToCartPage;
    ShoppingCartPage shoppingCartPage;

    @Test
    public void verifyProductInCart()  {

        logger.info("---VerifyProductInCart Test Started-----");
        search = new SearchPage(driver);
        search.searchForProduct(p.getProperty("searchProductName1"));

        addToCartPage=new AddToCartPage(driver);
        addToCartPage.clickProduct();
        addToCartPage.clickAddToCart();

        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickShoppingCart();
        String productname = shoppingCartPage.getProductNameInCart();
        System.out.println(productname);

        //validations
        Assert.assertEquals(productname,"HP LP3065","Product name in cart doesnot match");

        logger.info("---VerifyProductInCart Test Finished-----");
    }


}
