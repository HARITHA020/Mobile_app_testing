package com.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class GoogleSearch {

    @Test
    public void searchSelenium() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android");
        options.setUdid("RZCT90ZCDTP");

        options.setAppPackage("com.google.android.googlequicksearchbox");
        options.setAppActivity("com.google.android.googlequicksearchbox.SearchActivity");

        options.setNoReset(true);
        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Search']")).click();
        WebElement searchBox =
                driver.findElement(AppiumBy.className("android.widget.EditText"));

        searchBox.sendKeys("Selenium");
        driver.executeScript(
                "mobile: performEditorAction",
                Map.of("action", "search")
        );
        Thread.sleep(5000);
        boolean resultLoaded =
                driver.getPageSource().toLowerCase().contains("selenium");

        System.out.println("Search Result Loaded: " + resultLoaded);
        System.out.println(driver.getPageSource());

        driver.quit();
    }
}