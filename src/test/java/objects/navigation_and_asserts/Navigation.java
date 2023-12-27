package objects.navigation_and_asserts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Navigation {
    //Objects
    private final WebDriverWait wait;
    private final Actions actions;
    private final JavascriptExecutor js;

    //Variables
    private final By singInButton = By.xpath("//*[@class='login']");
    private final By categoryMenu = By.xpath("//*[@id='block_top_menu']/ul/li");
    private final By womenTopsTShirts = By.xpath("//*[@class='submenu-container clearfix first-in-line-xs']/li/ul/li/a[contains(text(), 'T-shirts')]");
    private final By womenTopsBlouses = By.xpath("//*[@class='submenu-container clearfix first-in-line-xs']/li/ul/li/a[contains(text(), 'Blouses')]");
    private final By dressesCasualDresses = By.xpath("//*[@class='submenu-container clearfix first-in-line-xs']/li/ul/li/a[contains(text(), 'Casual Dresses')]");
    private final By dressesEveningDresses = By.xpath("//*[@class='submenu-container clearfix first-in-line-xs']/li/ul/li/a[contains(text(), 'Evening Dresses')]");
    private final By dressesSummerDresses = By.xpath("//*[@class='submenu-container clearfix first-in-line-xs']/li/ul/li/a[contains(text(), 'Summer Dresses')]");
    private final By submitButtonForCreateAccount = By.id("submitAccount");
    private final By addToCartButton = By.id("add_to_cart");
    private final By continueShoppingButton = By.xpath("//*[@class='continue btn btn-default button exclusive-medium']");
    private final By proceedToCheckOut = By.xpath("//*[@class='btn btn-default button button-medium']");
    private final By checkOutButton = By.xpath("//*[@id='center_column']/p[2]/a[1]");
    private final By saveButton = By.id("submitAddress");
    private final By proceedToCheckOutButton = By.xpath("//*[@class='button btn btn-default button-medium']");
    private final By proceedToCheckOutButton2 = By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']");
    private final By confirmOrderButton = By.xpath("//*[@class='button btn btn-default button-medium']");

    //Methods
    public Navigation(WebDriver driver, WebDriverWait wait,JavascriptExecutor js){
        this.wait = wait;
        this.js = js;
        actions = new Actions(driver);
    }
    public void clickOnSingInButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(singInButton))
                .click();
    }

    private void navigateToCategoryAndClick(By categoryName){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(categoryMenu));
        actions.moveToElement(elements.get(0)).perform();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(categoryName));
        actions.moveToElement(element).click().build().perform();

    }
    public void navigateToShopSection(String shoppingFor){
        switch (shoppingFor.toLowerCase()){
            case "blouses":
                navigateToCategoryAndClick(womenTopsBlouses);
                break;
            case "t-shirts":
                navigateToCategoryAndClick(womenTopsTShirts);
                break;
            case "casual dresses":
                navigateToCategoryAndClick(dressesCasualDresses);
                break;
            case "evening dresses":
                navigateToCategoryAndClick(dressesEveningDresses);
                break;
            case "summer dresses":
                navigateToCategoryAndClick(dressesSummerDresses);
                break;
        };
    };
    public void clickOnSubmitButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButtonForCreateAccount)).click();
    }

    public void clickOnAddToCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton))
                .click();
    }
    public void clickOnContinueShopping(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton))
                .click();
    }
    public void clickOnProceedToCheckOut(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOut))
                .click();
    }
    public void clickCheckOutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton))
                .click();
    }
    public void clickOnSaveButton(){
        js.executeScript("window.scrollBy(0, 1200)");
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    public void clickOnProceedButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(proceedToCheckOutButton)).click();
    }
    public void clickOnProceedButton2(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOutButton2)).click();
    }
    public void clickOnConfirmButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderButton)).click();
    }

}
