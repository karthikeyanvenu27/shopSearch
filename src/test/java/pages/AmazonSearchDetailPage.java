package pages;

import org.openqa.selenium.WebElement;
import test.main.utils.DataRepository;
import test.main.utils.SearchDetailPageDR;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AmazonSearchDetailPage extends BasePage {

    DataRepository data = new DataRepository();
    CommonPage commonPage = new CommonPage();

    public void selectProduct() throws Exception {
        commonPage.verticalSwipeByPercentages( );
        commonPage.click("prp.product");
    }

    // This method to verify Title
    public void verifyTitle() throws Exception {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().findElement(data.getLocator("prp.title")).isDisplayed();
    }

    // gets searched Product Detail
    public void getSearchedProductsDetails() throws Exception {

        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Store the Desc/Price Name of the product to compare with the value from Check out Page

        getDriver().findElement(data.getLocator("prp.title")).isDisplayed();

        commonPage.verticalSwipeByPercentages();

        WebElement prdPrice = getDriver().findElement(data.getLocator("pdp.price"));
        SearchDetailPageDR.setProductPrice(prdPrice.getText());
        System.out.println("prdDesc.prdPrice()"+prdPrice.getText());
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

//        commonPage.verticalSwipeByPercentages();
//        getDriver().findElement(data.getLocator("pdp.addToCartBtn")).click();

        getDriver().findElement(data.getLocator("pdp.cart")).click();
    }
}
