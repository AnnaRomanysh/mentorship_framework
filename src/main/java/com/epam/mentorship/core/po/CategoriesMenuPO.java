package com.epam.mentorship.core.po;

import com.epam.mentorship.core.webelement.Element;
import com.epam.mentorship.utils.Logger;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CategoriesMenuPO extends BasePO {


    @FindBy(id = "block_top_menu")
    Element menu;


    @FindBy(className = "logo ")
    Element logo;


    @FindBy(css = "ul.menu-content>li>a")
    List<Element> menuCategories;


    @FindBy(xpath = "//*[contains(@class,'menu-content')]//li//li[not (contains(@id,'category-thumbnail')) and not(@class)]")
    List<Element> menuSubCategories;


    @FindBy(css = ".submenu-container")
    Element subMenu;


    public void clickOnLogo() {
        logo.click();
    }

    public Element getMenuCategoryByName(String categoryName) {
        return menuCategories.stream().filter(el -> el.getAttribute("title").equalsIgnoreCase(categoryName)).findFirst().orElseThrow(() -> new IllegalArgumentException("There is category with name: " + categoryName));
    }

    public Element getMenuCategoryByIndex(int index) {
        Element cat = null;
        try {
            cat = menuCategories.get(index);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.error("Index is not correct, valid range is from 0 to " + (menuCategories.size() - 1));
        }

        return cat;
    }

    public void clickMenu() {
        menu.click();
    }


    public boolean isMenuOpen() {
        return subMenu.getElement().isDisplayed();
    }


}
