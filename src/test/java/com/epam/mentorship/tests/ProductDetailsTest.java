package com.epam.mentorship.tests;

import com.epam.mentorship.BaseTest;
import com.epam.mentorship.core.pages.HomePage;
import com.epam.mentorship.core.po.ProductDetailsPO;
import com.epam.mentorship.core.po.SearchBoxPO;
import com.epam.mentorship.core.po.SearchResultsPO;
import com.google.inject.Inject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.mentorship.utils.asserters.Asserter.assertRelativeNavigation;
import static com.epam.mentorship.core.driver.Driver.closeWindowsExceptMain;
import static com.epam.mentorship.core.driver.Driver.switchToWindow;
import static com.epam.mentorship.data.PropertiesData.getTestData;
import static com.epam.mentorship.utils.Logger.step;


public class ProductDetailsTest extends BaseTest {

    @Inject
    SearchBoxPO searchBoxPO;

    @Inject
    ProductDetailsPO productDetailsPO;

    @Inject
    HomePage homePage;

    @Inject
    SearchResultsPO searchResultsPO;

    @BeforeMethod
    public void searchProduct(){
        homePage.open();
        searchBoxPO.search(getTestData().getRandomValue("search.key"));
        searchResultsPO.clickRandomProduct();
    }

    @Test
    public void verifyTweet(){
        productDetailsPO.clickTweet();
        step("Verify twitter window is open");
        switchToWindow();
        assertRelativeNavigation(getTestData().get("twitter.navigation.link"));
        closeWindowsExceptMain();
    }

}
