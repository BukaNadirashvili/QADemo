package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    public static WebDriver driver;

    public  void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findWebElements(By locator) {
        return driver.findElements(locator);
    }

    protected void setText(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected String getInputText(By locator) {
        return find(locator).getAttribute("value");
    }

    protected void click(By locator) {
        find(locator).click();
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}