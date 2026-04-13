package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id="first-name")
    private WebElement firstNameInput;

    @FindBy(id="last-name")
    private WebElement lastNameInput;

    @FindBy(id="postal-code")
    private WebElement postalCodeInput;

    @FindBy(id="continue")
    private WebElement continueBtn;

    public OverviewPage enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        enterText(firstNameInput, firstName);
        enterText(lastNameInput, lastName);
        enterText(postalCodeInput, postalCode);
        clickElement(continueBtn);
        return new OverviewPage();
    }

}
