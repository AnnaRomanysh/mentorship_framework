package com.epam.mentorship.data;



import static com.epam.mentorship.core.parsers.PropertiesReader.getPageProperties;

public class Data {

    public static String getBaseUrl(){
        return getPageProperties().getProperty("page.base.url");
    }

    public static String getHomePageUrl(){
        return  getPageProperties().getProperty("page.home.relative.url");
    }


}
