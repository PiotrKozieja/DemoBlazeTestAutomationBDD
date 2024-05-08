package org.example.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageSample {
    public LoginPage(WebDriver driver){super(driver);}
    @FindBy(id="logInModalLabel")
    WebElement loginPopUpTitle;
    @FindBy(id="loginusername")
    WebElement usernameForm;
    @FindBy(id="loginpassword")
    WebElement passwordForm;
    @FindBy(css="button[onclick*='logIn']")
    WebElement loginButton;
    @FindBy(css="a[style*='display: block'][id*='nameofuser']")
    WebElement welcomeMessage;

    public String getPopUpTitle(){
        wait.until(ExpectedConditions.visibilityOf(loginPopUpTitle));
        return loginPopUpTitle.getText();
    }
    public void fillUsername(String username){usernameForm.sendKeys(username);}
    public void fillPassword(String password){passwordForm.sendKeys(password);}
    public void clickLoginButton(){clickElement(loginButton);}
    public String getWelcomeMessage(){return getPopUpTitle(welcomeMessage);} ////message after logging in
    public void fillLoginFormsAndLogin(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLoginButton();
    }
}
