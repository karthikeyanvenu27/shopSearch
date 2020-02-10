package test.main;

import org.testng.annotations.Test;
import pages.AmazonCheckoutPage;
import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonSearchDetailPage;
import tests.BasePage;

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

    /*@Test(priority = 1)
    public void homePage() {
        try {
            homePage.verifyTitle();
            homePage.searchProduct("65 inch TV");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void searchProduct() {
        try {
            search.verifyTitle();
            search.selectProduct();
            search.getSearchedProductsDetails();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void checkout() {
        try {
            checkout.verifyTitle();
            checkout.verifyProductsDetails();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }*/
}
