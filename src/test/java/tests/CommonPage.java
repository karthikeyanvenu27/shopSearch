package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.main.utils.DataRepository;
import java.time.Duration;
import static io.appium.java_client.touch.WaitOptions.waitOptions;


public class CommonPage extends BasePage {

    AppiumDriver<WebElement> driver;
    DataRepository repository;


    public void sendText(String locator, String data) throws Exception {
        try {
            driver.findElement(repository.getLocator(locator)).clear();
            driver.findElement(repository.getLocator(locator)).sendKeys(data);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error in locating element: " + locator + ".Please verify locator. Below is the errortrace \n\r " + e.getLocalizedMessage());
        }
    }

    public void click(String locator) throws Exception {
        try {
            driver.findElement(repository.getLocator(locator)).click();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error in locating element: " + locator + ".Please verify locator. Below is the errortrace \n\r " + e.getLocalizedMessage());
        }
    }

    //Horizontal Swipe by percentages
    public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);

        new TouchAction(driver)
                .press(PointOption.point(startPoint, anchor))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release().perform();
    }

    //Vertical Swipe by percentages
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);

        new TouchAction(driver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
    }

    public String getText(String option) throws Exception {
         return driver.findElement(repository.getLocator(option)).getText();
    }

    public boolean verifyElementFound(String element) throws Exception {
        MobileElement mobileElement = (MobileElement) driver.findElements(repository.getLocator(element)).get(0);
        return mobileElement.isDisplayed();
    }
}