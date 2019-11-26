package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DiscountModalPage extends BasePage {

    @FindBy(xpath = "//*[@class='subscribe-close-header']")
    private WebElement closeButton;

    public DiscountModalPage(WebDriver driver) {
        super(driver);
    }

    public void close() {
        close(15);
    }

    public void close(int waitTimeOut) {
        if (waitForVisible(closeButton, waitTimeOut)) {
            closeButton.click();
        }
    }
}
