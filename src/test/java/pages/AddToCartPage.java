package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BaseUrl {
    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='plus']")
    public WebElement plus;

    @FindBy(xpath = "//button[@id='AddToCart']")
    public WebElement addToCart;

    @FindBy(xpath = "//label[@for='CartTerms-Drawer']")
    public WebElement termsAndConditions;

    @FindBy(xpath = "//button[@title='Checkout']")
    public WebElement checkout;

    public void increaseQuantity(){
        plus.click();
    }

    public void addToCart(){
        addToCart.click();
    }

    public void acceptTermsAndConditions(){
        termsAndConditions.click();
    }

    public void checkout(){
        checkout.click();
    }
}
