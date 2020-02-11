package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import tests.CommonPage;
import test.main.utils.DataRepository;
import tests.BasePage;

public class AmazonSettingsPage extends BasePage {

    AppiumDriver driver;
    CommonPage commonPage;
    DataRepository data;

    // Defining all the user actions (Methods) that can be performed in the Amazon SignIn page

    // This method is to set Email in the email text box
    public void selectSettingsOption() throws Exception {
        commonPage.verticalSwipeByPercentages(10,20,40);
        driver.findElement(data.getLocator("hamburgerScreen.settingsOptions")).click();
    }


    // Assert Title is present so Settings title screen is loaded
    public void verifySettingsTitle() throws Exception {
        Assert.assertEquals(driver.findElement(data.getLocator("settingsScreen.title")).getText(),
                "Settings", "Settings Page title is not same");
    }

    // Select country dropdown
    public void selectCountryDropDown(String country) throws Exception {
        Select select = new Select(driver.findElement(By.name("country")));
        select.selectByVisibleText(country);
        Assert.assertEquals(driver.findElement(data.getLocator("settingsScreen.countryLanguageOption")).getText(),
                country, "Selected Country is not same");
        driver.findElement(data.getLocator("settingsScreen.doneBtn")).click();
    }
}
