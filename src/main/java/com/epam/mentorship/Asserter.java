package com.epam.mentorship;

import com.epam.mentorship.core.webelement.Element;

import static com.epam.mentorship.core.driver.Driver.getDriver;
import static com.epam.mentorship.utils.Logger.step;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Asserter {

    public static void assertNavigation(String expectedLink){
        assertEquals(getDriver().getCurrentUrl(), expectedLink, "Navigation was not done to the correct link");
    }

    public static void assertNavigation(String expectedLink, String message){
        assertEquals(getDriver().getCurrentUrl(), expectedLink, message);
    }

    public static void assertDisplayed(Element element, String elementName){
        step(String.format("Verify %s is present", elementName));
        assertTrue(element.isDisplayed(),String.format("%s is not present", elementName));
    }
}
