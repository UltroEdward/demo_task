package demo.utils;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(getLocalDriver(DriverManagerType.CHROME));
        }
        return driver.get();
    }

    public static void releaseDriver() {
        WebDriver driverToDestroy = driver.get();
        driverToDestroy.quit();
        driver.remove();
    }

    private static WebDriver getLocalDriver(DriverManagerType driver) {
        WebDriverManager.getInstance(CHROME).setup();
        return new ChromeDriver();
    }

}
