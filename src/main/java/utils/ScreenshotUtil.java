package utils;

import factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName){

        // Folder inside reports
        String folderPath = "reports/screenshots/";
        new File(folderPath).mkdirs();

        String fileName = testName + "_" + System.currentTimeMillis() + ".png";
        String fullPath = folderPath + fileName;

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(fullPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
              return "screenshots/" + fileName;
    }
}
