package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupPage extends PageSample{
    public SignupPage(WebDriver driver){super(driver);}
    @FindBy(id="signInModalLabel")
    WebElement registrationPopUpTitle;
    @FindBy(id="sign-username")
    WebElement usernameField;
    @FindBy(id="sign-password")
    WebElement passwordField;
    @FindBy(css="button[onclick*='register()']")
    WebElement SignUpButton;

    public String getPopUpTitle(){
        return getPopUpTitle(registrationPopUpTitle);
    }
    public void setUsername(String username){usernameField.sendKeys(username);}
    public void clearUsernameField(){usernameField.clear();}
    public void setPassword(String password){passwordField.sendKeys(password);}
    public void clickSignUpButton(){clickElement(SignUpButton);}
    public void fillSignupFormsAndSignup(String username, String password){
        setUsername(username);
        setPassword(password);
        clickSignUpButton();
    }
}
