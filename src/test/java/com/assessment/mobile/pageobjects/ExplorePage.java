package com.assessment.mobile.pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ExplorePage extends BasePage {

    private AndroidDriver driver;

    public ExplorePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "android:id/button1")
    private WebElement btn_ok;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/search_container")
    private WebElement txtfield_search_wikipedia;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/search_src_text")
    private WebElement txtfield_search_redirect;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/page_list_item_container") //to confirm the specific search result
    private WebElement lbl_result_search_list_item; //assert search list item

    @AndroidFindBy(id = "org.wikipedia.alpha:id/search_close_btn")
    private WebElement btn_search_close;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/menu_overflow_button")
    private WebElement btn_more_options;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/explore_overflow_settings")
    private WebElement btn_more_options_settings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='org.wikipedia.alpha:id/view_card_header_title' and @text='In the news']")
    private WebElement lbl_first_topic_news;

    // Action methods
    public void clickButtonOk() {
        btn_ok.click();
    }

    public void clickSearchBar() {
        txtfield_search_wikipedia.click();
    }

    public void setTextOnSearchBar(String input) {
        txtfield_search_redirect.sendKeys(input);
    }

    public boolean verifySearchResult() {
        return lbl_result_search_list_item.isDisplayed();
    }

    public void closeSearch() {
        btn_search_close.click();
    }

    public void clickMoreOptions() {
        btn_more_options.click();
    }

    public void clickMenuSettings() {
        btn_more_options_settings.click();
    }

    public boolean verifyFirstTopicNews() {
        return lbl_first_topic_news.isDisplayed();
    }

}