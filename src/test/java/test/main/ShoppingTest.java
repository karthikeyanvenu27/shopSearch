package test.main;

import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonSearchDetailPage;
import tests.BasePage;

public class ShoppingTest extends BasePage {

     AmazonLoginPage loginPage= new AmazonLoginPage();
     AmazonHomePage homePage = new AmazonHomePage();
     AmazonSearchDetailPage search = new AmazonSearchDetailPage();

    @Test()
    public void skipLogin() {
        try {
            loginPage.verifyTitle();
            loginPage.clickSkipSignInButton();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
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
}
