package com.epam.mentorship.core.pages;

import com.epam.mentorship.utils.annotations.RelativeUrl;

@RelativeUrl(url = "/index.php?controller=contact")
public class ContactUsPage extends BasePage {

    @Override
    public String getPageName() {
        return "Contact us";
    }


}
