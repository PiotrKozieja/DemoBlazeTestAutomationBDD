package org.example.HomePage;

import org.example.Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout() throws InterruptedException {
        homePage.clickLogoutButton();
        assertTrue(homePage.checkLogout());
    }

}
