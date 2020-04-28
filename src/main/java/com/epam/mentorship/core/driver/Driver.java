package com.epam.mentorship.core.driver;

import com.epam.mentorship.utils.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class Driver {

    private static DriverFactory drivers = new DriverFactory();
    private static final ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();

    private Driver(){

    }

public static WebDriver getDriver() {
//    if (DRIVER_POOL.get() == null) {
//        DRIVER_POOL.set(drivers.getDriver());
//    }
    return DRIVER_POOL.get();
}


public static void setDriver() {
        DRIVER_POOL.set(drivers.getDriver());

}

    public static void quit() {
        Logger.info("Closing  browser");
        if (DRIVER_POOL.get() != null) {
            DRIVER_POOL.get().quit();
            DRIVER_POOL.remove();
        }
    }

    public static void get(String url) {
        Logger.info("Go to the URL: " + url);
        getDriver().get(url);
    }
    public static String getCurrentUrl() {
        return DRIVER_POOL.get().getCurrentUrl();

    }

    public static void close() {
        Logger.info("Closing tab:" + DRIVER_POOL.get().getTitle());
        DRIVER_POOL.get().close();

    }

    public static String getTitle() {
        return DRIVER_POOL.get().getTitle();

    }

    public static WebDriver.Options manage() {
        return DRIVER_POOL.get().manage();

    }

    public static WebDriver.Navigation navigate() {
        return DRIVER_POOL.get().navigate();

    }

    public static WebDriver.TargetLocator switchTo() {
        return DRIVER_POOL.get().switchTo();

    }

    public static Actions actions() {
        return new Actions(DRIVER_POOL.get());
    }


    public static Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) DRIVER_POOL.get()).executeScript(script, args);
    }


}

