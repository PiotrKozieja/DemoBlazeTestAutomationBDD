package org.example.HomePage;

import org.example.Base.BaseTest;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout(){
        homePage.clickLogoutButton();
        homePage.checLogout();
    }

}
