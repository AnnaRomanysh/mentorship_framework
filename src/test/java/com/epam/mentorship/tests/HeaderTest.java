package com.epam.mentorship.tests;

import com.epam.mentorship.BaseTest;
import com.epam.mentorship.core.pages.ContactUsPage;
import com.epam.mentorship.core.pages.HomePage;
import com.epam.mentorship.core.pages.LoginPage;
import com.epam.mentorship.core.pages.SearchResultsPage;
import com.epam.mentorship.core.po.HeaderPO;
import com.epam.mentorship.core.po.SearchBoxPO;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import static com.epam.mentorship.utils.asserters.Asserter.*;
import static com.epam.mentorship.data.PropertiesData.getTestData;
import static com.epam.mentorship.utils.Logger.step;
import static org.testng.Assert.assertTrue;

public class HeaderTest extends BaseTest {

    @Inject
    private HomePage homePage;

    @Inject
    private HeaderPO headerPO;

    @Inject
    private LoginPage loginPage;

    @Inject
    private ContactUsPage contactUs;

    @Inject
    private SearchBoxPO searchBoxPO;

    @Inject
    private SearchResultsPage searchResultsPage;

    @Test
    public void verifySignInLink() {
        homePage.open();
        headerPO.clickSignInLink();
        step("Verify navigation was done to the Login page: " + loginPage.getPageNavigationLink());
        assertNavigation(loginPage.getPageNavigationLink());
    }

    @Test
    public void verifyLogo() {
        homePage.open();
        step("Verify logo is present");
        assertTrue(headerPO.getLogo().isDisplayed(), "Logo is not present");
        loginPage.open();
        step("Verify click on logo navigates to the Home page");
        headerPO.clickLogo();
        assertNavigation(homePage.getPageNavigationLink());
    }

    @Test
    public void verifyContactUsLink() {
        homePage.open();
        assertDisplayed(headerPO.getContactUsLink(), "Contact us link");
        step("Verify click on Contact us link navigates to the Home page");
        headerPO.clickContactUsLink();
        assertNavigation(contactUs.getPageNavigationLink());
    }

    @Test
    public void verifySearchBox() {
        homePage.open();
        String searchKey = getTestData().getRandomValue("search.key");
        step("Verify Search box");
        searchBoxPO.search(searchKey);
        assertRelativeNavigation(searchResultsPage.getPageNavigationLink());
    }


}
