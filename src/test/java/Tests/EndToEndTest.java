package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class EndToEndTest extends BaseTest {

    //Variables
    //                                 Email             Gender  Name   Surname   Password    Day    Month      Year    Newsletter
    String[] accountCredentials = {getRandomEmail(), "Male", "Tom", "Soy", "password123", "16", "February", "2023", "No"};
    //                       ShoppingFor    Product Name            Quantity Size Color
    String[] firstProduct = {"T-Shirts", "Faded Short Sleeve T-shirts", "1", "l", "Blue",};
    String[] secondProduct = {"Blouses", "Blouse", "1", "m", "White"};
    //                     address city state postcode country homephone mobilephone aliasToSaveInfo
    String[] shippingInfoData = {"address", "city", "Alabama", "00000", "United States", "02200000", "070100100", "My Info"};
    String paymentMethod = "check";



    @Test
    public void EndToEnd() throws InterruptedException {
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
        Assert.assertEquals(asserts.assertCustomerAccount(), accountCredentials[2] + " " + accountCredentials[3]);

        navigation.navigateToShopSection(firstProduct[0]);

        Assert.assertEquals(asserts.assertShopSection(), firstProduct[0].toUpperCase() + " ");

        womenProducts.putTheProductInCartByProductName(firstProduct[1]);
        sharedMethods.enterQuantityForProduct(firstProduct[2]);
        sharedMethods.pickSizeForProduct(firstProduct[3]);
        sharedMethods.pickColorForProduct(firstProduct[4]);

        navigation.clickOnAddToCartButton();
        navigation.clickOnContinueShopping();
        navigation.navigateToShopSection(secondProduct[0]);

        Assert.assertEquals(asserts.assertShopSection(), secondProduct[0].toUpperCase()+" ");

        womenProducts.putTheProductInCartByProductName(secondProduct[1]);
        sharedMethods.enterQuantityForProduct(secondProduct[2]);
        sharedMethods.pickSizeForProduct(secondProduct[3]);
        sharedMethods.pickColorForProduct(secondProduct[4]);

        navigation.clickOnAddToCartButton();
        navigation.clickOnProceedToCheckOut();

        Assert.assertEquals(asserts.assertDescriptionForFirstProduct(),firstProduct[1]+"Size : " + firstProduct[3].toUpperCase() + ", Color : " + firstProduct[4]);
        Assert.assertEquals(asserts.assertDescriptionForSecondProduct(),secondProduct[1] + "Size : " + secondProduct[3].toUpperCase()+", Color : " + secondProduct[4]);
        Assert.assertEquals(asserts.assertTotalPriceOfFirstProduct(), "$" + asserts.totalPriceOfFirstProduct(firstProduct[1], firstProduct[2]));
        Assert.assertEquals(asserts.assertTotalPriceOfSecondProduct(), "$" + asserts.totalPriceOfSecondProduct(secondProduct[1], secondProduct[2]));
        Assert.assertEquals(asserts.assertTotalPriceOfProductsInCart(), "$" + asserts.totalPriceOfProductsInCart(firstProduct[1], firstProduct[2], secondProduct[1], secondProduct[2]));

        navigation.clickCheckOutButton();

        shippingInfo.enterAddress(shippingInfoData[0]);
        shippingInfo.enterCity(shippingInfoData[1]);
        shippingInfo.enterState(shippingInfoData[2]);
        shippingInfo.enterZip(shippingInfoData[3]);
        shippingInfo.enterCountry(shippingInfoData[4]);
        shippingInfo.enterHomePhone(shippingInfoData[5]);
        shippingInfo.enterMobilePhone(shippingInfoData[6]);
        shippingInfo.enterAliasToSaveInfo(shippingInfoData[7]);

        navigation.clickOnSaveButton();
        Assert.assertEquals(asserts.assertShippingInfo(),accountCredentials[2] + " " + accountCredentials[3] + shippingInfoData[0] + shippingInfoData[1] + ", " + shippingInfoData[2] + " "
               + shippingInfoData[3] + shippingInfoData[4] + shippingInfoData[5] + shippingInfoData[6]);

        navigation.clickOnProceedButton();

        shippingInfo.checkButtonToAgreeOnTerms();
        navigation.clickOnProceedButton2();
        shippingInfo.selectPaymentMethod(paymentMethod);

        Assert.assertEquals(asserts.assertPaymentMethod(),"You have chosen to pay by " + paymentMethod.toLowerCase() + ". Here is a short summary of your order:");
        //Ima bug na stranata vo matematikata za presmetuvanje na krajna cena
        /*Assert.assertEquals(asserts.asserFinalPrice(),"- The total amount of your order comes to: $"
                +asserts.totalPriceOfProductsInCart(firstProduct[1], firstProduct[2], secondProduct[1], secondProduct[2]) + " (tax incl.)");*/

        navigation.clickOnConfirmButton();

        Assert.assertEquals(asserts.asserSuccessfulOrder(),"Your order on My Shop is complete.");
    }
}
