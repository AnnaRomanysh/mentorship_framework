package com.epam.mentorship.core.po;

import com.epam.mentorship.core.webelement.Link;
import com.google.inject.Inject;

public class MyAccountPO extends BasePO {

    Link historyLink;
    Link creditSlips;
    Link addresses;
    Link personalInformation;
    Link wishList;

    @Inject
    public MyAccountPO() {
        super();
    }
}
