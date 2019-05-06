package com.epam.mentorship.core.webelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static com.epam.mentorship.utils.Logger.*;

public class DropDown extends Element {

    public DropDown(WebElement webElement) {
        super(webElement);
    }

    public boolean isMultiple() {
        return new Select(getElement()).isMultiple();

    }

    public void deselectAll() {
        info("Deselect dropdown");
        new Select(getElement()).deselectAll();
    }

    public void selectByValue(String value) {
        info("Select dropdown value: " + value);
        new Select(getElement()).selectByValue(value);
    }

    public void deselectByValue(String value) {
        info("Deselect dropdown value: " + value);
        new Select(getElement()).deselectByValue(value);
    }

    public void selectByIndex(int index) {
        info("Select dropdown by index: " + index);
        new Select(getElement()).selectByIndex(index);
    }

    public void deselectByIndex(int index) {
        info("Deselect dropdown by index: " + index);
        new Select(getElement()).deselectByIndex(index);
    }

    public void selectByVisibleText(String text) {
        info("Select dropdown by test: " + text);
        new Select(getElement()).selectByVisibleText(text);
    }

    public void deselectByVisibleText(String text) {
        info("Deselect dropdown by test: " + text);
        new Select(getElement()).deselectByVisibleText(text);
    }

    public boolean isSelected() {
        return (getElement()).isSelected();
    }

    public List<WebElement> getOptions() {
        return new Select(getElement()).getOptions();
    }

    public boolean isSelectType() {
        return getElement().getTagName().equalsIgnoreCase("Select");
    }


}
