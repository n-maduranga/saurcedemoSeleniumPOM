package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import factory.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

     @Override
    public void onTestStart(ITestResult result) {
         ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
         testThreadLocal.set(extentTest);
     }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThreadLocal.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testThreadLocal.get().fail(result.getThrowable());

        // capture screenshot
        String path = ScreenshotUtil.captureScreenshot(
                DriverFactory.getDriver(),
                result.getMethod().getMethodName()
        );

        // attach to report
        try {
            testThreadLocal.get().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Override
    public void onTestSkipped(ITestResult result) {
            testThreadLocal.get().skip(result.getThrowable());
        }


        @Override
        public void onFinish(ITestContext context) {
            extent.flush();
        }


}
