package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {

    // Overview page specific methods can be added here
    @FindBy(id="finish")
    private WebElement finishBtn;

    public CompletePage finishCheckout() {
        clickElement(finishBtn);
        return new CompletePage();
    }
}
