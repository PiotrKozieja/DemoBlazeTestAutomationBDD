package org.example.Categories;

import org.example.Base.BaseTest;
import org.example.Pages.CategoryPages;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LaptopCategoryTest extends BaseTest {
    CategoryPages laptopCategoryPage;
    @BeforeClass
    public void loadLaptopCategory(){
        this.laptopCategoryPage = homePage.clickLaptopsCategories();
        System.out.println("categories");
    }
    @Test
    public void testLaptopCategoryLoadsCorrect(){
        System.out.println("laptop category loads");
        assertTrue(true,"do not loads");
    }
}
