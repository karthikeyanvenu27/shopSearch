package pages;

import test.main.utils.DataRepository;

public class AmazonLoginPage extends BasePage {


    DataRepository data = new DataRepository();

    // Defining all the user actions (Methods) that can be performed in the Amazon SignIn page

        // This method is to click button skip signin
        public void clickSkipSignInButton() throws Exception {
            System.out.println("getData: "+data.getLocator("welcomeScreen.continueBtn"));
            Thread.sleep(1000);
            getDriver().findElement(data
                    .getLocator("welcomeScreen.continueBtn")).click();
        }

        // Assert Title is check if SignIn screen is loaded
        public void verifyTitle() throws Exception {
            System.out.println("getLocator: $#@#$%"+ data.getLocator("welcomeScreen.welcomeTitle"));
        }
}
