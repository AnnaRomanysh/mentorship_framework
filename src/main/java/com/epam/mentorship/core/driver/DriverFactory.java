package com.epam.mentorship.core.driver;


import com.epam.mentorship.core.parsers.PropertiesReader;
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

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;
    private static String browserName;
    private static PropertiesReader propertiesReader;
    private static String CONFIGURATIONS_PROP_PATH = "src//main//resources//driver.properties";

    public WebDriver getDriver() {
        return getDriver(Drivers.getDriverType(setBrowsername()));
    }

    private static Map<Drivers, Supplier<WebDriver>> drivers = new ImmutableMap.Builder<Drivers, Supplier<WebDriver>>()
            .put(IE, () -> {
                System.setProperty("webdriver.ie.driver", propertiesReader.getProperty("ieDriver"));
                return new InternetExplorerDriver();
            })
            .put(CHROME, () -> {
                System.setProperty("webdriver.chrome.driver", propertiesReader.getProperty("chromeDriver"));
                return new ChromeDriver(getChromeOptions());
            })
            .put(FIREFOX, () -> {
                System.setProperty("webdriver.gecko.driver", propertiesReader.getProperty("firefoxDriver"));
                return new FirefoxDriver(getFireFoxOptions());
            })
            .build();


    public static WebDriver getDriver(Drivers type) {
        Logger.info("Running " + type.getDriverValue());
        if (driver == null) {
            driver = drivers.get(type).get();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private static String setBrowsername() {
        propertiesReader = new PropertiesReader(CONFIGURATIONS_PROP_PATH);
        return browserName = propertiesReader.getProperty("browserName");
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }

    private static FirefoxOptions getFireFoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        return firefoxOptions;

    }


}
