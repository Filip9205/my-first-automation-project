package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddTwoProductsToCartTest extends BaseTest{


    //Variables
    //ShoppingFor    Product Name            Quantity Size Color
    String[] firstProduct = {"T-Shirts", "Faded Short Sleeve T-shirts", "3", "l", "Blue",};
    String[] secondProduct = {"Casual Dresses", "Printed Dress", "1", "m", "Orange"};

    @Test
    public void AddTwoProductsToCart() throws InterruptedException {
        navigation.navigateToShopSection(firstProduct[0]);
        Assert.assertEquals(asserts.assertShopSection(), firstProduct[0].toUpperCase()+ " ");

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
        Assert.assertEquals(asserts.assertDescriptionForFirstProduct(),firstProduct[1] + "Size : " + firstProduct[3].toUpperCase() + ", Color : " + firstProduct[4]);
        Assert.assertEquals(asserts.assertDescriptionForSecondProduct(),secondProduct[1] + "Size : " + secondProduct[3].toUpperCase() + ", Color : " + secondProduct[4]);

        Thread.sleep(defaultSleepMillis);

        Assert.assertEquals(asserts.assertTotalPriceOfFirstProduct(), "$"+asserts.totalPriceOfFirstProduct(firstProduct[1], firstProduct[2]));
        Assert.assertEquals(asserts.assertTotalPriceOfSecondProduct(), "$"+asserts.totalPriceOfSecondProduct(secondProduct[1], secondProduct[2]));
        Assert.assertEquals(asserts.assertTotalPriceOfProductsInCart(), "$"+asserts.totalPriceOfProductsInCart(firstProduct[1], firstProduct[2], secondProduct[1], secondProduct[2]));

        navigation.clickCheckOutButton();



    }


}
