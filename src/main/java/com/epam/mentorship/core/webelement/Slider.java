package com.epam.mentorship.core.webelement;

import com.epam.mentorship.core.driver.Driver;
import org.openqa.selenium.WebElement;


public class Slider extends Element {

    public Slider(WebElement webElement) {
        super(webElement);
    }

    public void moveTo(WebElement toElement) {
        Driver.actions().dragAndDrop(getElement(), toElement).perform();

    }

    public void moveByCoorginats(int xOffSet, int yOffSet) {
        Driver.actions().dragAndDropBy(getElement(), xOffSet, yOffSet).perform();

    }

}
