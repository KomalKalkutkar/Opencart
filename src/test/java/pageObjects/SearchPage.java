package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage
{
    public SearchPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchButton;

    @FindBy(xpath= "//p[contains(text(),'There is no product that matches the search criter')]")
    WebElement noProductMessage;

    @FindBy(xpath = "//div[@class=\"product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12\"]")
    List<WebElement> productList;


    //Action
    public void searchForProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public boolean isProductVisible() {
        return productList.size() > 0;
    }

    public boolean isNoProductMessageVisible() {
        return noProductMessage.isDisplayed();
    }

}
