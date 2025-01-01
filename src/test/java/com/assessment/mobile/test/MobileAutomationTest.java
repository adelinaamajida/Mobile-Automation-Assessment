package com.assessment.mobile.test;

import com.assessment.mobile.pageobjects.ExplorePage;
import com.assessment.mobile.pageobjects.SettingsPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobileAutomationTest {
    private AndroidDriver driver;
    private ExplorePage explorePage;

    String apkPath = getClass().getClassLoader().getResource("WikipediaSample.apk").getPath();
    File apkFile = new File(apkPath);

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        explorePage = new ExplorePage(driver);
        explorePage.clickButtonOk();
    }

    @Test
    public void task1Test() throws InterruptedException {
        // Call methods from the page class

        explorePage.scrollDownToBottom();
        explorePage.navigateToMyLists();
        Thread.sleep(3000);
        explorePage.navigateToHistory();
        Thread.sleep(3000);
        explorePage.navigateToNearby();
        Thread.sleep(3000);
        explorePage.navigateToExplore();
        explorePage.scrollUpToTop();
        Assert.assertTrue(explorePage.verifyFirstTopicNews());
    }

    @Test
    public void task2Test() {
        explorePage.clickSearchBar();
        explorePage.setTextOnSearchBar("New York");
        Assert.assertTrue(explorePage.verifySearchResult());
        explorePage.closeSearch();
        explorePage.closeSearch();
        Assert.assertTrue(explorePage.verifyFirstTopicNews());
    }

    @Test
    public void task3Test() {
        SettingsPage settingsPage = new SettingsPage(driver);
        explorePage.clickMoreOptions();
        explorePage.clickMenuSettings();
        settingsPage.switchToggleShowImages();
        settingsPage.switchToggleLinkPreviews();
        settingsPage.switchToggleSendUsageReports();
        settingsPage.switchToggleSendCrashReports();
        settingsPage.backToExplorePage();
        Assert.assertTrue(explorePage.verifyFirstTopicNews());

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
