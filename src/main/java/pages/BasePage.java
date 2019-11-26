package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitLoaded(WebElement el, int timeout) {
        if (!waitForVisible(el, timeout)) {
            throw new RuntimeException("Page not loaded");
        }
    }

    public boolean waitForVisible(WebElement el, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(el));
            return true;
        } catch (WebDriverException ex) {
            return false;
        }
    }

    public boolean isOpened() {
        throw new RuntimeException("Not implemented");
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
