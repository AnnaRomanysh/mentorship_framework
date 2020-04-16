package com.epam.mentorship.utils;

import com.epam.mentorship.core.driver.Driver;
import com.epam.mentorship.core.webelement.Element;
import com.google.common.base.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.Callable;
import static com.epam.mentorship.utils.Logger.*;

public class Wait {

    private static final int ONE_SECOND = 1000;
    private static final int DEFAULT_TIMEOUT = 30;


    public static void waitForCondition(Callable<Boolean> callable, int timeout) {
        long beginTime = System.currentTimeMillis();
        boolean continueWaiting = true;
        while (continueWaiting && ((System.currentTimeMillis() - beginTime) < timeout * ONE_SECOND)) {
            {
                try {
                    if (callable.call()) {
                        continueWaiting = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static Object ajaxWait(Callable<Boolean> callable) {
       boolean wait = false;
        try {
            wait = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
       final boolean waitRequested= wait;
        final WebDriverWait driverWait = new WebDriverWait(Driver.getDriver(), DEFAULT_TIMEOUT);
        try {
            final Object result = driverWait
                    .until((Function<WebDriver, Object>) webDriver -> !waitRequested || (Boolean) Driver.executeScript("return window.jQuery != undefined && jQuery.active === 0"));
            return result;
        } catch (Exception e) {
           error("Problem with ajaxWait.");
        }
        return null;
    }

    public static void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) Driver.getDriver()).executeScript("return document.readyState").equals("complete");
        new WebDriverWait(Driver.getDriver(), DEFAULT_TIMEOUT).until(pageLoadCondition);
    }

    public static void waitToBeClickable(Element element) {
        new WebDriverWait(Driver.getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void waitToBeClickable(int timeout, Element element) {
        new WebDriverWait(Driver.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void waitToBeVisible(Element element) {
        new WebDriverWait(Driver.getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));

    }

    public static void waitToBeVisible(int timeout, Element element) {
        new WebDriverWait(Driver.getDriver(), timeout).until(ExpectedConditions.visibilityOf(element));
    }

}
