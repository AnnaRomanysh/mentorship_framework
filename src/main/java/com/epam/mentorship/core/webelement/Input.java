package com.epam.mentorship.core.webelement;

import org.openqa.selenium.WebElement;

public class Input extends Element {

    public Input(WebElement element) {
        super(element);
    }

    public void sendKeys(CharSequence... charSequences) {
        clear();
        getWrappedElement().sendKeys(charSequences);
    }

    public void clear() {
        getWrappedElement().clear();
    }
}
