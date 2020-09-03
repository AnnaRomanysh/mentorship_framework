package com.epam.mentorship.data;

import com.epam.mentorship.utils.parsers.PropertiesReader;

import static com.epam.mentorship.utils.parsers.PropertiesReader.getProperties;

public class PropertiesData {

    private static String pageProperties = "//pages.properties";
    private static String driverProperties = "//driver.properties";
    private static String testDataProperties = "//testdata/data.properties";

    public static PropertiesReader getDriverProperties() {
        return getProperties(driverProperties);
    }

    public static PropertiesReader getTestData() {
        return getProperties(testDataProperties);
    }

    public static PropertiesReader getPageProperties() {
        return getProperties(pageProperties);
    }

}
