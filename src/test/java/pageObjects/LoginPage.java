package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //constructor
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    //Locators

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    // Action Methods

    //Enter email
    public void enterEmail(String eml)
    {
        txtEmail.sendKeys(eml);
    }
    //Enter password
    public void enterPassword(String pswd)
    {
        txtPassword.sendKeys(pswd);
    }
    // CLick on Login
    public void clickLogin()
    {
        btnLogin.click();
    }



}
