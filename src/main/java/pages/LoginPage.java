package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id= "password")
    private WebElement passwordField;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    public ProductPage login(String username, String password) {
        clickElement(usernameField);
        enterText(usernameField, username);
        clickElement(passwordField);
        enterText(passwordField, password);
        clickElement(loginButton);
        return new ProductPage();
    }

}
