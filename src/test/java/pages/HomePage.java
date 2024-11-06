package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseUrl{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    @FindBy(xpath = "//li[@class='menu-item-has-children menu-item-has-megamenu' and @data-item-title='Categories']/a")
    public WebElement category;

    @FindBy(xpath = "//*[text()='Mobile Phones']")
    public WebElement mobilePhones;

    @FindBy(xpath = "(//*[text()='Apple Store'])[2]")
    public WebElement appleStore;

    @FindBy(xpath = "//a[@title='Search']")
    public WebElement search;

    @FindBy(xpath = "//a[contains(@class, 'button') and contains(@class, 'white') and contains(@class, 'medium')]")
    public WebElement shopNow;

    public void moveToElement(){
        actions.moveToElement(category).perform();
    }

    public MobilePage clickOnMobile(){
        mobilePhones.click();
        return PageFactory.initElements(driver, MobilePage.class);
    }

    public AppleStorePage clickOnAppleStore(){
        appleStore.click();
        return PageFactory.initElements(driver, AppleStorePage.class);
    }

    public SearchPage clickOnSearch(){
        search.click();
        return PageFactory.initElements(driver, SearchPage.class);
    }

    public AddToCartPage ShopNow(){
        shopNow.click();
        return PageFactory.initElements(driver, AddToCartPage.class);
    }
}
