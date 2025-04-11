package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SearchPage;

public class TC004_SearchTest extends BaseClass
{

    SearchPage searchPage ;


    @Test
    public void validSearchTest() {

        logger.info("----SearchTest Starting ------");
        searchPage = new SearchPage(driver);
        searchPage.searchForProduct(p.getProperty("searchProductName1"));
        Assert.assertTrue(searchPage.isProductVisible(), "Product should be visible but it's not.");
        logger.info("----SearchTest Finished ------");
    }

    @Test
    public void invalidSearchTest() {

        logger.info("----SearchTest for Invalid data Starting ------");

        searchPage = new SearchPage(driver);
        searchPage.searchForProduct("asdfgh12345");
        Assert.assertTrue(searchPage.isNoProductMessageVisible(), "No product message should be shown.");

        logger.info("----SearchTest for invalid data Finished  ------");
    }


}
