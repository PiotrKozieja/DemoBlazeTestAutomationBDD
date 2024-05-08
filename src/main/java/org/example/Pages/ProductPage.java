package org.example.Pages;

import org.example.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductPage extends PageSample{
    public ProductPage(WebDriver driver){super(driver);}
    @FindBy(css="h2[class*=\"name\"]")
    WebElement productTitle;
    @FindBy(css="a[href][class*=\"btn btn-success btn-lg\"]")
    WebElement addToCartButton;
    @FindBy(css = "a[class*='navbar'][href*='index.html']")
    WebElement homePageButton;


    public String getProductTitle(){return productTitle.getText();}
    public void addToCart(){clickElement(addToCartButton);}
    public HomePage clickHomePageButton(){
        clickElement(homePageButton);
        return new HomePage(driver);
    }
}
