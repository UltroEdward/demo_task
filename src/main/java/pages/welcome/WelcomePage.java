package pages.welcome;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class WelcomePage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'my-account')]/*[contains(@class, 'dashboard')]")
    private WebElement myAccountWrapper;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return waitForVisible(myAccountWrapper, 15);
    }
}
