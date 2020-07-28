package com.epam.mentorship;

import com.epam.mentorship.core.pages.HomePage;
import com.epam.mentorship.core.po.CategoriesMenuPO;
import com.epam.mentorship.utils.Logger;
import com.epam.mentorship.utils.Wait;
import org.testng.annotations.Test;

import static com.epam.mentorship.utils.Logger.step;


public class MainMenuTest extends  BaseTest{

//    @Inject
    CategoriesMenuPO categoriesMenuPO;

//    @Inject
    HomePage homePage;


//    @Test
//    public void test()  {
//        homePage  = new HomePage();
//        homePage.open();
//        Logger.error("Bla Bl bla");
//        categoriesMenuPO=new CategoriesMenuPO();
//        categoriesMenuPO.clickOnLogo();
//        Wait.ajaxWait(()->true);
//
//    }
//    @Test
//    public void test1()  {
//        homePage  = new HomePage();
//        homePage.open();
//        Logger.error("Bla Bl bla");
//        categoriesMenuPO=new CategoriesMenuPO();
//        categoriesMenuPO.clickOnLogo();
//        Wait.ajaxWait(()->true);
//
//    }
//    @Test
//    public void test2()  {
//        homePage  = new HomePage();
//        homePage.open();
//        Logger.error("Bla Bl bla");
//        categoriesMenuPO=new CategoriesMenuPO();
//        categoriesMenuPO.clickOnLogo();
//        Wait.ajaxWait(()->true);
//    }


    public void isSubMenuOpenByHover(){
        homePage.open();
        step("Verify menu is open by hover");
//        categoriesMenuPO.getMenuCategoryByIndex()
    }
}
