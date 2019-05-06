package com.epam.mentorship;

import com.epam.mentorship.core.annotations.Injector;
import com.epam.mentorship.core.driver.Driver;
import com.epam.mentorship.po.CategoriesMenuPO;

import com.epam.mentorship.utils.Logger;
import com.epam.mentorship.utils.Wait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainMenuTest  extends  BaseTest{

    @Injector
    static CategoriesMenuPO categoriesMenuPO;


    @Test
    public void test()  {
        Logger.step("Open");
        WebDriver dr = Driver.getDriver();
        Driver.get("http://automationpractice.com/index.php");
        Logger.error("Bla Bl bla");
        categoriesMenuPO.getMenuCategoryByIndex(0).clickJS();
        Wait.ajaxWait(()->true);
        Assert.assertTrue(false);



    }
}
