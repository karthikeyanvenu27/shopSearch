package pages;

import io.appium.java_client.AppiumDriver;
import tests.CommonPage;
import utils.DataRepository;
import tests.BasePage;

public class AmazonHomePage extends BasePage {

    AppiumDriver driver;
    CommonPage commonPage;
    DataRepository data;

    // Defining all the user actions (Methods) that can be performed in the Facebook home page

    // This method to verify Title
    public void verifyTitle() throws Exception {
        driver.findElement(data.getLocator("homeScreen.logoImg")).isDisplayed();
    }

    // This method is to search for a product from searchBar
    public void searchProduct(String product) throws Exception {
        driver.findElement(data.getLocator("homeScreen.searchBar")).sendKeys(product);
        commonPage.click("homeScreen.searchBarBtn");
    }
}
