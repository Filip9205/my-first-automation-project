package Tests;

import FrameWork.Browser;
import objects.account.CreateAccount;
import objects.navigation_and_asserts.Navigation;
import objects.navigation_and_asserts.Asserts;
import objects.products.CommonUtils;
import objects.products.WomenProducts.WomenProducts;
import objects.shiping.ShippingInfo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Optional;
import java.util.Random;

public class BaseTest {

    //Classes
    private final Browser browser = new Browser();
    protected Navigation navigation;
    protected Asserts asserts;
    protected CommonUtils sharedMethods;
    protected CreateAccount createAccount;
    protected ShippingInfo shippingInfo;
    protected WomenProducts womenProducts;

    //Objects
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    //Variables
    protected Long defaultSleepMillis = 5000L;
    private final String browserName = "Chrome";
    private final String url = "http://www.automationpractice.pl/index.php";

    private final Random random = new Random();
    private final String[] mailServices = {"gmail", "hotmail", "outlook", "yahoo"};

    @BeforeMethod
    public void start(){
        driver = browser.browserName(browserName);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;

        driver.get(url);
        navigation = new Navigation(driver, wait, js);
        asserts = new Asserts(driver, wait);
        sharedMethods = new CommonUtils(wait);
        createAccount = new CreateAccount(wait);
        womenProducts = new WomenProducts(driver, wait);
        shippingInfo = new ShippingInfo(wait, js);

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void end(){
        driver.quit();
    }

    public int getRandomNumber(Optional<Integer> bound) {
        if (bound.isPresent()) {
            return random.nextInt(bound.get());
        } else {
            int defaultIntBound = 1000;
            return random.nextInt(defaultIntBound);
        }
    }

    public String getRandomMailService() {
        return mailServices[getRandomNumber(Optional.of(mailServices.length))];
    }

    public String getRandomEmail() {
        return "email" + getRandomNumber(Optional.empty()) + "@" + getRandomMailService() + ".com";
    }



}
