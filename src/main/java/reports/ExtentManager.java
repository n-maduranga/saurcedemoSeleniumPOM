package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports .*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utils.DateUtil;

public class ExtentManager {

       private static ExtentReports extent;

        public static ExtentReports getInstance() {

            if (extent == null) {

                String path = "reports/extent-report-" + DateUtil.getTimestamp() + ".html";

                ExtentSparkReporter reporter = new ExtentSparkReporter(path);
                reporter.config().setReportName("Automation Test Results");
                reporter.config().setDocumentTitle("Test Execution Report");

                extent = new ExtentReports();
                extent.attachReporter(reporter);

                // system info
                extent.setSystemInfo("OS", System.getProperty("os.name"));
                extent.setSystemInfo("Java Version", System.getProperty("java.version"));
                extent.setSystemInfo("Browser", "Chrome");
            }

            return extent;
        }
    }