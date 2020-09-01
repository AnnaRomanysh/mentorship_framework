package com.epam.mentorship.core.po;

import com.epam.mentorship.core.webelement.Element;
import com.epam.mentorship.core.webelement.Link;
import com.google.inject.Inject;
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

    @FindBy(id = "header_logo")
    Element logo;

    @FindBy(className = "shopping_cart")
    Element cart;

    public void clickContactUsLink() {
        contactUsLink.click();
    }

    @Inject
    public HeaderPO() {
        super();
    }


    public void clickSignInLink() {
        waitToBeClickable(signInLink);
        signInLink.click();
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

    public void clickLogo(){
        logo.click();
    }

}
