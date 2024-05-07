package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class PageSample {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected PageSample(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    protected void alertWait() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public String getAlertMessage() {
        alertWait();
        return driver.switchTo().alert().getText();
    }
    public void acceptAlert() {
        alertWait();
        driver.switchTo().alert().accept();
    }
    public String getPopUpTitle(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

}
