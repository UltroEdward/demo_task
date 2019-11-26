public abstract class BaseUITest {

    private static final Logger LOG = LoggerFactory.getLogger(WebBaseElement.class);

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = DriverFactory.getDriver();
        LOG.info("Selenium initialization done");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.releaseDriver();
        LOG.info("Selenium shut-down finished");
    }
}
