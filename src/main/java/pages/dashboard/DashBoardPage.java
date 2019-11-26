package pages.dashboard;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;
import java.util.Random;

public class DashBoardPage extends BasePage {

    @FindBy(xpath = "//*[@id='header-nav']//li[contains(@class, 'level0')][@data-category-name]")
    private List<WebElement> topCategories;
    @FindBy(xpath = "//*[contains(@id, 'sumoheavy_flexslider')]")
    private WebElement banner;

    public DashBoardPage(WebDriver driver) {
        super(driver);
        waitLoaded(banner, 15);
    }

    public void selectRandomCategory() {
        topCategories.get(new Random().nextInt(topCategories.size())).click();
    }
}
