package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import tests.CommonPage;
import utils.DataRepository;
import utils.SearchDetailPageDR;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

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
            while (!commonPage.verifyElementFound("prp.product")){
                commonPage.verticalSwipeByPercentages( 200,300,20);
                Assert.assertTrue(commonPage.verifyElementFound("prp.product"),
                        "Product Not Found");
            }
        commonPage.click("prp.product");

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

        //Store the Desc/Price Name of the product to compare with the value from Check out Page
        WebElement prdDesc = driver.findElement(data.getLocator("prp.desc"));
        SearchDetailPageDR.setProductDesc(prdDesc.getText());

        WebElement prdPrice = driver.findElement(data.getLocator("prp.price"));
        SearchDetailPageDR.setProductPrice(prdPrice.getText());

        WebElement prdName = driver.findElement(data.getLocator("prp.name"));
        SearchDetailPageDR.setProductName(prdName.getText());

    }
}
