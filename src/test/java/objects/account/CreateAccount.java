package objects.account;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {

    private final WebDriverWait wait;

    //Variables
    private final By emailAddressForCreateAccount = By.id("email_create");
    private final By createAnAccountButton = By.id("SubmitCreate");
    private final By maleGender = By.id("id_gender1");
    private final By femaleGender = By.id("id_gender2");
    private final By customerFirstName = By.id("customer_firstname");
    private final By customerLastName = By.id("customer_lastname");
    private final By customerPassword = By.id("passwd");
    private final By dateOfBirthDays = By.id("days");
    private final By dateOfBirthMonths = By.id("months");
    private final By dateOfBirthYears = By.id("years");
    private final By singUpForNewsLetter = By.id("uniform-newsletter");



    //Methods
    public CreateAccount(WebDriverWait wait){
        this.wait = wait;
    }

    public void enterEmailToCreateAccount(String enterEmail){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressForCreateAccount))
                .sendKeys(enterEmail);
    }

    public void clickOnCreateAnAccountButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAnAccountButton))
                .click();
    }

    public void selectGender(String gender){
        switch (gender.toLowerCase()){
            case "male":
                wait.until(ExpectedConditions.visibilityOfElementLocated(maleGender))
                        .click();
                break;
            case "female":
                wait.until(ExpectedConditions.visibilityOfElementLocated(femaleGender))
                        .click();
                break;
            default:
                System.out.println("There is only 2 genders");
        }
    }

    public void enterFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerFirstName))
                .sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerLastName))
                .sendKeys(lastName);
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerPassword))
                .sendKeys(password);
    }

    private void dateOfBirthLogic(By element, String choice) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(choice);
    }

    public void enterDateOfBirth(String days, String months, String year) {
        dateOfBirthLogic(dateOfBirthDays, days);
        dateOfBirthLogic(dateOfBirthMonths, months);
        dateOfBirthLogic(dateOfBirthYears, year);
    }

    public void singUpForNewsLetterYesOrNo(String choice){
        switch (choice.toLowerCase()){
            case "yes":
                wait.until(ExpectedConditions.elementToBeClickable(singUpForNewsLetter))
                        .click();
                break;
            case "no":
                break;

        }
    }






}
