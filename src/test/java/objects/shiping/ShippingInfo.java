package objects.shiping;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShippingInfo {
    //Objects
    private final WebDriverWait wait;
    private final JavascriptExecutor js;
    //Variables
    private final By customerAddress = By.id("address1");
    private final By customerCity = By.id("city");
    private final By customerState = By.id("id_state");
    private final By customerZip = By.id("postcode");
    private final By customerCountry = By.id("id_country");
    private final By customerHomePhone = By.id("phone");
    private final By customerMobilePhone = By.id("phone_mobile");
    private final By saveCustomerInfo = By.id("alias");
    private final By agreeToTerms = By.id("cgv");
    private final By payMethod = By.xpath("//*[@id='HOOK_PAYMENT']/div");
    //Methods
    public ShippingInfo(WebDriverWait wait, JavascriptExecutor js){
        this.wait = wait;
        this.js = js;
    }

    public void enterAddress(String address){
        js.executeScript("window.scrollBy(0, 200)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerAddress)).sendKeys(address);
    }

    public void enterCity(String city){
        js.executeScript("window.scrollBy(0, 500)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerCity)).sendKeys(city);
    }

    private void inputLogic(By element, String choice) {
        WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(element));
        element1.sendKeys(choice);
    }

    public void enterState(String state){
        js.executeScript("window.scrollBy(0, 500)");
        inputLogic(customerState, state);
    }

    public void enterZip(String zip){
        js.executeScript("window.scrollBy(0, 700)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerZip)).sendKeys(zip);
    }

    public void enterCountry(String country){
        js.executeScript("window.scrollBy(0, 700)");
        inputLogic(customerCountry, country);
    }

    public void enterHomePhone(String homePhone){
        js.executeScript("window.scrollBy(0, 1000)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerHomePhone)).sendKeys(homePhone);
    }

    public void enterMobilePhone(String mobilePhone){
        js.executeScript("window.scrollBy(0, 1000)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerMobilePhone)).sendKeys(mobilePhone);
    }

    public void enterAliasToSaveInfo(String alias){
        js.executeScript("window.scrollBy(0, 1100)");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(saveCustomerInfo));
        element.sendKeys(Keys.CONTROL + "A");
        element.sendKeys(Keys.ESCAPE);
        element.sendKeys(alias);
    }

    public void checkButtonToAgreeOnTerms(){
        wait.until(ExpectedConditions.presenceOfElementLocated(agreeToTerms)).click();
    }

    public void selectPaymentMethod(String enterPaymentMethod){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(payMethod));
        switch (enterPaymentMethod.toLowerCase()){
            case "bank wire":
                elements.get(0).click();
                break;
            case "check":
                elements.get(1).click();
                break;
            default:
                System.out.println("Unsupported payment method "+enterPaymentMethod);
        }
    }
}
