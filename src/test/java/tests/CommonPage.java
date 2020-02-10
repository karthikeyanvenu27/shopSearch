package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DataRepository;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;

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

//    Tap to an element for 250 milliseconds
    public void tapByElement (AndroidElement androidElement) {
        new TouchAction(driver)
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(androidElement)))
                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
    }

    //Tap by coordinates
    public void tapByCoordinates (int x,  int y) {
        new TouchAction(driver)
                .tap(PointOption.point(x,y))
                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
    }

    //Press by coordinates
    public void pressByCoordinates (int x, int y, long seconds) {
        new TouchAction(driver)
                .press(PointOption.point(x,y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
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

    //Swipe by elements
    public void swipeByElements (AndroidElement startElement, AndroidElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction(driver)
                .press(PointOption.point(startX,startY))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    //Multitouch action by using an android element
    public void multiTouchByElement (AndroidElement androidElement) {
        TouchAction press = new TouchAction(driver)
                .press(ElementOption.element(androidElement))
                .waitAction(waitOptions(ofSeconds(1)))
                .release();

        new MultiTouchAction(driver)
                .add(press)
                .perform();
    }

    public String getText(String option) throws Exception {
         return driver.findElement(repository.getLocator(option)).getText();
    }

    public boolean verifyElementFound(String element) throws Exception {
        MobileElement mobileElement = (MobileElement) driver.findElements(repository.getLocator(element)).get(0);
        return mobileElement.isDisplayed();
    }
}