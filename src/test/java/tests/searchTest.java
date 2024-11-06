package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.AppleStorePage;
import pages.BaseUrl;
import pages.HomePage;
import pages.MobilePage;
import pages.SearchPage;
import utilities.PriceFilterDataProvider;
import utilities.TestNGUtilities;

public class searchTest extends TestNGUtilities {

    @Test
    public void searchMobilePhones() throws InterruptedException {
        BaseUrl url = PageFactory.initElements(browserFactory.getDriver(), BaseUrl.class);
        HomePage home = url.loadUrl("https://www.simplytek.lk/");
        Thread.sleep(1000);
        home.moveToElement();
        Thread.sleep(1000);
        MobilePage mobile = home.clickOnMobile();
        Thread.sleep(2000);
        mobile.selectAvailability();
        Thread.sleep(2000);
    }

    @Test(dataProvider = "priceRanges", dataProviderClass = PriceFilterDataProvider.class)
    public void searchAppleStore(Integer minPrice, Integer maxPrice) throws InterruptedException {
        BaseUrl url = PageFactory.initElements(browserFactory.getDriver(), BaseUrl.class);
        HomePage home = url.loadUrl("https://www.simplytek.lk/");
        Thread.sleep(1000);
        home.moveToElement();
        Thread.sleep(1000);
        AppleStorePage appleStore = home.clickOnAppleStore();
        Thread.sleep(1000);
        appleStore.selectPrice();
        Thread.sleep(2000);
        appleStore.setPrice(minPrice, maxPrice);
        Thread.sleep(2000);
    }

    @Test
    public void searchItems() throws InterruptedException {
        BaseUrl url = PageFactory.initElements(browserFactory.getDriver(), BaseUrl.class);
        HomePage home = url.loadUrl("https://www.simplytek.lk/");
        Thread.sleep(1000);
        SearchPage search = home.clickOnSearch();
        Thread.sleep(2000);
        search.searchItem("P25");
        Thread.sleep(2000);
    }

    @Test
    public void addToCart() throws InterruptedException {
        BaseUrl url = PageFactory.initElements(browserFactory.getDriver(), BaseUrl.class);
        HomePage home = url.loadUrl("https://www.simplytek.lk/");
        Thread.sleep(1000);
        home.scrollPage(0,700);
        Thread.sleep(1000);
        AddToCartPage addToCart = home.ShopNow();
        Thread.sleep(1000);
        addToCart.increaseQuantity();
        Thread.sleep(2000);
        addToCart.addToCart();
        Thread.sleep(2000);
        addToCart.acceptTermsAndConditions();
        Thread.sleep(2000);
        addToCart.checkout();
        Thread.sleep(2000);
    }
}