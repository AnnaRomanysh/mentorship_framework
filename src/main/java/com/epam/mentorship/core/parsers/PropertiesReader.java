package com.epam.mentorship.core.parsers;

import com.epam.mentorship.utils.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static String propertiesLocation = "src//main//resources";
    private static String pageProperties = "//pages.properties";
    private static String driverProperties = "//driver.properties";
    private Properties prop;


    public PropertiesReader(String propertiesFilePath) {
        prop = new Properties();
        File file = new File(propertiesFilePath);
        FileInputStream reader = null;
        try {
            reader = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            Logger.error("Could not find a file: " + e.getMessage());
        }
        try {
            prop.load(reader);
        } catch (IOException e) {
            Logger.error("Could not read a file: " + e.getMessage());
        }

    }

    private static PropertiesReader getProperties(String propertyFilePath) {
        return new PropertiesReader(propertiesLocation + propertyFilePath);
    }

    public static PropertiesReader getDriverProperties() {
        return getProperties(driverProperties);
    }

    public static PropertiesReader getPageProperties() {
        return getProperties(pageProperties);
    }

    public String getProperty(String name) {
        return this.prop.getProperty(name);
    }

}
