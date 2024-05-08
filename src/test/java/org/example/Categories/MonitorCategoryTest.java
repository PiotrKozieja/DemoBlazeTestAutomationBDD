package org.example.Categories;

import org.example.Base.BaseTest;
import org.example.Pages.CategoryPages;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonitorCategoryTest extends BaseTest {
    CategoryPages monitorCategoryPage;
    @BeforeClass
    public void loadMoniotorCategory(){
        this.monitorCategoryPage = homePage.clickMonitorCategoryPage();
    }
    @Test
    public void testMonitorCategoryLoadsCorrect(){
        System.out.println("moniotr category loads");
    }
}
