package test.main;

import org.testng.annotations.Test;
import pages.*;

public class ShoppingTest extends BasePage {

     AmazonLoginPage loginPage= new AmazonLoginPage();
     AmazonHomePage homePage = new AmazonHomePage();
     AmazonSearchDetailPage search = new AmazonSearchDetailPage();
     AmazonCheckoutPage checkout = new AmazonCheckoutPage();

    //test() method searches a product and verifies product name /desc/price in pdp page and checkout page
    @Test()
    public void test() {
        try {
            loginPage.verifyTitle();
            loginPage.clickSkipSignInButton();
            homePage.verifyTitle();
            homePage.searchProduct("65 inch TV");
            search.verifyTitle();
            search.selectProduct();
            search.getSearchedProductsDetails();
            checkout.verifyTitle();
            checkout.verifyProductsDetails();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
