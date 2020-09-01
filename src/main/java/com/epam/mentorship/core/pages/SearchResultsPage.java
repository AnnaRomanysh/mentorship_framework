package com.epam.mentorship.core.pages;

import com.epam.mentorship.utils.annotations.RelativeUrl;

@RelativeUrl(url = "/index.php?controller=search")
public class SearchResultsPage extends BasePage {

    @Override
    public String getPageName() {
        return "Search results page";
    }
}
