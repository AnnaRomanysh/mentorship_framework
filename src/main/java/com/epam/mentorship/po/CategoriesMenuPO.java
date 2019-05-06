package com.epam.mentorship.po;

import com.epam.mentorship.core.webelement.Element;

import org.openqa.selenium.support.FindBy;


import static com.epam.mentorship.utils.Logger.*;

import java.util.List;



public class CategoriesMenuPO extends BasePO {


    @FindBy(id = "block_top_menu")
    Element menu;


    @FindBy(css = "ul.menu-content>li>a")
    List<Element> menuCategories;


    @FindBy(xpath = "//*[contains(@class,'menu-content')]//li//li[not (contains(@id,'category-thumbnail')) and not(@class)]")
    List<Element> menuSubCategories;


    @FindBy(xpath = "//*[contains(@class,'menu-content')]//li//li[not (contains(@id,'category-thumbnail')) and not(@class)]")
    List<Element> menuSubItems;


    String link = "ddd";


    public Element getMenuCategoryByName(String categoryName) {
        return menuCategories.stream().filter(el -> el.getAttribute("title").equalsIgnoreCase(categoryName)).findFirst().orElseThrow(() -> new IllegalArgumentException("There is category with name: " + categoryName));
    }

    public Element getMenuCategoryByIndex(int index) {
        Element cat = null;
        try {
            cat = menuCategories.get(index);
        } catch (ArrayIndexOutOfBoundsException ex) {
            error("Index is not correct, valid range is from 0 to " + (menuCategories.size() - 1));
        }

        return cat;
    }

    public  void clickMenu(){
        menu.click();
    }





}
