package com.epam.mentorship.core.pages;


import com.epam.mentorship.utils.annotations.RelativeUrl;

@RelativeUrl(url = "/index.php?controller=authentication&back=my-account")
public class LoginPage extends BasePage {

    @Override
    public String getPageName() {
        return "Login Page";
    }

}
