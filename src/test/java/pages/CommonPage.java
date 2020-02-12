package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import test.main.utils.DataRepository;
import java.time.Duration;
import static io.appium.java_client.touch.WaitOptions.waitOptions;


public class CommonPage extends BasePage {

    DataRepository repository = new DataRepository();


    public void sendText(String locator, String data) throws Exception {
        try {
            getDriver().findElement(repository.getLocator(locator)).clear();
            getDriver().findElement(repository.getLocator(locator)).sendKeys(data);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error in locating element: " + locator + ".Please verify locator. Below is the errortrace \n\r " + e.getLocalizedMessage());
        }
    }

    public void click(String locator) throws Exception {
        try {
            getDriver().findElement(repository.getLocator(locator)).click();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error in locating element: " + locator + ".Please verify locator. Below is the errortrace \n\r " + e.getLocalizedMessage());
        }
    }

    //Horizontal Swipe by percentages
    public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = getDriver().manage().window().getSize();
        int height = size.getHeight();
        int width = size.getWidth();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int)(width*0.80);
        int endPoint = (int)(width*0.80);

        new TouchAction(driver)
                .press(PointOption.point(startPoint, anchor))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release().perform();
    }

    //Vertical Swipe by percentages
    public void verticalSwipeByPercentages() {
        Dimension dim = getDriver().manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width/2;
        int starty = (int)(height*0.90);
        int endy = (int)(height*0.20);

        new TouchAction(getDriver())
                .press(PointOption.point(x, starty))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x, endy))
                .release().perform();
    }

    public String getText(String option) throws Exception {
         return getDriver().findElement(repository.getLocator(option)).getText();
    }

    public boolean verifyElementFound(String element) throws Exception {
        MobileElement mobileElement = (MobileElement) getDriver().findElements(repository.getLocator(element)).get(0);
        return mobileElement.isDisplayed();
    }
}