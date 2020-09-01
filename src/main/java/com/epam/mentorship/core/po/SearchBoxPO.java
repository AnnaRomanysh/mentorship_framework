package com.epam.mentorship.core.po;

import com.epam.mentorship.core.webelement.Element;
import com.epam.mentorship.core.webelement.Input;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class SearchBoxPO extends BasePO {

    @FindBy(id = "search_query_top")
    private Input searchInput;

    @FindBy(name = "submit_search")
    private Element searchButton;

    public void typeSearchText(String text){
        searchInput.sendKeys(text);
    }

    public void clickSearch(){
        searchButton.click();
    }

    public void search(String text){
        typeSearchText(text);
        clickSearch();
    }

}
