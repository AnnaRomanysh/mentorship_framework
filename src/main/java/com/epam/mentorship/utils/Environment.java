package com.epam.mentorship.utils;

import java.util.Map;
import java.util.Properties;

public class Environment {

    public Map<String, String> getEnv(){
      return  System.getenv();
    }
    public String getProperty(String propertyKey){
        return System.getProperty(propertyKey);
    }
    public Properties getProperties(String property){
        return System.getProperties();
    }


}
