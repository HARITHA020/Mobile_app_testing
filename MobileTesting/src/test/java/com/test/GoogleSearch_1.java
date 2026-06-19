package com.test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.URL;

import org.openqa.selenium.WebElement;
public class GoogleSearch_1 {
	public void search_1() throws Exception{
	UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("Android");
    options.setAutomationName("UiAutomator2");
    options.setDeviceName("Android");
    options.setUdid("RZCT90ZCDTP");
    options.setAppPackage("com.google.android.googlequicksearchbox");
    options.setAppActivity("com.google.android.googlequicksearchbox.SearchActivity");

    options.setNoReset(true);

    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

    WebElement searchbox=driver.findElement(AppiumBy.id("com.google.android.googlequicksearchbox:id/googleapp_search_edit_frame"));
    searchbox.click();
    WebElement search=driver.findElement(AppiumBy.id("com.google.android.googlequicksearchbox:id/googleapp_search_box"));
    search.click();
    WebElement text=driver.findElement(AppiumBy.accessibilityId("Predictions"));
    text.sendKeys("selenium");
    driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    WebElement searchText = driver.findElement(AppiumBy.id("lb"));

    String actualText = searchText.getText();

    System.out.println("Search Text: " + actualText);

    assert actualText.equals("Selenium");

    System.out.println(driver.getPageSource());

    driver.quit();
	}
}
