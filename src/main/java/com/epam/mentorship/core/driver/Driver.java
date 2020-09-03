package com.epam.mentorship.core.driver;

import com.google.inject.Inject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;

import java.util.Optional;
import java.util.Set;

import static com.epam.mentorship.utils.Logger.error;
import static com.epam.mentorship.utils.Logger.info;


public class Driver {

    private static Driver driver = null;
    static ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal();

    @Inject
    private Driver() {

    }

    public static WebDriver getDriver() {
        if (DRIVER_POOL.get() == null) {
            setDriver();
        }
        return DRIVER_POOL.get();
    }

    public static final void setDriver() {
        DriverFactory driverFactory = new DriverFactory();
        DRIVER_POOL.set(driverFactory.getDriver());
    }


    public void get(String url) {
        info("Go to the URL: " + url);
        getDriver().get(url);
    }

    public static String getTitle() {
        return getDriver().getTitle();

    }

    public static WebDriver.Options manage() {
        return getDriver().manage();

    }

    public static WebDriver.Navigation navigate() {
        return getDriver().navigate();

    }

    public static WebDriver.TargetLocator switchTo() {
        return getDriver().switchTo();
    }

    public static void switchToWindow() {
        String currentHandle = getDriver().getWindowHandle();
        Set<String> handles = getDriver().getWindowHandles();
        handles.remove(currentHandle);
        if (handles.size() > 0)
            getDriver().switchTo().window(handles.iterator().next());
    }

    public static void closeWindowsExceptMain() {
        info("Close remaning windows");
        try {
            Set<String> windows = getDriver().getWindowHandles();
            String firstTab = windows.stream().findFirst().get();
            windows.stream().filter(window -> !window.equalsIgnoreCase(firstTab)).forEach(window -> getDriver().switchTo().window(window).close());
            String window = Optional.of(firstTab).orElse(getDriver().getWindowHandles().stream().findFirst().get());getDriver().switchTo().window(window);
        }
        catch (WebDriverException e){
            error("Can't close the window: "+e );
        }
    }

    public static Actions actions() {
        return new Actions(getDriver());
    }


    public static Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) getDriver()).executeScript(script, args);
    }

    public static void terminate() {
        DRIVER_POOL.remove();
    }


}

