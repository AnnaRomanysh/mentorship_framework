package com.epam.mentorship.core.po;

import com.epam.mentorship.core.webelement.Element;
import com.epam.mentorship.core.webelement.Input;
import com.epam.mentorship.core.webelement.Link;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginFormPO extends BasePO{

    @FindBy(id = "email")
    Input emailField;

    @FindBy(id = "passwd")
    Input passwordField;

    @FindBy(className = "lost_password ")
    Link forgotPasswordLinkField;

    @FindBy(id = "SubmitLogin")
    Element signInButtonField;


    public LoginFormPO fillEmailField(String email) {
        emailField.waitVisible();
        emailField.sendKeys(email);
        return this;
    }

    public LoginFormPO fillPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void clickForgotPassword() {
        forgotPasswordLinkField.click();
    }

    public void clickSignIn() {
        signInButtonField.click();
    }
}
