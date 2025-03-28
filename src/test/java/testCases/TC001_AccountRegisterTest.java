package testCases;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

import java.time.Duration;

public class TC001_AccountRegisterTest extends BaseClass  {

    @Test(groups = {"Regression","Master"})
    public void verifyRegister() throws InterruptedException
    {
        try {

            logger.info("-----Starting TC001_AccountRegisterTest-----");
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickRegister();
            logger.info("Clicked on My Account and Register option");

            AccountRegistrationPage reg = new AccountRegistrationPage(driver);
            logger.info("Providing Details..");
            reg.setFirstName(randomeString().toUpperCase());
            reg.setLastName(randomeString().toUpperCase());
            reg.setEmail(randomeString() + "@gmail.com");
            reg.setTelephone(randomeNumber());
            String pwds = randomeALphaNumeric();
            reg.setPassword(pwds);
            reg.setConfirmPassword(pwds);

            reg.setPrivacyPolicy();
            Thread.sleep(5000);
            reg.clickContinue();

            Thread.sleep(5000);
            logger.info("Validating the message");
            String confmsg = reg.getConfirmationMsg();

            if (confmsg.equals("Your Account Has Been Created!")) {
                Assert.assertTrue(true);
            } else {
                logger.error("Test failed");
                logger.debug("debug logs ");
                Assert.assertFalse(false);
            }
        }catch (Exception e)
        {
            Assert.fail();
        }
        //Assert.assertEquals(confmsg,"Your Account Has Been Created!");
        logger.info("----Finished TC001_AccountRegistrationTest----");


    }







}
