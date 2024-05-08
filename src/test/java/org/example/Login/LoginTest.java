package org.example.Login;

import org.example.Base.BaseTest;
import org.example.Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @BeforeClass
    public void loadLoginPage(){this.loginPage = homePage.clickLogin();}
    @Test(priority = 1)
    public void testLoginPageLoads(){
        String LoginPopUpTitle = loginPage.getPopUpTitle();
        assertEquals(LoginPopUpTitle,"Log in","Login pop-up does not show up");
    }
    @Test(priority = 2,dataProvider = "accountDataProvider")
    public void testLoggingin(String username1, String password1){
        loginPage.fillLoginFormsAndLogin(username1,password1);
        String welcomeMessage = loginPage.getWelcomeMessage();
        assertEquals(welcomeMessage,"Welcome "+username1,"Logging in went wrong");
    }

}
