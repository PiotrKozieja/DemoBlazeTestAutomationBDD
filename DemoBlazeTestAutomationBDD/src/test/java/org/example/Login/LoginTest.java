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
    @Test(priority = 2)
    public void testLoggingin(){
        loginPage.fillLoginFormsAndLogin(username,password);
        String welcomeMessage = loginPage.getWelcomeMessage();
        assertEquals(welcomeMessage,"Welcome "+username,"Logging in went wrong");
    }

}
