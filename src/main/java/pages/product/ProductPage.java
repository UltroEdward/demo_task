package pages.product;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'ProductListingUtilityBar')]//select")
    private WebElement filterSelect;
    @FindBy(xpath = "//*[@id='header-nav']//li[contains(@class, 'level0 ')]")
    private List<WebElement> topCategories;
    @FindBy(xpath = "//div[contains(@class, 'ProductSummary')][contains(text(), '$')]")
    private List<WebElement> priceLabels;
    @FindBy(id = "2-toggle")
    private WebElement filterButton;


    public ProductPage(WebDriver driver) {
        super(driver);
        //waitLoaded(filterButton, 15);
        wait(10); //  DOM was changes several times with elements, so put sleep here. As soon as DOM will be stable, uncomment and fix waitFloLoad
    }

    public void setFilter(FilterBy filter) {
        filterSelect.sendKeys(filter.getText());
        //TODO: refactor, remove sleep
        wait(5);
    }

    public List<Float> getVisiblePrices() {
        return priceLabels.stream().
                map(priceLabel -> priceLabel.getText().replace("$", "")).
                map(Float::parseFloat).collect(Collectors.toList());
    }
}
