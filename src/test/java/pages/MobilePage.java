package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePage extends BaseUrl{
    public MobilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//summary[@class='thb-filter-title' and contains(text(), 'Availability')])[2]")
    public WebElement availability;

    @FindBy(xpath = "//input[@id='Filter-availability-1']")
    public WebElement inStock;

    public void selectAvailability(){
        availability.click();
        inStock.click();
    }
}
