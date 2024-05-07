package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;
import java.util.List;

public class CartPage extends PageSample{
    public CartPage(WebDriver driver) {super(driver);}
    //("//tr[td[contains(text(),'Apple monitor 24')]]//a"))
    //("//tr[@class='success']/td[3]") --productprice
    @FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[1]/h2")
    WebElement productTitle;
    @FindBy(id = "totalp")
    WebElement totalPrice;
    @FindBy(xpath = "//tr[@class='success']/td[3]")
    List<WebElement> productPrices;
    @FindBy(css = "button[class*='btn btn-success']")
    WebElement placeOrderButton;
    @FindBy(css = "h5[id*=orderModalLabel]")
    WebElement cartPopUpTitle;
    @FindBy(id = "name")
    WebElement nameForm;
    @FindBy(id = "country")
    WebElement countryForm;
    @FindBy(id = "city")
    WebElement cityForm;
    @FindBy(id = "card")
    WebElement creditCardForm;
    @FindBy(id = "month")
    WebElement monthForm;
    @FindBy(id = "year")
    WebElement yearForm;
    @FindBy(css = "button[onclick=\'purchaseOrder()\'")
    WebElement purchaseButton;
    @FindBy(xpath = "//div[@class=\"sweet-alert  showSweetAlert visible\"]/h2")
    WebElement popUpTitleMessage;
    @FindBy(xpath = "//p[@class=\"lead text-muted \"]")
    WebElement popUpPrice;
    @FindBy(xpath = "//button[@class=\"confirm btn btn-lg btn-primary\"]")
    WebElement okButton;


    public String getTitle(){
        return productTitle.getText();
    }
    public void deleteProductFromCart(String productName){
        driver.findElement(By.xpath("//tr[td[contains(text(),'"+productName+"')]]//a")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//tr[td[contains(text(),'"+productName+"')]]//a"))));
    }
    public BigDecimal getCartTotalPrice(){
        wait.until(ExpectedConditions.visibilityOf(totalPrice));
        return new BigDecimal(totalPrice.getText());
    }
    public BigDecimal sumProductInCartPrices(){
        BigDecimal totalPrice = BigDecimal.ZERO;
        for(WebElement productPrice:productPrices){
            totalPrice = totalPrice.add(new BigDecimal(productPrice.getText()));
        }
        return totalPrice;
    }
    public void clickPlaceOrderButton(){
        clickElement(placeOrderButton);
    }
    public String getCartPopUpTitle(){
        return getPopUpTitle(cartPopUpTitle);
    }
    public void fillPlaceOrderFormsAndPurchase(String name,String country,String city,String creditCard, String month, String year){
        nameForm.sendKeys(name);
        countryForm.sendKeys(country);
        cityForm.sendKeys(city);
        creditCardForm.sendKeys(creditCard);
        monthForm.sendKeys(month);
        yearForm.sendKeys(year);
        clickElement(purchaseButton);
    }
    public String getPurchasePopUpTitle(){
        wait.until(ExpectedConditions.visibilityOf(popUpTitleMessage));
        return popUpTitleMessage.getText();
    }
    public BigDecimal getPopUpPrice() {
        String text = popUpPrice.getText();
        String[] words = text.split(" ");
        return new BigDecimal(words[2]);
    }
    public void clickOkButtonPopUp(){
        clickElement(okButton);
    }

}
