package org.example.Contact;

import org.example.Base.BaseTest;

import org.example.Pages.ContactPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactTest extends BaseTest {
    private ContactPage contactPage;
    @BeforeClass
    public void loadContactPage(){this.contactPage = homePage.clickContactButton();}
    @Test(priority = 1)
    public void testContactPageLoads(){
        String contactPopUpTitle = contactPage.getContactPopUpTitle();
        assertEquals(contactPopUpTitle,"New message","Contact pop-up does not show up");
    }
    @Test(priority = 2, dataProvider = "contactDataProvider")
    public void testThanksForTheMessageAlert(String contactEmail,String contactName,String contactMessage) throws InterruptedException {
        contactPage.fillContactFormsAndSend(contactEmail,contactName,contactMessage);
        String contactAlertMessage = contactPage.getAlertMessage();
        assertEquals(contactAlertMessage,"Thanks for the message!!","Could not send a message");
        contactPage.acceptAlert();
    }
}
