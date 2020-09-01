package com.epam.mentorship.utils.allure;

import com.epam.mentorship.utils.Environment;
import com.epam.mentorship.utils.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class AllureEnvironment {

    private static final String ALLURE_RESULTS = "allure-results/";
    private static final String ALLURE_ENVIRONMENT_PATH = ALLURE_RESULTS + "environment.properties";
    private static Properties properties;

    private AllureEnvironment() {
    }

    public static void createAllureEnvironmentProperties() {
        properties = new Properties();
        setBrowser();
        setSuite();
        setParallel();
        try {
            File f = new File(ALLURE_ENVIRONMENT_PATH);
            OutputStream out = new FileOutputStream(f);
            properties.store(out, "Add properties to the file");
        } catch (IOException e) {
            Logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void set(String propertyName, String propertyValue) {
        if (propertyValue != null && !propertyValue.isEmpty())
            properties.setProperty(propertyName, propertyValue);
    }

    private static void setBrowser() {
        set("Browser", Environment.getBrowserName());
    }

    private static void setSuite() {
        set("Suite", Environment.getSuite());
    }

    private static void setParallel() {
        set("is parallel", String.valueOf(Environment.isParallel()));
    }

}
