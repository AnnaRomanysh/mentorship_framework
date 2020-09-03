package com.epam.mentorship.core.driver;


import com.epam.mentorship.utils.Environment;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.epam.mentorship.core.driver.Drivers.*;
import static com.epam.mentorship.data.PropertiesData.getDriverProperties;


public class DriverFactory {

    private static int DEFAULT_IMPLICITY = 10;


    public WebDriver getDriver() {
        WebDriver driver = drivers.get(getBrowser()).get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITY, TimeUnit.SECONDS);
        return driver;
    }


    private Map<Drivers, Supplier<WebDriver>> drivers = new ImmutableMap.Builder<Drivers, Supplier<WebDriver>>()
            .put(CHROME, () -> {
                System.setProperty("webdriver.chrome.driver", getDriverProperties().get("chromeDriver"));
                return new ChromeDriver(getChromeOptions());
            })
            .put(FIREFOX, () -> {
                System.setProperty("webdriver.gecko.driver", getDriverProperties().get("firefoxDriver"));
                return new FirefoxDriver(getFireFoxOptions());
            })
            .put(IE, () -> {
                System.setProperty("webdriver.ie.driver", getDriverProperties().get("ieDriver"));
                return new InternetExplorerDriver(getInternetExplorerOptions());
            })
            .build();


    private static Drivers getBrowser() {
        return Drivers.getDriverType(Environment.getBrowserName());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }

    private FirefoxOptions getFireFoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        return firefoxOptions;

    }

    private InternetExplorerOptions getInternetExplorerOptions() {
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.destructivelyEnsureCleanSession();
        internetExplorerOptions.disableNativeEvents();
        internetExplorerOptions.ignoreZoomSettings();
        return internetExplorerOptions;

    }

}
