package com.epam.mentorship.core.injector;

import com.epam.mentorship.core.pages.HomePage;
import com.epam.mentorship.core.po.CategoriesMenuPO;
import com.epam.mentorship.core.po.HeaderPO;
import com.google.inject.AbstractModule;


public class Injector extends AbstractModule {


    @Override
    protected void configure() {
        bind(CategoriesMenuPO.class);
        bind(HomePage.class);
        bind(HeaderPO.class);
    }


}
