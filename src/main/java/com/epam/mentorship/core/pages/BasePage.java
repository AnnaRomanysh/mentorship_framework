package com.epam.mentorship.core.pages;

import com.epam.mentorship.core.annotations.RelativeUrl;
import com.epam.mentorship.core.driver.Driver;
import com.epam.mentorship.utils.Logger;
import com.epam.mentorship.utils.Wait;

import java.lang.annotation.Annotation;
import java.util.Optional;

import static com.epam.mentorship.core.parsers.PropertiesReader.getPageProperties;

public abstract class BasePage implements IPage {


    @Override
    public void open() {
        Logger.step("Open: " + getPageName() + " by link: "+getPageNavigationLink());
        Driver.get(getPageNavigationLink());
        Wait.waitForPageLoad();
    }

    public abstract String getPageName();

    public String getPageNavigationLink(){
        return getPageProperties().getProperty("page.base.url") +  getPageRelativePath();
    }

    public String getPageRelativePath() {
        Annotation annotation = this.getClass().getAnnotation(RelativeUrl.class);
        return Optional.ofNullable(annotation).isPresent() ? ((RelativeUrl) annotation).url() : " ";
    }


}
