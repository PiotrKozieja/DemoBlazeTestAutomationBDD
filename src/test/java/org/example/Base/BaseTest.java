package org.example.Base;

import org.example.Pages.CartPage;
import org.example.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;
import org.example.Pages.HomePage;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static  WebDriver driver;
    protected static HomePage homePage;
//    protected String username = "user126789453213123123121234567";
//    protected String password = "password";
//    ////
//    protected String contactEmail = "testemail@gmail.com";
//    protected String contacName = "Jan Kowalski";
//    protected String contactMessage = "Test message";
//    ////
//    protected String name ="jan";
//    protected String country = "Poland";
//    protected String city = "krakow";
//    protected String creditCard = "123456789";
//    protected String month = "6";
//    protected String year = "2024";
    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
        System.out.println("TearDown");
    }
    @DataProvider
    public Object[][] accountDataProvider(){
        return new Object[][] {{"user126789453213123123121234567","password"}};
    }
    @DataProvider
    public Object[][] contactDataProvider(){
        return new Object[][] {{"testemail@gmail.com","Jan Kowalski","Test message"}};
    }
    @DataProvider
    public Object[][] purchaseDataProvider(){
        return new Object[][] {{"jan","Poland","krakow","123456789","6","2024"}};
    }
    public void setProductPriceSum(BigDecimal productPriceSum) {
        this.productPriceSum = productPriceSum;
    }

    public BigDecimal getProductPriceSum() {
        return productPriceSum;
    }

    private BigDecimal productPriceSum;
}
