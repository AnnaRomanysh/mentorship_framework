package com.epam.mentorship.core.driver;

import com.epam.mentorship.utils.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class Driver {

    private static DriverFactory drivers = new DriverFactory();
    private static WebDriver driver;
    private static final ThreadLocal<WebDriver> pool = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return pool.get() != null ? pool.get() : setDriver();
    }

    private static WebDriver setDriver() {
        driver = drivers.getDriver();
        pool.set(driver);
        return driver;
    }

    public static void quit() {
        Logger.info("Closing  browser");
        driver.quit();
    }

    public static void get(String url) {
        Logger.info("Go to the URL: " + url);
        getDriver().get(url);
    }
    public static String getCurrentUrl() {
        return driver.getCurrentUrl();

    }

    public static void close() {
        Logger.info("Closing tab:" + driver.getTitle());
        driver.close();

    }

    public static String getTitle() {
        return driver.getTitle();

    }

    public static WebDriver.Options manage() {
        return driver.manage();

    }

    public static WebDriver.Navigation navigate() {
        return driver.navigate();

    }

    public static WebDriver.TargetLocator switchTo() {
        return driver.switchTo();

    }

    public static Actions actions() {
        return new Actions(driver);
    }


    public static Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }


}

