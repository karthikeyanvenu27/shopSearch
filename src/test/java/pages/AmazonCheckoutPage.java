package pages;

import org.testng.Assert;
import test.main.utils.DataRepository;
import test.main.utils.SearchDetailPageDR;

import java.util.concurrent.TimeUnit;

public class AmazonCheckoutPage extends BasePage {

    DataRepository data = new DataRepository();
    CommonPage commonPage = new CommonPage();

    // This method to verify Title
    public void verifyTitle() throws Exception {
        getDriver().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        getDriver().findElement(data.getLocator("checkout.title")).isDisplayed();
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
