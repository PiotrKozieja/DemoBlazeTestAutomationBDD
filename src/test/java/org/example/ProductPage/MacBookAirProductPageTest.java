package org.example.ProductPage;

import org.example.Base.BaseTest;
import org.example.Pages.ProductPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MacBookAirProductPageTest extends BaseTest {
    ProductPage productPage;
    @BeforeClass
    public void loadMacBookAirProductPage(){
        this.productPage = homePage.clickLaptopsCategories().clickMacBookAir();
    }
    @Test(priority = 1)
    public void testProductLoadsCorrectly(){
        String productTitle = productPage.getProductTitle();
        assertEquals(productTitle,"MacBook air","Product does not load correctly");
    }
    @Test(priority = 2)
    public void testAddedToCartAlert(){
        productPage.addToCart();
        String alertMessage = productPage.getAlertMessage();
        assertEquals(true,alertMessage.contains("Product added"),"Cannot add product to the cart");
        System.out.println(alertMessage);
        productPage.acceptAlert();
    }
    @Test(priority =3)
    public void testHomeButtonWorksCorrectly(){
        productPage.clickHomePageButton();
        System.out.println("loads home page correctly");
    }

}
