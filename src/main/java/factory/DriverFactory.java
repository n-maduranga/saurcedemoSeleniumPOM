package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void initDriver(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu","--no-sandbox","--disable-dev-shm-usage","--window-size=1920,1080");
        tlDriver.set(new ChromeDriver(options));
        getDriver();
    }

    public static WebDriver getDriver(){
        return tlDriver.get();
    }
}
