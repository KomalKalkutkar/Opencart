package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(linkText = "Checkout")
    WebElement checkoutLink;

    @FindBy(id = "button-payment-address")
    WebElement buttonBillingContinue;

    @FindBy(id = "button-shipping-address")
    WebElement buttonShippingContinue;

    @FindBy(id = "button-shipping-method")
    WebElement buttonShippingMethodContinue;

    @FindBy(name = "agree")
    WebElement checkboxTerms;

    @FindBy(id = "button-payment-method")
    WebElement buttonPaymentMethodContinue;

    @FindBy(id = "button-confirm")
    WebElement buttonConfirmOrder;

    @FindBy(css = "#content h1")
    WebElement successHeading;

    // Actions
    public void clickCheckout() {
        checkoutLink.click();
    }

    public void completeCheckoutProcess()  {
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        mywait.until(ExpectedConditions.visibilityOf(buttonBillingContinue));
        buttonBillingContinue.click();

        mywait.until(ExpectedConditions.visibilityOf(buttonShippingContinue));
        buttonShippingContinue.click();

        mywait.until(ExpectedConditions.visibilityOf(buttonShippingMethodContinue));
        buttonShippingMethodContinue.click();

        mywait.until(ExpectedConditions.visibilityOf(checkboxTerms));
        checkboxTerms.click();

        mywait.until(ExpectedConditions.visibilityOf(buttonPaymentMethodContinue));
        buttonPaymentMethodContinue.click();

        mywait.until(ExpectedConditions.visibilityOf(buttonConfirmOrder));
        buttonConfirmOrder.click();
    }

    public String getSuccessMessage() {
        return successHeading.getText();


    }
}



