package com.epam.mentorship.core.po;

import com.epam.mentorship.core.webelement.Element;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class ErrorFormBlockPO extends BasePO {

    @FindBy(className = "alert-danger")
    Element block;

   public String getErrorText(){
        return block.getText().trim();
    }


}
