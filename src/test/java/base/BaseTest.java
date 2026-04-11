package base;

import factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        ConfigReader.loadProperties("src/test/resources/config.properties");
        DriverFactory.initDriver();
        launchApp();
    }

    public void launchApp() {
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }
}
