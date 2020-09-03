package com.epam.mentorship.utils.parsers;

import com.epam.mentorship.utils.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class PropertiesReader {

    private static String propertiesLocation = "src//main//resources";

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

    public static PropertiesReader getProperties(String propertyFilePath) {
        return new PropertiesReader(propertiesLocation + propertyFilePath);
    }

    public String get(String name) {
        return this.prop.getProperty(name);
    }

    public List<String> getList(String name) {
        return Arrays.stream(get(name).split(";")).filter(el -> !el.isEmpty()).collect(Collectors.toList());
    }

    public String getRandomValue(String name) {
        return  getList(name).stream().findAny().orElseThrow(()->new IllegalArgumentException(String.format("There is no property with name: %s", name)));
    }


}
