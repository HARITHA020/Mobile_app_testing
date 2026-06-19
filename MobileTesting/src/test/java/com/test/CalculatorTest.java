package com.test;

import java.net.URI;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CalculatorTest {

    @Test
    public void verifyAddition() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("RZCT90ZCDTP");

        options.setAppPackage("com.calculator.scientific.calculator.calc");
        options.setAppActivity(
                "com.calculator.scientific.calculator.calc.ui.activity.MainActivity");

        options.setNoReset(true);

        AndroidDriver driver = new AndroidDriver(
                URI.create("http://127.0.0.1:4723").toURL(),
                options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.id("com.calculator.scientific.calculator.calc:id/nine")).click();

        driver.findElement(AppiumBy.id( "com.calculator.scientific.calculator.calc:id/add")).click();

        driver.findElement(AppiumBy.id("com.calculator.scientific.calculator.calc:id/two")).click();
        driver.findElement(AppiumBy.id("com.calculator.scientific.calculator.calc:id/equal")).click();

        Thread.sleep(2000);
        WebElement result = driver.findElement(AppiumBy.id("com.calculator.scientific.calculator.calc:id/edit"));

        String actualResult = result.getText();

        System.out.println("Result = " + actualResult);

        Assert.assertTrue(actualResult.contains("11"));

        driver.quit();
    }
}