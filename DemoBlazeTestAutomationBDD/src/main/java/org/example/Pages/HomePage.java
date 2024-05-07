package org.example.Pages;

import org.example.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends PageSample {
    public HomePage(WebDriver driver) {super(driver);}
    @FindBy(id="signin2")
    WebElement signUpButton;
    @FindBy(id="login2")
    WebElement loginButton;
    @FindBy(css="a[data-target*='exampleModal']")
    WebElement contactButton;
    @FindBy(css = "a[onclick*=\"byCat('notebook')\"]")
    WebElement laptopCategoriesButton;
    @FindBy(css ="a[onclick=\"byCat('monitor')\"]")
    WebElement monitorCategoriesButton;
    @FindBy(id="cartur")
    WebElement cartButton;
    @FindBy(xpath = "//a[@onclick=\"logOut()\"]")
    WebElement logoutButton;

    public String getTitle(){
        return driver.getTitle();
    }
    public SignupPage clickSignUp(){
        clickElement(signUpButton);
        return new SignupPage(driver);
    }
    public LoginPage clickLogin(){
        clickElement(loginButton);
        return new LoginPage(driver);
    }
    public ContactPage clickContactButton(){
        clickElement(contactButton);
        return new ContactPage(driver);
    }
    public CategoryPages clickLaptopsCategories(){
        clickElement(laptopCategoriesButton);
        return new CategoryPages(driver);
    }
    public CategoryPages clickMonitorCategoryPage(){
        clickElement(monitorCategoriesButton);
        return new CategoryPages(driver);
    }
    public CartPage clickCartButton(){
        clickElement(cartButton);
        return new CartPage(driver);
    }
    public HomePage clickLogoutButton(){
        clickElement(logoutButton);
        return new HomePage(driver);
    }

    public boolean checLogout(){
        if(visibilityOf(loginButton)==null){return true;}
        else{return false;}
    }
}
