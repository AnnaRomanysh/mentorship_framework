package com.epam.mentorship.core.driver;

import org.openqa.selenium.SearchContext;

public interface DriverProvider {

   SearchContext getDriver();
}
