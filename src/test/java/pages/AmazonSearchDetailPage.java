package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import tests.CommonPage;
import utils.DataRepository;
import utils.SearchDetailPageDR;

public class AmazonSearchDetailPage {
    AppiumDriver driver;
    CommonPage commonPage;
    DataRepository data;

    public void selectProduct() throws Exception {
        commonPage.click("homeScreen.searchBarBtn");
    }

    // This method to verify Title
    public void verifyTitle() throws Exception {
        driver.findElement(data.getLocator("pdp.title")).isDisplayed();
    }

    // gets searched Product Detail
    public void getSearchedProductsDetails() throws Exception {

        // First search the product to select and


        //Store the Desc/Price Name of the product to compare with the value from Check out Page
        WebElement prdDesc = driver.findElement(data.getLocator("prp.product"));
        SearchDetailPageDR.setProductDesc(prdDesc.getText());

        WebElement prdPrice = driver.findElement(data.getLocator("prp.product"));
        SearchDetailPageDR.setProductPrice(prdPrice.getText());

        WebElement prdName = driver.findElement(data.getLocator("prp.product"));
        SearchDetailPageDR.setProductName(prdName.getText());

    }
}
