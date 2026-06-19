package com.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.URL;

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

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Search']")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Selenium");

        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        Thread.sleep(5000);
        WebElement searchText = driver.findElement(AppiumBy.id("com.google.android.googlequicksearchbox:id/googleapp_srp_search_box_text"));

        String actualText = searchText.getText();

        System.out.println("Search Text: " + actualText);

        assert actualText.equals("Selenium");

        System.out.println(driver.getPageSource());

        driver.quit();
    }
}