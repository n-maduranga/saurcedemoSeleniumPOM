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
//        int attempts = 0;
//        while (attempts<RETRY_COUNT) {
//            try {
//                waitForClickability(element).click();
//                break;
//            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
//                attempts++;
//                sleep(500);
//            }
//        }
//            // JS fallback ONLY after all retries fail
//            try {
//                ((JavascriptExecutor) DriverFactory.getDriver())
//                        .executeScript("arguments[0].click();", element);
//            } catch (Exception ex) {
//                throw new RuntimeException("Failed to click element after retries", ex);
//            }

    }

    protected void enterText(WebElement element, String text){
        int attempts = 0;
        while (attempts<RETRY_COUNT){
            try {
                WebElement el = waitForVisibility(element);
                el.sendKeys(Keys.CONTROL + "a");
                el.sendKeys(Keys.DELETE);
                el.sendKeys(text);
                return; //exit method on success
            }catch (StaleElementReferenceException e){
                attempts++;
                sleep(500);
            }
        }
        throw new RuntimeException("Failed to type after retries");
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
