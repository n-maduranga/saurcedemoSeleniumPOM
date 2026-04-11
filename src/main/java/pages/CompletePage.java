package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends BasePage {

    @FindBy(id = "back-to-products")
    private WebElement backHomeBtn;

    @FindBy(className = "complete-header")
    private WebElement completeMessage;

    public String getCompleteMessage() {
        return completeMessage.getText();
    }


}
