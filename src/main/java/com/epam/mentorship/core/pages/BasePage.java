package com.epam.mentorship.core.pages;

import com.epam.mentorship.core.driver.Driver;
import com.epam.mentorship.utils.Wait;
import com.epam.mentorship.utils.annotations.RelativeUrl;

import java.lang.annotation.Annotation;
import java.util.Optional;

import static com.epam.mentorship.data.PropertiesData.getPageProperties;
import static com.epam.mentorship.utils.Logger.step;

public abstract class BasePage implements IPage {


    @Override
    public void open() {
        step("Open: " + getPageName() + " by link: "+getPageNavigationLink());
        Driver.getDriver().get(getPageNavigationLink());
        Wait.waitForPageLoad();
    }

    public abstract String getPageName();

    public String getPageNavigationLink(){
        return getPageProperties().get("page.base.url") +  getPageRelativePath();
    }

    public String getPageRelativePath() {
        Annotation annotation = this.getClass().getAnnotation(RelativeUrl.class);
        return Optional.ofNullable(annotation).isPresent() ? ((RelativeUrl) annotation).url() : " ";
    }


}
