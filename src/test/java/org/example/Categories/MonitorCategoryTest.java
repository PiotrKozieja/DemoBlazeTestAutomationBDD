package org.example.Categories;

import org.example.Base.BaseTest;
import org.example.Pages.CategoryPages;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
public class MonitorCategoryTest extends BaseTest {
    CategoryPages monitorCategoryPage;
    @BeforeClass
    public void loadMoniotorCategory(){
        this.monitorCategoryPage = homePage.clickMonitorCategoryPage();
    }
    @Test
    public void testMonitorCategoryLoadsCorrect(){
        assertTrue(monitorCategoryPage.isMonitorCategoryDisplayed());
    }
}
