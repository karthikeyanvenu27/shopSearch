package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import test.main.utils.DataRepository;

public class AmazonSettingsPage extends BasePage {

    CommonPage commonPage = new CommonPage();
    DataRepository data = new DataRepository();

    // Defining all the user actions (Methods) that can be performed in the Amazon SignIn page

    // This method is to set Email in the email text box
    public void selectSettingsOption() throws Exception {
        commonPage.verticalSwipeByPercentages();
        getDriver().findElement(data.getLocator("hamburgerScreen.settingsOptions")).click();
    }


    // Assert Title is present so Settings title screen is loaded
    public void verifySettingsTitle() throws Exception {
        Assert.assertEquals(getDriver().findElement(data.getLocator("settingsScreen.title")).getText(),
                "Settings", "Settings Page title is not same");
    }

    // Select country dropdown
    public void selectCountryDropDown(String country) throws Exception {
        Select select = new Select(getDriver().findElement(By.name("country")));
        select.selectByVisibleText(country);
        Assert.assertEquals(getDriver().findElement(data.getLocator("settingsScreen.countryLanguageOption")).getText(),
                country, "Selected Country is not same");
        getDriver().findElement(data.getLocator("settingsScreen.doneBtn")).click();
    }
}
