package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void initDriver(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito","--disable-gpu","--no-sandbox","--disable-dev-shm-usage",
                "--disable-notifications","--start-maximized","--disable-features=SafeBrowsingPasswordCheck");
        tlDriver.set(new ChromeDriver(options));
        getDriver();
    }

    public static WebDriver getDriver(){
        return tlDriver.get();
    }
}
