package com.epam.mentorship.po;

import com.epam.mentorship.core.driver.Driver;
import com.epam.mentorship.core.webelement.FieldDecorator;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePO{


    @Inject
    public BasePO(WebDriver driver){
//        PageFactory.initElements(new FieldDecorator(Driver.getDriver()), this);
        PageFactory.initElements(new FieldDecorator(driver), this);
    }


}

