package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tests.CommonPage;
import utils.DataRepository;
import utils.SearchDetailPageDR;

public class AmazonCheckoutPage {
    AppiumDriver driver;
    CommonPage commonPage;
    DataRepository data;

    // This method to verify Title
    public void verifyTitle() throws Exception {
        driver.findElement(data.getLocator("checkout.title")).isDisplayed();
    }

    // gets searched Product Detail
    public void verifyProductsDetails() throws Exception {
        //verify the Desc/Price Name of the product to compare with the value from Check out Page

        Assert.assertEquals(commonPage.getText("checkout.productPrice"),
                SearchDetailPageDR.getProductPrice(), "Product price is not same");

        Assert.assertEquals(commonPage.getText("checkout.productDesc"),
                SearchDetailPageDR.getProductDesc(), "Product description is not same");

        Assert.assertEquals(commonPage.getText("checkout.productName"),
                SearchDetailPageDR.getProductName(), "Product name is not same");
    }
}
