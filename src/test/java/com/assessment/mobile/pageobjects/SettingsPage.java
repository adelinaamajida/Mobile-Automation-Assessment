package com.assessment.mobile.pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends BasePage {

    private AndroidDriver driver;

    public SettingsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Set Elements on each task
    @AndroidFindBy(xpath = "(//android.widget.Switch[@resource-id='org.wikipedia.alpha:id/switchWidget'])[1]")
    private WebElement toggle_settings_show_images;

    @AndroidFindBy(xpath = "(//android.widget.Switch[@resource-id='org.wikipedia.alpha:id/switchWidget'])[2]")
    private WebElement toggle_settings_show_link_previews;

    @AndroidFindBy(xpath = "(//android.widget.Switch[@resource-id='org.wikipedia.alpha:id/switchWidget'])[3]")
    private WebElement toggle_settings_send_usage_reports;

    @AndroidFindBy(xpath = "(//android.widget.Switch[@resource-id='org.wikipedia.alpha:id/switchWidget'])[4]")
    private WebElement toggle_settings_send_crash_reports;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement btn_settings_back_to_explore_page;

    //Action Method
    public void switchToggleShowImages() {
        toggle_settings_show_images.click();
    }

    public void switchToggleLinkPreviews() {
        toggle_settings_show_link_previews.click();
    }

    public void switchToggleSendUsageReports() {
        toggle_settings_send_usage_reports.click();
    }

    public void switchToggleSendCrashReports() {
        toggle_settings_send_crash_reports.click();
    }

    public void backToExplorePage() {
        btn_settings_back_to_explore_page.click();
    }
}
