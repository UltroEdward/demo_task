package part1;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.common.DiscountModalPage;
import pages.dashboard.DashBoardPage;
import utils.DriverFactory;


public abstract class BaseTest {

    protected static final String baseUrl = "https://stadium:goods2018!@stage.stadiumgoods.cloud";
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = DriverFactory.getDriver();
        LOG.info("Selenium initialization done");
        driver.get(baseUrl); //According to requirements, all tests must starts from this point
        new DashBoardPage(driver); // make sure dashboard loaded
        new DiscountModalPage(driver).close(15); //wait for modal page and close, if not loaded will continue
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.releaseDriver();
        LOG.info("Selenium shut-down finished");
    }
}
