package com.epam.mentorship.core.driver;

public enum  Drivers {

    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("iexplorer"),
    REMOTE__DRIVER("remote");


    private String driverValue;

    Drivers(String driverValue) {
        this.driverValue = driverValue;
    }

    public static Drivers getDriverType(String driverValue) {
        for (Drivers drivers : Drivers.values()) {
            if (drivers.getDriverValue().equalsIgnoreCase(driverValue)) {
                return drivers;
            }
        }
        return null;
    }

    public String getDriverValue() {
        return driverValue;
    }

}
