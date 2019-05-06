package com.epam.mentorship.core.parsers;

import com.epam.mentorship.utils.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private Properties prop;
    private String data;

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

    public String getProperty(String propertyName) {
        data = prop.getProperty(propertyName);
        return data;
    }

}
