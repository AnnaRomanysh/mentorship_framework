package com.epam.mentorship.core.webelement;

import org.openqa.selenium.WebElement;

public class Link extends Element {

    public Link(WebElement webElement) {
        super(webElement);
    }

    public String getNavigationLink(){
       return getElement().getAttribute("href");
    }
}
