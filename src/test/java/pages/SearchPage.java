package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SearchPage extends BaseUrl{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='side-panel-search-input']")
    public WebElement searchBox;

    public void searchItem(String item){
        searchBox.sendKeys(item);
        searchBox.submit();

        String productTitlesXPath = "//a[contains(@class, 'product-card-title')]";

        // Wait until the search results are loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Find all product title elements
        List<WebElement> productElements = driver.findElements(By.xpath(productTitlesXPath));

        // Check if at least one product title contains the search term
        boolean termFound = false;
        for (WebElement productElement : productElements) {
            String titleText = productElement.getText();
            System.out.println("Product Title: " + titleText);
            if (titleText.toLowerCase().contains(item.toLowerCase())) {
                termFound = true;
                break;
            }
        }

        // Assert that the search term was found in at least one product title
        Assert.assertTrue(termFound, "No product titles contain the search term: " + item);

        // Additional log to confirm success
        if (termFound) {
            System.out.println("The search term '" + item + "' was found in the search results.");
        }
    }
}
