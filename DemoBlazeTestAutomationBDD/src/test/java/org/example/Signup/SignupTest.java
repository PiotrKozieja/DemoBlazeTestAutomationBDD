package org.example.Signup;

import org.example.Base.BaseTest;
import org.example.Pages.SignupPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignupTest extends BaseTest {
    private SignupPage signupPage;
    @BeforeClass
    public  void loadSignupPage(){
        this.signupPage = homePage.clickSignUp();
    }
    @Test(priority = 1)
    public void testSignupPageLoads(){
        String RegistrationPopUpTitle = signupPage.getPopUpTitle();
        assertEquals(RegistrationPopUpTitle,"Sign up","Registration pop-up does not show up");
    }
    @Test(priority = 2)
    public void testAllFieldsShouldBeFilledOutAlert(){
        signupPage.setUsername(username);
        signupPage.clickSignUpButton();
        String AlertMessage = signupPage.getAlertMessage();
        assertEquals(AlertMessage,"Please fill out Username and Password.","Alert does not show up");
        signupPage.acceptAlert();
    }
    @Test(priority = 3)
    public void testSuccesfulSignupPopUp(){
        signupPage.clearUsernameField();
        signupPage.fillSignupFormsAndSignup(username,password);
        String AlertMessage = signupPage.getAlertMessage();
        assertEquals(AlertMessage,"Sign up successful.","Could not create an account");
        signupPage.acceptAlert();

    }
}
