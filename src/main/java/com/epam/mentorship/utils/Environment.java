package com.epam.mentorship.utils;

import com.epam.mentorship.core.driver.Drivers;

import java.util.Objects;

public class Environment {
    
    public static String getBrowserName(){
      String br= System.getenv("BROWSER");
        return Objects.isNull(br)|| Objects.isNull(Drivers.getDriverType(br)) ?Drivers.CHROME.getDriverValue():br;

    }
    
 
}
