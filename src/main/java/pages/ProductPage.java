package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

     // Product page specific methods can be added here
    @FindBy(css =".shopping_cart_container")
    private WebElement cartIcon;

    public void addItemToCart(String itemName){

        String formattedItemName = itemName.toLowerCase().
                replace(" ", "-");

        String dynamicID = "add-to-cart-"+formattedItemName;
        By addToCartBtn = By.id(dynamicID);
        WebDriverWait wait = new WebDriverWait(
                DriverFactory.getDriver(), Duration.ofSeconds(10)
        );

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(By.id(dynamicID))
        );
        clickElement(button);
    }

    public void addMultipleItemsToCart(String... itemNames){
        for (String itemName : itemNames) {
            addItemToCart(itemName);
        }
    }

     public CartPage goToCart(){
         clickElement(cartIcon);
         return new CartPage();
     }
}
