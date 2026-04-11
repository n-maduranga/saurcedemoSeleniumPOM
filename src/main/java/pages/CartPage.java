package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id="checkout")
    private WebElement checkoutBtn;

    public Checkout proceedToCheckout() {
        clickElement(checkoutBtn);
        return new Checkout();
    }
}
