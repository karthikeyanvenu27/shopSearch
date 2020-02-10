package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DataRepository;

import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * This is a Base Page that will be extended by all pages.
 *
 * @author Karthikeyan:
 */
public class BasePage {

    public AppiumDriver<WebElement> driver;
    DataRepository mapProp;
//    Properties properties;
//public BasePage (AppiumDriver driver){
//    this.driver = driver;
////    wait = new WebDriverWait(driver,15);
//}

    @BeforeTest
    public void setUp() {

        try {

//            mapProp = new DataRepository(System.getProperty("user.dir")+"/src/test/resources/objectRepository/android/androidObjects.properties");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName","Moto Nexus");
            capabilities.setCapability("platformVersion", "9");
            capabilities.setCapability("udid", "ZX1G523V28");
            capabilities.setCapability("autoWebview", "false");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1000);
//            capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
//            capabilities.setCapability("appActivity", "com.amazon.mShop.sso.SigninPromptActivity");

//            capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
//            capabilities.setCapability("appActivity", "com.amazon.mShop.home.web.MShopWebGatewayActivity");

            capabilities.setCapability("appPackage", "com.rak");
            capabilities.setCapability("appActivity", "com.rak.MainActivity");
//            capabilities.setCapability("noReset", "true");
//            capabilities.setCapability("fullReset", "false");
//             capabilities.setCapability("app", "/Users/ka241741/Documents/Automation/AmazonShop/src/test/resources/apps/shopping.apk");
//            com.amazon.mShop.android.shopping :: com.amazon.mShop.sso.SigninPromptActivity
            URL url = new URL("http://0.0.0.0:4723/wd/hub");

            driver = new AndroidDriver<>(url, capabilities);
            System.out.println("App launched");
            driver.launchApp();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Get object map file


//            datafile = new DataRepository(  System.getProperty("user.dir")+"/src/test/resources/objectRepository/android/androidObjects.properties");
//            datafile = new DataRepository(  "androidObject.properties");
        }catch (Exception e) {
                e.printStackTrace();
        }
    }

//    @Test
//    public void test() {
//        driver.launchApp();
//        System.out.println("Hello");
//    }

    @AfterTest
    public void tearDown() {
//        driver.close();
        driver.quit();
    }
}
