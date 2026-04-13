package pages;

import factory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class BasePage {

    private static final int TIMEOUT = 30;
    private static final int RETRY_COUNT = 3;

    protected WebDriverWait wait;
    public BasePage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
        wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT));
    }

    // =========================
    // WAIT METHODS
    // =========================
    protected WebElement waitForVisibility(WebElement element){
            return wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected WebElement waitForClickability(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // =========================
    // ACTION METHODS
    // =========================
    protected void clickElement(WebElement element) {

        waitForClickability(element).click();

    }

    protected void enterText(WebElement element, String text){

                WebElement el = waitForVisibility(element);
                el.sendKeys(Keys.CONTROL + "a");
                el.sendKeys(Keys.DELETE);
                el.sendKeys(text);
        }

    protected String getElementText(WebElement element) {
        return waitForVisibility(element).getText();
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            return waitForVisibility(element).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }

    }
    // =========================
    // UTIL
    // =========================

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }
}
