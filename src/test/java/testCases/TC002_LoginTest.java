package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass
{
    @Test(groups = {"Sanity","Master"})
    public void verify_login()
    {
        logger.info("-----Starting LoginTest-----");

        try
        {

            //HomePage
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            logger.info("Clicked login ");

            //LoginPage
            LoginPage lp = new LoginPage(driver);
            lp.enterEmail(p.getProperty("email"));
            lp.enterPassword(p.getProperty("password"));
            lp.clickLogin();

            logger.info("Clicked on Login Button");

            //MyAccount Page
            MyAccountPage ap = new MyAccountPage(driver);
            boolean res = ap.isMyAccountExists();

            Assert.assertTrue(res);
        } catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("------Finished LoginTest----");


    }
}
