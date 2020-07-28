package com.epam.mentorship.core.driver;

import com.epam.mentorship.utils.Logger;
import com.google.inject.Inject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class Driver {

    private  static Driver driver = null;
//    private static  ;
 static ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal();
static WebDriver webDriver;

@Inject
    private Driver(){

    }

    public  static WebDriver  getDriver(){
        if(DRIVER_POOL.get()==null){
            setDriver();
        }
        return DRIVER_POOL.get();
    }

    public static final void setDriver(){
        DriverFactory driverFactory = new DriverFactory();
        DRIVER_POOL.set(driverFactory.getDriver());
//        System.setProperty("webdriver.chrome.driver", getDriverProperties().get("chromeDriver"));
//        DRIVER_POOL.set(new ChromeDriver());
    }



//    public static void quit() {
//        Logger.info("Closing  browser");
//        if (DRIVER_POOL.get() != null) {
//            DRIVER_POOL.get().quit();
//            DRIVER_POOL.remove();
//        }
//    }

    public  void get(String url) {
        Logger.info("Go to the URL: " + url);
        getDriver().get(url);
    }
//    public static String getCurrentUrl() {
//        return getDriver().getCurrentUrl();
//
//    }

//    public static void close() {
//        Logger.info("Closing tab:" +getDriver().getTitle());
//        getDriver().close();
//
//    }

    public static String getTitle() {
        return getDriver().getTitle();

    }

    public static WebDriver.Options manage() {
        return getDriver().manage();

    }

    public static  WebDriver.Navigation navigate() {
        return getDriver().navigate();

    }

    public static WebDriver.TargetLocator switchTo() {
        return getDriver().switchTo();

    }

    public static Actions actions() {
        return new Actions(getDriver());
    }


    public static Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) getDriver()).executeScript(script, args);
    }

    public static void terminate(){
        DRIVER_POOL.remove();
    }


}

