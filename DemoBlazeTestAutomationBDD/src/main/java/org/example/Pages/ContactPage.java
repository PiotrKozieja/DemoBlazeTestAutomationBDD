package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends PageSample{
    public ContactPage(WebDriver driver){super(driver);}
    @FindBy(css="h5[id*='exampleModalLabel']")
    WebElement contactPopUpTitle;
    @FindBy(id="recipient-email")
    WebElement emailForm;
    @FindBy(id="recipient-name")
    WebElement contactNameForm;
    @FindBy(id="message-text")
    WebElement messageForm;
    @FindBy(css="button[onclick*='send()']")
    WebElement sendMessageButton;

    public String getContactPopUpTitle(){return getPopUpTitle(contactPopUpTitle);}
    public void fillContactEmailForm(String email){emailForm.sendKeys(email);}
    public void fillContactNameForm(String name){contactNameForm.sendKeys(name);}
    public void fillMessageForm(String message){messageForm.sendKeys(message);}
    public void clickSendMessageButton(){clickElement(sendMessageButton);}
    public void fillContactFormsAndSend(String email, String name, String message){
        fillContactEmailForm(email);
        fillContactNameForm(name);
        fillMessageForm(message);
        clickSendMessageButton();
    }

}
