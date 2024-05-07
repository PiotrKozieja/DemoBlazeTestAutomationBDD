package org.example.ProductPage;

import org.example.Base.BaseTest;
import org.example.Pages.ProductPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AppleMonitor24ProductPageTest extends BaseTest {
    ProductPage productPage;
    @BeforeClass
    public void LoadAppleMonitorPage(){
        this.productPage = homePage.clickMonitorCategoryPage().clickAppleMonitor24();
    }
    @Test(priority = 1)
    public void testProductLoadsCorrectly(){
        String productTitle = productPage.getProductTitle();
        assertEquals(productTitle,"Apple monitor 24","Product does not load correctly");
    }
    @Test(priority = 2)
    public void testAddedToCartAlertTwoTimes(){
        productPage.addToCart();
        String alertMessage = productPage.getAlertMessage();
        assertTrue(alertMessage.contains("Product added"), "Cannot add first product to the cart");
        productPage.acceptAlert();
        productPage.addToCart();
        String alertMessage1 = productPage.getAlertMessage();
        assertTrue(alertMessage.contains("Product added"), "Cannot add second product to the cart");
        productPage.acceptAlert();
    }
}
