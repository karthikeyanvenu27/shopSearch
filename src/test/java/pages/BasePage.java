package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Karthikeyan:
 */
public class BasePage {

    public static AppiumDriver<WebElement> driver;

    public AppiumDriver<WebElement> getDriver() {
        return driver;
    }

    @BeforeTest
    public void setUp() {

        try {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName","Moto Nexus");
            capabilities.setCapability("platformVersion", "9");
            capabilities.setCapability("udid", "de443d8");
            capabilities.setCapability("autoWebview", "false");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1000);
            capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
            capabilities.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");

//            capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping/com.amazon.mShop.splashscreen.StartupActivity");
//            capabilities.setCapability("appActivity", "com.amazon.mShop.home.web.MShopWebGatewayActivity");

            URL url = new URL("http://0.0.0.0:4723/wd/hub");

            driver = new AndroidDriver<>(url, capabilities);
            System.out.println("App launched");
            driver.launchApp();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        }catch (Exception e) {
                e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
//        driver.close();
        driver.quit();
    }
}
