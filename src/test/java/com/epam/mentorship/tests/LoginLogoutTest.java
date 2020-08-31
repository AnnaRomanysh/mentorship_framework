package com.epam.mentorship.tests;

import com.epam.mentorship.BaseTest;
import com.epam.mentorship.businessobject.LoginBO;
import com.epam.mentorship.core.models.User;
import com.epam.mentorship.core.pages.HomePage;
import com.epam.mentorship.core.pages.LoginPage;
import com.epam.mentorship.core.po.ErrorFormBlockPO;
import com.epam.mentorship.core.po.HeaderPO;
import com.epam.mentorship.data.Data;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import static com.epam.mentorship.core.driver.Driver.getDriver;
import static com.epam.mentorship.core.parsers.PropertiesReader.getTestData;
import static com.epam.mentorship.data.Data.getDefaultUser;
import static com.epam.mentorship.utils.Logger.step;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginLogoutTest extends BaseTest {

    @Inject
    private LoginBO loginBO;
    @Inject
    private LoginPage loginPage;
    @Inject
    HomePage homePage;
    @Inject
    public HeaderPO headerPO;
    @Inject
    public ErrorFormBlockPO errorFormBlockPO;


    @Test
    public void verifyLoginButton() {
        homePage.open();
        headerPO.clickSignInLink();
        step("Verify navigation was done to the Login page: " + loginPage.getPageNavigationLink());
        assertEquals(getDriver().getCurrentUrl(), loginPage.getPageNavigationLink(), "Navigation was not done to the correct link");
    }

    @Test
    public void verifyLoginWithUnexistedUser() {
        verifyLoginButton();
        step("Login with unexisted user");
        User user = Data.getUserById(2);
        loginBO.login(user);
        step("Verify error message is displayed");
        assertTrue(errorFormBlockPO.getBlock().isDisplayed(), "Error is not displayed");
        step("Verify error message is correct");
        assertEquals(errorFormBlockPO.getErrorText(), getTestData().get("authentication_expected_error_text"));
    }

    @Test
    public void verifyLoginWithValidCredentials() {
        verifyLoginButton();
        User user = getDefaultUser();
        loginBO.login(user);
        step("Verify user name is correct in a header");
        assertEquals(headerPO.getAccountUserName(), user.getFirstName() + " " + user.getLastName());
    }

    @Test
    public void verifyLogOut() {
        verifyLoginButton();
        User user = getDefaultUser();
        loginBO.login(user);
        headerPO.clickSignOutLink();
        step("Verify user is Logged out");
        assertTrue(headerPO.getSignInLink().isDisplayed(), "Sign in link is not displayed, User is still logged in");
    }

}
