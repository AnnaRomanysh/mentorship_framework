package com.epam.mentorship.core.po;

import com.epam.mentorship.core.webelement.Element;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Getter
public class SearchResultsPO extends BasePO {

    @FindBy(className = "product-image-container")
    public List<Element> products;


    public void clickRandomProduct(){
        List <Element> pr = products.stream().filter(el->el.isDisplayed()).collect(Collectors.toList());
        Element random = pr.get(new Random().nextInt(pr.size()));
        random.scrollIntoView();
        random.hover();
        random.click();
    }

}
