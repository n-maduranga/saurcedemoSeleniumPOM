package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id="checkout")
    private WebElement checkoutBtn;

    public CheckoutPage proceedToCheckout() {
        clickElement(checkoutBtn);
        return new CheckoutPage();
    }
}
