package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import test.main.utils.DataRepository;

public class AmazonHomePage  extends BasePage {

    DataRepository data = new DataRepository();
    CommonPage commonPage = new CommonPage();
    Actions action;

    // Defining all the user actions (Methods) that can be performed in the home page

    // This method to verify Title
    public void verifyTitle() throws Exception {
        getDriver().findElement(data.getLocator("homeScreen.logoImg")).isDisplayed();
    }

    // This method is to search for a product from searchBar
    public void searchProduct(String product) throws Exception {
        getDriver().findElement(data.getLocator("homeScreen.searchBar")).sendKeys(product);
        action =new Actions(getDriver());
        action.sendKeys(Keys.ENTER).perform();
    }
}
