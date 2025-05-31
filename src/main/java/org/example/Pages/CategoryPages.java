package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPages extends PageSample{
    public CategoryPages(WebDriver driver) {super(driver);}

    @FindBy(css="a[href=\"prod.html?idp_=11\"][class*='hrefch']")
    WebElement macBookAir;
    @FindBy(css="a[href=\"prod.html?idp_=10\"][class=\"hrefch\"]")
    WebElement appleMoniotr24;


    public ProductPage clickMacBookAir(){
        clickElement(macBookAir);
        return new ProductPage(driver);
    }
    public boolean isLaptopCategoryDisplayed(){
        return macBookAir.isDisplayed();
    }
    public ProductPage clickAppleMonitor24(){
        clickElement(appleMoniotr24);
        return new ProductPage(driver);
    }
    public boolean isMonitorCategoryDisplayed(){
        return appleMoniotr24.isDisplayed();
    }

}
