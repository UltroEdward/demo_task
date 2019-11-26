package part1.goods;

import com.google.common.collect.Ordering;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboard.DashBoardPage;
import pages.product.FilterBy;
import pages.product.ProductPage;
import part1.BaseTest;

import java.util.List;

public class CategoryTest extends BaseTest {

    @Test
    public void productSortingTest() {
        DashBoardPage dashPage = new DashBoardPage(driver);
        dashPage.selectRandomCategory();

        ProductPage productPage = new ProductPage(driver);
        productPage.setFilter(FilterBy.PRICE_FROM_LOW);
        List<Float> prices = productPage.getVisiblePrices();

        Assert.assertTrue(Ordering.<Float>natural().isOrdered(prices));
    }
}
