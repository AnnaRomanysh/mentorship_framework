package com.epam.mentorship.core.po;

import com.epam.mentorship.core.driver.Driver;
import com.epam.mentorship.core.webelement.FieldDecorator;
import com.google.inject.Inject;
import org.openqa.selenium.support.PageFactory;


public  class BasePO{

    @Inject
    public BasePO(){
        PageFactory.initElements(new FieldDecorator(Driver::getDriver), this);
    }


}

