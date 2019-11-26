package pages.auth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "pass")
    private WebElement passwordInput;
    @FindBy(id = "send2")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void submit(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        submitButton.click();
    }
}
