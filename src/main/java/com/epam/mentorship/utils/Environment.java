package com.epam.mentorship.utils;

import com.epam.mentorship.core.driver.Drivers;

import java.util.Objects;
import java.util.Optional;

public class Environment {
    
    public static String getBrowserName(){
      String br= System.getenv("BROWSER");
        return Objects.isNull(br)|| Objects.isNull(Drivers.getDriverType(br)) ? Drivers.CHROME.getDriverValue():br;

    }

    public static boolean isParallel(){
        boolean parallel =  Boolean.parseBoolean(System.getenv("PARALLEL"));
        return Optional.ofNullable(parallel).orElse(false);
    }

    public static String getSuite(){
        String suite = System.getenv("SUITE");
        return Optional.ofNullable(suite).orElse("");

    }

 
}
