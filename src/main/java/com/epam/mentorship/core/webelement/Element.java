package com.epam.mentorship.core.webelement;

import com.epam.mentorship.core.driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Element implements IElement {

    protected final WebElement element;

    public Element(WebElement element) {
        this.element = element;
    }

    protected void error(String message) {
        error(message);
    }

    public Element getElement() {
        return new Element(element);
    }

    public List<Element> getElements(By by) {
        List<Element> elements = new ArrayList<>();
        List<WebElement> foundElements = getElement().findElements(by);
        foundElements.forEach(el -> elements.add(new Element(el)));
        return elements;
    }

    public void click() {
        element.click();
    }

    public void clickJS(){Driver.executeScript("arguments[0].click();", element);}

    public void submit() {
        element.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    public void clear() {
        element.clear();
    }

    public String getTagName() {
        return element.getTagName();
    }

    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }

    public String getText() {
        return element.getText();
    }

    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public Point getLocation() {
        return element.getLocation();
    }

    public Dimension getSize() {
        return element.getSize();
    }

    public Rectangle getRect() {
        return element.getRect();
    }

    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }

    public Coordinates getCoordinates() {
        return (Coordinates) getElement().getLocation();
    }

    public WebElement getWrappedElement() {
        return getElement();
    }

    public void scrollIntoView() {
        Driver.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void hover() {
        Driver.actions().moveToElement(getElement()).perform();
    }


    public void hoverJS() {
        if (getElement().isEnabled()) {
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
            Driver.executeScript(mouseOverScript, element);
        } else {
            error("Element was not visible to hover " + "\n");
        }
    }


}
