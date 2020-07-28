package com.epam.mentorship.businessobject;

import com.epam.mentorship.core.models.User;
import com.epam.mentorship.core.po.LoginFormPO;
import com.google.inject.Inject;
import io.qameta.allure.Step;

public class LoginBO {

@Inject
LoginFormPO loginFormPO;


    @Step("Login with user : {user.email}")
    public void login(User user){
     loginFormPO
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickSignIn();
    }



}
