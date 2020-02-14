package test.main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.BasePage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * A listener class that gets invoked before and after the all tests.
 *
 * @see <a href="https://static.javadoc.io/org.testng/testng/6.11/org/testng/ITestListener.html">ITestListener</a>
 */
public class TestListener implements ITestListener {


  protected static ExtentReports reports;
  protected static ExtentTest test;
//  final  static Logger log =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
Logger log =  Logger.getLogger(String.valueOf(getClass().getName()));

  @Override
  public void onTestStart(ITestResult iTestResult) {
    System.out.println(iTestResult.getName()+" test started ");
    Reporter.startTest(iTestResult.getMethod().getMethodName());
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {
    System.out.println("Test Success : "+iTestResult.getName());
    Reporter.getTest().log(Status.PASS, "Test passed");
  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
//    System.out.println("Test failed : "+iTestResult.getName());
//    Reporter.getTest().log(Status.FAIL, "Test failed");

    log.info("*** Test execution " + iTestResult.getMethod().getMethodName() + " failed...");
    log.info((iTestResult.getMethod().getMethodName() + " failed!"));

//    ITestContext context = iTestResult.getTestContext();
    Object context = iTestResult.getInstance();
    WebDriver driver = ((BasePage) context).getDriver();

    String targetLocation = null;

    String testClassName = iTestResult.getInstanceName().trim();
    String timeStamp = String.valueOf(System.currentTimeMillis()); // get timestamp
    String testMethodName = iTestResult.getName().toString().trim();
    String screenShotName = testMethodName + timeStamp + ".png";
    String fileSeperator = System.getProperty("file.separator");
    String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator
            + "screenshots";
    log.info("Screen shots reports path - " + reportsPath);
    try {
      File file = new File(reportsPath + fileSeperator + testClassName); // Set
      // screenshots
      // folder
      if (!file.exists()) {
        if (file.mkdirs()) {
          log.info("Directory: " + file.getAbsolutePath() + " is created!");
        } else {
          log.info("Failed to create directory: " + file.getAbsolutePath());
        }
      }

      File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      targetLocation = reportsPath + fileSeperator + testClassName + fileSeperator + screenShotName;// define
      // location
      File targetFile = new File(targetLocation);
      log.info("Screen shot file location - " + screenshotFile.getAbsolutePath());
      log.info("Target File location - " + targetFile.getAbsolutePath());
      FileHandler.copy(screenshotFile, targetFile);

    } catch (FileNotFoundException e) {
      log.info("File not found exception occurred while taking screenshot " + e.getMessage());
    } catch (Exception e) {
      log.info("An exception occurred while taking screenshot " + e.getCause());
    }

    // attach screenshots to report
    try {
      Reporter.getTest().fail("Screenshot",
              MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
    } catch (IOException e) {
      log.info("An exception occured while taking screenshot " + e.getCause());
    }
    Reporter.getTest().log(Status.FAIL, "Test Failed");

  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {
    System.out.println("Test skipped : "+iTestResult.getName());
    Reporter.getTest().log(Status.SKIP, "Test skipped");
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    System.out.println("Test failed with %"+iTestResult.getMethod().getMethodName());
  }

  @Override
  public void onStart(ITestContext iTestContext) {
    System.out.println("Test "+iTestContext.getName()+ "started ");
  }

  @Override
  public void onFinish(ITestContext iTestContext) {
    System.out.println("Test "+iTestContext.getName()+ " ended ");
    Reporter.endTest();
    ReportManager.getInstance().flush();
  }
}
