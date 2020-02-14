package pages;

import org.testng.Assert;
import test.main.utils.DataRepository;
import test.main.utils.SearchDetailPageDR;
import java.util.concurrent.TimeUnit;

public class AmazonCartPage extends BasePage {

    DataRepository data = new DataRepository();
    CommonPage commonPage = new CommonPage();

    // This method to verify Title
    public void verifyTitle() throws Exception {
        getDriver().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        getDriver().findElement(data.getLocator("cart.title")).isDisplayed();
    }

    // Assert searched Product Details
    public void verifyProductsDetails() throws Exception {
        //verify the Desc/Price Name of the product to compare with the value from Check out Page
        Assert.assertEquals(commonPage.getText("cart.productPrice").replaceAll("\\.0$",""),
                SearchDetailPageDR.getProductPrice(), "Product price is not same");

        Assert.assertEquals(commonPage.getText("cart.productDesc"),
                SearchDetailPageDR.getProductDesc(), "Product description is not same");
    }
}
