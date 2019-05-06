package com.epam.mentorship.po;

import com.epam.mentorship.core.driver.Driver;
import com.epam.mentorship.core.webelement.FieldDecorator;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePO{


    public BasePO(){
        PageFactory.initElements(new FieldDecorator(Driver.getDriver()), this);
    }


}

