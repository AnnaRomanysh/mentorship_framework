package com.epam.mentorship.core.injector;

import com.epam.mentorship.core.driver.Driver;
import com.epam.mentorship.core.pages.BasePage;
import com.epam.mentorship.core.pages.HomePage;
import com.epam.mentorship.core.webelement.Element;
import com.epam.mentorship.core.webelement.FieldDecorator;
import com.epam.mentorship.core.webelement.IElement;
import com.epam.mentorship.po.BasePO;
import com.epam.mentorship.po.CategoriesMenuPO;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.util.Providers;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;


public class Injector extends AbstractModule {


    @Override
    protected void configure() {
//        bind(DefaultFieldDecorator.class).to(FieldDecorator.class);
//        bind(IElement.class).to(Element.class);
//        bind(WebDriver.class).toProvider(Providers.of(getDriver()));
//        bind(BasePO.class).to(CategoriesMenuPO.class);
//        bind(BasePage.class).to(HomePage.class);
//        final WebDriver webDriverManager = Driver.getDriver();
//        bind(WebDriver.class).toProvider(webDriverManager);
    }

    @Provides
    public WebDriver getDriver(Driver driver) {
        return driver.getDriver();
    }

//class DriverProvider {
//    DriverProvider
//}

}
