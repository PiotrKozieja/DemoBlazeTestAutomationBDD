package org.example.HomePage;

import org.example.Base.BaseTest;
import org.example.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    @BeforeClass
    public void HomePageTest(WebDriver driver){
        this.homePage = new HomePage(driver);
    }
}
