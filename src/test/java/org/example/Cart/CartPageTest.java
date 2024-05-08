package org.example.Cart;

import org.example.Base.BaseTest;
import org.example.Pages.CartPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CartPageTest extends BaseTest {
    private CartPage cartPage;

    public void setProductPriceSum(BigDecimal productPriceSum) {
        this.productPriceSum = productPriceSum;
    }

    public BigDecimal getProductPriceSum() {
        return productPriceSum;
    }

    private BigDecimal productPriceSum;
    @BeforeClass
    public void loadCartPage(){this.cartPage= homePage.clickCartButton();}
    @Test(priority = 1)
    public void testCartPageLoads(){
        String cartPageTitle = cartPage.getTitle();
        assertEquals(cartPageTitle,"Products","Page does not load");
    }
    @Test(priority = 2)
    public void testAppleMoniotrDeleteFromCart() {
        cartPage.deleteProductFromCart("Apple monitor 24");
        System.out.println("deleted");
    }
    @Test(priority = 3)
    public void testCartTotalPrice(){
        BigDecimal actualTotalPrice = cartPage.getCartTotalPrice();
        setProductPriceSum(cartPage.sumProductInCartPrices());
        assertEquals(actualTotalPrice,getProductPriceSum(),"Total price and sum of product prices are not the same");
    }
    @Test(priority = 4)
    public void testPlaceOrderButton(){
        cartPage.clickPlaceOrderButton();
        String popUpTilte = cartPage.getCartPopUpTitle();
        assertEquals(popUpTilte,"Place order","Place order pop-up does not show up");
    }
    @Test(priority = 5,dataProvider = "purchaseDataProvider")
    public void testPurchaseOrderPlace(String name,String country,String city, String creditCard, String month, String year){
        cartPage.fillPlaceOrderFormsAndPurchase(name,country,city,creditCard,month,year);
        String popUpTitle = cartPage.getPurchasePopUpTitle();
        assertEquals(popUpTitle,"Thank you for your purchase!","Purchasing order went wrong");
    }
    @Test(priority = 6)
    public void testPopUpPrice(){
        BigDecimal popUpPrice = cartPage.getPopUpPrice();
        assertEquals(popUpPrice,getProductPriceSum(),"Order price and actual actual price are different");
        cartPage.clickOkButtonPopUp();
    }
}
