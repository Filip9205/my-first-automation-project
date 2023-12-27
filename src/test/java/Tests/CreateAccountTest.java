package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class CreateAccountTest extends BaseTest{
    Random random = new Random();
    int randomNumber = random.nextInt(1000);
    String email = "email"+randomNumber+"@gmail.com";

    //Variables
                                //     Email             Gender  Name   Surname   Password    Day    Month      Year    Newsletter
    String[] accountCredentials = {email, "Male", "Tom", "Soy", "password123", "16", "February", "2023", "No"};



    //Test
    @Test
    public void createAccount(){
        navigation.clickOnSingInButton();

        createAccount.enterEmailToCreateAccount(accountCredentials[0]);
        createAccount.clickOnCreateAnAccountButton();

        createAccount.selectGender(accountCredentials[1]);
        createAccount.enterFirstName(accountCredentials[2]);
        createAccount.enterLastName(accountCredentials[3]);
        createAccount.enterPassword(accountCredentials[4]);
        createAccount.enterDateOfBirth(accountCredentials[5], accountCredentials[6], accountCredentials[7]);
        createAccount.singUpForNewsLetterYesOrNo(accountCredentials[8]);
        navigation.clickOnSubmitButton();

        Assert.assertEquals(asserts.assertSuccessfullyCreatedAccount(),"Your account has been created.");
        Assert.assertEquals(asserts.assertCustomerAccount(), "asd"+" wew");
    }
}
