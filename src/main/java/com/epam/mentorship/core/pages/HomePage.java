package com.epam.mentorship.core.pages;

import com.epam.mentorship.core.annotations.RelativeUrl;


@RelativeUrl(url = "/index.php")
public class HomePage extends BasePage {

    @Override
    public String getPageName() {
        return "Home Page";
    }

}
