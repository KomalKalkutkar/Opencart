package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass {

    @Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups="Datadriven")
    public void verify_loginDDT(String email,String pwd,String exp)
    {
        logger.info("----Starting TC003_LoginDataDrivenTest------");

        try {
            //HomePage
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            logger.info("Clicked login ");

            //LoginPage
            LoginPage lp = new LoginPage(driver);
            lp.enterEmail(email);
            lp.enterPassword(pwd);
            lp.clickLogin();

            logger.info("Clicked on Login Button");

            //MyAccount Page
            MyAccountPage ap = new MyAccountPage(driver);
            boolean res = ap.isMyAccountExists();

            if (exp.equalsIgnoreCase("Valid")) {
                if (res == true) {
                    ap.clickLogout();
                    Assert.assertTrue(true);

                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (res == true) {
                    ap.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }

            }
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("----Finished TC003_LoginDataDrivenTest------");











    }
}
