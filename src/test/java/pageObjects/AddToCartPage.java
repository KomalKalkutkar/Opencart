package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class AddToCartPage extends BasePage
{

    public AddToCartPage(WebDriver driver )
    {
        super(driver);
    }



    //Locators
    @FindBy(xpath ="//a[contains(text(),'HP LP')]")
    WebElement productLink;

    @FindBy(id = "button-cart")
    WebElement buttonAddToCart;

    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;

    //Action methods


    public void clickProduct()  {


        // Wait until the element is visible

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);window.scrollBy(0,-100);", productLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productLink);


        //productLink.click();
    }

    public void clickAddToCart()
    {
        buttonAddToCart.click();
    }

    public String verifymsg()
    {
        return successMessage.getText();

    }

}
