package part1.auth;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.auth.LoginPage;
import pages.welcome.WelcomePage;
import part1.BaseTest;
import utils.ExcelUtils;

public class LoginTest extends BaseTest {

    @DataProvider
    public static Object[][] credentials() {
        return ExcelUtils.getTableArray("src/test/resources/test_data.xlsx", "Sheet1");
    }

    @BeforeMethod
    public void openApp() {
        //TODO: add properties
        driver.get(baseUrl + "/customer/account/login/");
    }

    @Test(dataProvider = "credentials")
    public void loginTest(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.submit(username, password);

        WelcomePage welcomePage = new WelcomePage(driver);
        Assert.assertTrue(welcomePage.isOpened());
    }

}
