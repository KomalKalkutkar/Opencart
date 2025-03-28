package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
    //constructpr
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    //Locators

    @FindBy(xpath = "//a[@title='My Account']")
    WebElement lnkMyAccount;
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register'] ")
    WebElement lnkRegister;

    //login elements
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement lnkLogin;



    //action methods

    public void clickMyAccount()
    {
        lnkMyAccount.click();
    }

    public void clickRegister()
    {
        lnkRegister.click();
    }

    public void clickLogin()
    {
        lnkLogin.click();
    }




}
