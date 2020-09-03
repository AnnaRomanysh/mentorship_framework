package com.epam.mentorship.core.po;

import com.epam.mentorship.core.webelement.Element;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProductDetailsPO extends BasePO {

    @FindBy(tagName = "h1")
    private Element title;

    @FindBy(css = "#image-block img")
    private Element mainImage;

    @FindBy(css = "#thumbs_list img")
    private Element imageCarousel;

    @FindBy(className = "icon-twitter")
    private Element twitterButton;

    @FindBy(className = "icon-facebook")
    private Element facebookButton;

    @FindBy(className = "icon-google-plus")
    private Element googleButton;

    @FindBy(className = "icon-pinterest")
    private Element pinterestButton;

    @FindBy(id = "send_friend_button")
    private Element sendAFriendButton;

    @FindBy(className = ".print")
    private Element printButton;


    public String getTitle() {
        return title.getText().trim();
    }

    public void clickTweet() {
        twitterButton.click();
    }

    public void clickShareFacebook() {
        facebookButton.click();
    }

    public void clickGoogle() {
        googleButton.click();
    }

    public void clickPinterest() {
        pinterestButton.click();
    }

    public void clickSendAFriend() {
        sendAFriendButton.click();
    }

    public void clickPrint() {
        printButton.click();
    }


}
