package objects.navigation_and_asserts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Asserts {

    //Objects
    private final WebDriverWait wait;

    //Variables
    private final By shopSection = By.xpath("//*[@id='center_column']/h1/span[1]");
    private final By productName = By.xpath("//p[@class='product-name']");
    private final By productSizeColor = By.xpath("//*[@class='cart_description']/small/a");
    private final By totalPriceOfFirstProduct = By.xpath("//*[@class='cart_item first_item address_0 odd']/td[7]");
    private final By totalPriceOfSecondProduct = By.xpath("//*[@class='cart_item last_item address_0 even']/td[7]");
    private final By totalPriceOfProductsInCart = By.id("total_price");
    private final By alertMessage = By.xpath("//*[@id='center_column']/p[1]");
    private final By customerAccount = By.className("account");
    private final By textForPayment = By.xpath("//*[@class='cheque-indent']");
    private final By textForFinalPrice = By.xpath("//*[@class='box cheque-box']/p[2]");
    private final By successfulOrder = By.xpath("//*[@class='alert alert-success']");
    private final By customerDeliveryAddress = By.xpath("//*[@id='address_delivery']/li");
    //Methods
    public Asserts(WebDriver driver, WebDriverWait wait){
        this.wait = wait;
    }
    public String assertShopSection(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shopSection)).getText();
    }

    public String assertDescriptionForFirstProduct(){
        List<WebElement> elements1 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productName));
        List<WebElement> elements2 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productSizeColor));

        return elements1.get(1).getText()+elements2.get(0).getText();
    }

    public String assertDescriptionForSecondProduct(){
        List<WebElement> elements1 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productName));
        List<WebElement> elements2 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productSizeColor));

        return elements1.get(2).getText()+elements2.get(1).getText();
    }

    private int productPrice(String productName){
       return switch (productName.toLowerCase()){
            case "faded short sleeve t-shirts" -> 17;
            case "blouse" -> 27;
            case "printed dress" -> 26;
            case "evening printed dress" -> 51;
            case "printed summer dress" -> 29;
            case "printed summer dress1" -> 31;
            case "printed chiffon dress" -> 16;
            default -> 0;
        };

    }

    public String assertSuccessfullyCreatedAccount(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessage))
                .getText();
    }

    public String assertCustomerAccount(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(customerAccount))
                .getText();
    }

    public String assertTotalPriceOfFirstProduct(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceOfFirstProduct))
                .getText();
    }

    public int totalPriceOfFirstProduct(String productName ,String quantity){
        int quantityEl = Integer.parseInt(quantity);
        return (productPrice(productName) * quantityEl);
    }

    public String assertTotalPriceOfSecondProduct(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceOfSecondProduct))
                .getText();
    }

    public int totalPriceOfSecondProduct(String productName ,String quantity){
        int quantityEl = Integer.parseInt(quantity);

        return (productPrice(productName) * quantityEl);
    }

    public String assertTotalPriceOfProductsInCart(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceOfProductsInCart))
                .getText();
    }

    public int totalPriceOfProductsInCart(String firstProduct ,String quantityOfFirstProduct,String secondProduct ,String quantityOfSecondProduct){
        return totalPriceOfFirstProduct(firstProduct ,quantityOfFirstProduct) + totalPriceOfSecondProduct(secondProduct ,quantityOfSecondProduct) + 7;
    }

    public String assertPaymentMethod(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textForPayment)).getText();
    }

    public String asserFinalPrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textForFinalPrice)).getText();
    }

    public String asserSuccessfulOrder(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successfulOrder)).getText();
    }

    public String assertShippingInfo(){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(customerDeliveryAddress));
        StringBuilder text = new StringBuilder();
        for(int i = 1; i <=6; i++){
            String text1 = elements.get(i).getText();
            text.append(text1);

        }
        return text.toString();
    }



}
