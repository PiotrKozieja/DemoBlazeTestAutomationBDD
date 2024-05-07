package org.example.HomePage;

import org.example.Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoadPageTest extends BaseTest {
    @Test
    void testSuccesfulLoading(){
        String title = homePage.getTitle();
        assertEquals(title,"STORE","Page is not loading correct");
    }
}
