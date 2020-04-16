package com.epam.mentorship.po;

import com.epam.mentorship.core.webelement.Element;
import org.openqa.selenium.support.FindBy;


public class CategoriesMenuPO extends BasePO {

//
//    @FindBy(id = "block_top_menu")
//    Element menu;
//


    @FindBy(tagName = "body")
    Element logo;

//    @FindBy(css = "ul.menu-content>li>a")
//    List<Element> menuCategories;
//
//
//    @FindBy(xpath = "//*[contains(@class,'menu-content')]//li//li[not (contains(@id,'category-thumbnail')) and not(@class)]")
//    List<Element> menuSubCategories;
//
//
//    @FindBy(css = ".submenu-container")
//    Element subMenu;

    public void clickOnLogo(){
        logo.click();
    }

//    public Element getMenuCategoryByName(String categoryName) {
//        return menuCategories.stream().filter(el -> el.getAttribute("title").equalsIgnoreCase(categoryName)).findFirst().orElseThrow(() -> new IllegalArgumentException("There is category with name: " + categoryName));
//    }
//
//    public Element getMenuCategoryByIndex(int index) {
//        Element cat = null;
//        try {
//            cat = menuCategories.get(index);
//        } catch (ArrayIndexOutOfBoundsException ex) {
//            error("Index is not correct, valid range is from 0 to " + (menuCategories.size() - 1));
//        }
//
//        return cat;
//    }
//
//    public void clickMenu() {
//        menu.click();
//    }
//
//
//    public boolean isMenuOpen() {
//        return subMenu.getElement().isDisplayed();
//    }

//    public List<Element> getMenusWithSubmenu(){
////        get
//    }


}
