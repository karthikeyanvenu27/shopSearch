package test.main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * A listener class that gets invoked before and after the all tests.
 *
 * @see <a href="https://static.javadoc.io/org.testng/testng/6.11/org/testng/ITestListener.html">ITestListener</a>
 */
public class TestListener implements ITestListener {

  protected static AppiumDriver driver;
  protected static ExtentReports reports;
  protected static ExtentTest test;

  @Override
  public void onTestStart(ITestResult iTestResult) {
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {

  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {

  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
  }

  @Override
  public void onStart(ITestContext iTestContext) {
    System.out.println("on start");
    reports = new ExtentReports();
  }

  @Override
  public void onFinish(ITestContext iTestContext) {
    System.out.println("on finish");
    driver.close();
    reports.attachReporter();
    reports.flush();
  }
}
