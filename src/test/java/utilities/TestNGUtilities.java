package utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestNGUtilities {
    protected BrowserFactory browserFactory;

    @BeforeTest
    public void initializeBrowser(){
        browserFactory = BrowserFactory.getBrowserFactory();
    }

    @AfterTest
    public void closeBrowser(){
        browserFactory.getDriver().quit();
    }
}
