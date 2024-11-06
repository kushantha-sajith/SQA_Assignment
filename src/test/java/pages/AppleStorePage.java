package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import javax.xml.transform.Source;
import java.time.Duration;
import java.util.List;

public class AppleStorePage extends BaseUrl{

    public AppleStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//summary[@class='thb-filter-title' and contains(text(), 'Price')])[2]")
    public WebElement price;

    @FindBy(id = "Filter-Price-GTE")
    public WebElement minPriceInput;

    @FindBy(id = "Filter-Price-LTE")
    public WebElement maxPriceInput;

    public void selectPrice(){
        price.click();
    }

    public static Double parsePrice(String priceText) {
        // Remove non-numeric characters and trim the result
        String numericValue = priceText.replaceAll("[^\\d.]", "").trim();

        // Check if the numericValue is empty after removing non-numeric characters
        if (numericValue.isEmpty()) {
            System.out.println("Warning: Encountered an empty or invalid price string: '" + priceText + "'");
            return null; // or throw an exception if needed
        }

        return Double.parseDouble(numericValue);
    }

    public void setPrice(Integer minPrice, Integer maxPrice) {
        // Set the minimum and maximum price in the filter
        minPriceInput.clear();
        minPriceInput.sendKeys(String.valueOf(minPrice));
        maxPriceInput.clear();
        maxPriceInput.sendKeys(String.valueOf(maxPrice));

        // Submit or trigger the filter (if there's a button, click it; otherwise, use Enter)
        maxPriceInput.submit();

        // Wait for the filtered items to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Fetch the price elements after the filter is applied
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[contains(@class, 'amount discounted')]"));
        if (priceElements.size() > 5) {
            priceElements = priceElements.subList(0, 5);
        }

        // Loop through each price element to validate it is within the range
        for (WebElement priceElement : priceElements) {
            // Extract the price text, remove "Rs" and commas, then convert to a double
            String priceText = priceElement.getText().replace("Rs", "").replace(",", "").trim();
            Double price = parsePrice(priceText);

            // Assert that the price is within the specified range
            Assert.assertTrue(price >= minPrice && price <= maxPrice,
                    "Price " + price + " is not within the range: " + minPrice + " - " + maxPrice);
        }
    }
}
