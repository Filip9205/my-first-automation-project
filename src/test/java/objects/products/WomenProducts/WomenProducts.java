package objects.products.WomenProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WomenProducts {
    //Objects

    private final WebDriverWait wait;
    private final Actions actions;

    //Variables
    private final By listOfProducts = By.xpath("//*[@class='product_list grid row']/li");
    private final By moreInfoForProduct = By.xpath("//*[@class='button lnk_view btn btn-default']");

    //Methods
    public WomenProducts(WebDriver driver, WebDriverWait wait){
        this.wait = wait;
        actions = new Actions(driver);
    }
    private void clickOnMore(int i){
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(moreInfoForProduct));
        elements.get(i).click();
    }
    private void clickOnTShirtByName(String productName) {
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listOfProducts));
        if (productName.equalsIgnoreCase("faded short sleeve t-shirts")) {
            actions.moveToElement(elements.get(0)).click().build().perform();
            clickOnMore(0);
        } else {
            System.out.println("There is no such product in the T-Shirt Section");
        }
    }

    private void clickOnBlouseByName(String productName) {
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listOfProducts));
        if (productName.equalsIgnoreCase("blouse")) {
            actions.moveToElement(elements.get(0)).click().build().perform();
            clickOnMore(0);
        } else {
            System.out.println("There is no such product in the Blouse Section");
        }
    }

    public void clickOnCasualDressByName(String productName) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listOfProducts));
        if (productName.equalsIgnoreCase("printed dress")) {
            actions.moveToElement(elements.get(0)).click().build().perform();
            clickOnMore(0);
        } else {
            System.out.println("There is no such product in the Casual Dresses Section");
        }
    }

    public void clickOnEveningDressByName(String productName) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listOfProducts));
        if (productName.equalsIgnoreCase("evening printed dress")) {
            actions.moveToElement(elements.get(0)).click().build().perform();
            clickOnMore(0);
        } else {
            System.out.println("There is no such product in the Evening Dresses Dresses Section");
        }
    }

    public void clickOnSummerDressByName(String productName){
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listOfProducts));
        switch(productName.toLowerCase()){
            case "printed summer dress":
                actions.moveToElement(elements.get(0)).click().build().perform();
                clickOnMore(0);
                break;
            case "printed summer dress1":
                actions.moveToElement(elements.get(1)).click().build().perform();
                clickOnMore(1);
                break;
            case "printed chiffon dress":
                actions.moveToElement(elements.get(2)).click().build().perform();
                clickOnMore(2);
                break;
            default:
                System.out.println("There is no such product in the Summer Dresses Dresses Section");
                break;
        }
    }
    public void putTheProductInCartByProductName(String productName){
        switch (productName.toLowerCase()){
            case "faded short sleeve t-shirts":
                clickOnTShirtByName(productName);
                break;
            case "blouse":
                clickOnBlouseByName(productName);
                break;
            case "printed dress":
                clickOnCasualDressByName(productName);
                break;
            case "evening printed dress":
                clickOnEveningDressByName(productName);
                break;
            case "printed summer dress", "printed chiffon dress", "printed summer dress1":
                clickOnSummerDressByName(productName);
                break;


        }
    }



}
