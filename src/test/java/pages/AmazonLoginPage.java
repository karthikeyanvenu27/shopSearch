package pages;

import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import tests.BasePage;
import utils.DataRepository;
import tests.CommonPage;

public class AmazonLoginPage extends DataRepository{

    AppiumDriver driver;
    CommonPage commonPage;
    DataRepository data;


    // Defining all the user actions (Methods) that can be performed in the Amazon SignIn page

        // This method is to click button skip signin
        public void clickSkipSignInButton() throws Exception {
            System.out.println("getData: "+data.getLocator("welcomeScreen.skipSignInBtn"));
            driver.findElement(data
                    .getLocator("welcomeScreen.skipSignInBtn"));
        }

        // Assert Title is check if SignIn screen is loaded
        public void verifyTitle() throws Exception {
            System.out.println("getLocator: $#@#$%"+ data.getLocator("welcomeScreen.skipSignInBtn"));
            Assert.assertEquals(driver.findElement(data.getLocator("welcomeScreen.welcomeTitle")).getText(),
                    "Sign In Page", "Login title is not Present");
        }

}
