package com.epam.mentorship.core.po;

import com.epam.mentorship.core.webelement.Link;
import com.google.inject.Inject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static com.epam.mentorship.utils.Wait.waitToBeClickable;

@Getter
public class HeaderPO extends BasePO {

    @FindBy(id = "contact-link")
    Link contactUsLink;

    @FindBy(className = "login")
    Link signInLink;

    @FindBy(className = "logout")
    Link signOutLink;

    @FindBy(className = "account")
    Link accountLink;

    public void clickContactUsLink() {
        contactUsLink.click();
    }

    @Inject
    public HeaderPO() {
        super();
    }

    @Step("Click")
    public void clickSignInLink() {
        waitToBeClickable(signInLink);
        signInLink.clickJS();
    }

    public void clickSignOutLink() {
        signOutLink.click();
    }

    public void clickAccountLinkLink() {
        accountLink.click();
    }

    public String getAccountUserName(){
        return accountLink.getText().trim();
    }

}
