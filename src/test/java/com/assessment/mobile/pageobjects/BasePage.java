package com.assessment.mobile.pageobjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage {
    private AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("Driver is null.");
        }
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Each elements in bottom menu
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Explore']")
    private WebElement btn_explore;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='My lists']")
    private WebElement btn_mylists;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='My lists'])[2]")
    private WebElement lbl_mylists_title;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='History']")
    private WebElement btn_history;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='History'])[2]")
    private WebElement lbl_history_title;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Nearby']")
    private WebElement btn_nearby;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Nearby'])[2]")
    private WebElement lbl_nearby_title;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/search_container")
    private WebElement txtfield_search_wikipedia;

    //Action method
    public void navigateToExplore() {
        btn_explore.click();
    }
    public void navigateToMyLists() {
        btn_mylists.click();
        boolean isDisplayed = lbl_mylists_title.isDisplayed();
        if(!isDisplayed) {
            Assert.fail("Failed to navigate to page My Lists");
        }
    }

    public void navigateToHistory() {
        btn_history.click();
        lbl_history_title.isDisplayed();
        boolean isDisplayed = lbl_history_title.isDisplayed();
        if(!isDisplayed) {
            Assert.fail("Failed to navigate to page History");
        }
    }

    public void navigateToNearby() {
        btn_nearby.click();
        lbl_nearby_title.isDisplayed();
        boolean isDisplayed = lbl_nearby_title.isDisplayed();
        if(!isDisplayed) {
            Assert.fail("Failed to navigate to page Nearby");
        }
    }

    public void scrollDownToBottom() {
        boolean isAtBottom = false;
        int scrollTime = 0;
        while (!isAtBottom) {
            // Scroll down using UiScrollable
            WebElement scrollElement = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"
            ));
            scrollTime++;
            // Check if scrolling results in a change in position
            // set max number of scroll to 7 due to infinite scrolling
            if (scrollElement == null || scrollTime >= 7) {
                isAtBottom = true;
            }
        }
    }
    public void scrollUpToTop() {
        boolean isAtTop = false;

        while (!isAtTop) {
            try {
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward();"
                ));

                isAtTop = isAtTopPosition();
            } catch (Exception e) {
                isAtTop = true;
            }
        }
    }

    // Helper method to determine if we're at the top
    private boolean isAtTopPosition() {
        try {
            return txtfield_search_wikipedia.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
