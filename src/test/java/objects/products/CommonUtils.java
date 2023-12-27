package objects.products;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonUtils {
    //Classes
    Colors colors = new Colors();
    //Objects
    private final WebDriverWait wait;
    //Variables
    private final By quantityButton = By.id("quantity_wanted");
    private final By sizeButton = By.id("uniform-group_1");
    private final By sizeOption = By.xpath("//*[@id='group_1']/option");



    //Methods
    public CommonUtils(WebDriverWait wait){
        this.wait = wait;
    }

    public void enterQuantityForProduct(String quantityAmount){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityButton));
        element.sendKeys(Keys.ARROW_RIGHT);
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(quantityAmount);
    }

    private void sizePick(int i){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sizeOption));
        elements.get(i).click();
    }

    public void pickSizeForProduct(String productSize) throws InterruptedException {
       wait.until(ExpectedConditions.visibilityOfElementLocated(sizeButton))
               .click();
       Thread.sleep(500);
       switch (productSize.toLowerCase()) {
           case "s":
               sizePick(0);
               break;
           case "m":
               sizePick(1);
               break;
           case "l":
               sizePick(2);
               break;
       }
    }

    private void color(By colorLocator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(colorLocator));
        element.click();
    }

    public void pickColorForProduct(String productColor){
        switch (productColor.toLowerCase()){
            case "beige":
                color(colors.colorBeige);
                break;
            case "white":
                color(colors.colorWhite);
                break;
            case "black":
                color(colors.colorBlack);
                break;
            case "orange":
                color(colors.colorOrange);
                break;
            case "blue":
                color(colors.colorBlue);
                break;
            case "green":
                color(colors.colorGreen);
                break;
            case "yellow":
                color(colors.colorYellow);
                break;
            case "pink":
                color(colors.colorPink);
                break;
        }
    }
}
