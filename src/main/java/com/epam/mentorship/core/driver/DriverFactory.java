package com.epam.mentorship.core.driver;


import com.epam.mentorship.utils.Logger;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.epam.mentorship.core.driver.Drivers.*;
import static com.epam.mentorship.core.parsers.PropertiesReader.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private  WebDriver driver;

    public WebDriver getDriver() {
        return getDriver(Drivers.getDriverType(setBrowsername()));
    }


//    private static Map<Drivers, Supplier<WebDriver>> drivers = new ImmutableMap.Builder<Drivers, Supplier<WebDriver>>()
//            .put(IE, () -> {
//                System.setProperty("webdriver.ie.driver", getDriverProperties().getProperty("ieDriver"));
//                return new InternetExplorerDriver();
//            })
//            .put(CHROME, () -> {
//                System.setProperty("webdriver.chrome.driver", getDriverProperties().getProperty("chromeDriver"));
//                return new ChromeDriver(getChromeOptions());
//            })
//            .put(FIREFOX, () -> {
//                System.setProperty("webdriver.gecko.driver", getDriverProperties().getProperty("firefoxDriver"));
//                return new FirefoxDriver(getFireFoxOptions());
//            })
//            .build();

    private synchronized WebDriver getDriver (Drivers drivers) {
        switch (drivers) {
            case IE:
                System.setProperty("webdriver.ie.driver", getDriverProperties().getProperty("ieDriver"));
                driver = new InternetExplorerDriver();
            break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", getDriverProperties().getProperty("chromeDriver"));
                driver = new ChromeDriver(getChromeOptions());
            break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", getDriverProperties().getProperty("firefoxDriver"));
                driver = new FirefoxDriver(getFireFoxOptions());
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }



//    public static WebDriver getDriver(Drivers type) {
//        Logger.info("Running " + type.getDriverValue());
//         driver = drivers.get(type).get();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        return driver;
//    }

    private String setBrowsername() {
        return getDriverProperties().getProperty("browserName");
    }

    private  ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }

    private  FirefoxOptions getFireFoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        return firefoxOptions;

    }


}
