package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage
{
    public ShoppingCartPage(WebDriver driver)
    {
        super(driver);
    }

    //Locators
    @FindBy(xpath="//span[text()='Shopping Cart']")
    WebElement linkshoppingcart;

    @FindBy(xpath = "//div[@id='content']//table//tbody//tr//td[2]/a")
    WebElement cartProductName;

    //Actions
    public void clickShoppingCart()
    {
        linkshoppingcart.click();
    }

    public String getProductNameInCart()
    {
        return cartProductName.getText();
    }


}
