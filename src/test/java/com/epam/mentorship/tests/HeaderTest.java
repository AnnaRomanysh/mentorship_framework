package com.epam.mentorship.tests;

import com.epam.mentorship.BaseTest;
import com.epam.mentorship.core.pages.ContactUsPage;
import com.epam.mentorship.core.pages.HomePage;
import com.epam.mentorship.core.pages.LoginPage;
import com.epam.mentorship.core.po.HeaderPO;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import static com.epam.mentorship.Asserter.assertDisplayed;
import static com.epam.mentorship.Asserter.assertNavigation;
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
        assertTrue(headerPO.getLogo().isDisplayed(),"Logo is not present");
        loginPage.open();
        step("Verify click on logo navigates to the Home page");
        headerPO.clickLogo();
        assertNavigation(homePage.getPageNavigationLink());
    }

    @Test
    public void verifyContactUsLink() {
        homePage.open();
        contactUs.open();
        step("Verify Contact us link is present");
        assertDisplayed(headerPO.getContactUsLink(), "Contact us link");
        step("Verify click on Contact us link navigates to the Home page");
        headerPO.clickContactUsLink();
        assertNavigation(contactUs.getPageNavigationLink());
    }


}
