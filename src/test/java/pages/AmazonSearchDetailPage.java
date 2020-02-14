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

        WebElement prdDesc = getDriver().findElement(data.getLocator("pdp.Description"));
        System.out.println("prdDesc.prdDesc()"+prdDesc.getText());
        SearchDetailPageDR.setProductPrice(prdDesc.getText());

        getDriver().findElement(data.getLocator("prp.title")).isDisplayed();

        if(!getDriver().findElement(data.getLocator("prp.title")).isDisplayed()){
            commonPage.verticalSwipeByPercentages();
        }

        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement prdPrice = getDriver().findElement(data.getLocator("pdp.price"));
        SearchDetailPageDR.setProductPrice(prdPrice.getText().replaceAll("([a-z])","").trim());

        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        commonPage.verticalSwipeByPercentages();

        getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        commonPage.click("pdp.addToCartBtn");

        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        getDriver().findElement(data.getLocator("pdp.cart")).click();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
