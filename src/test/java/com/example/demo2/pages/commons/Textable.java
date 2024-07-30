package com.example.demo2.pages.commons;

import org.openqa.selenium.WebElement;

import static com.example.demo2.config.BrowserFactory.holdOn;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public interface Textable {

    default void writeText(WebElement element, String text) {
        holdOn()
            .until(visibilityOf(element))
            .sendKeys(text);
    }

    default String getTextOf(WebElement element) {
        return holdOn().until(visibilityOf(element)).getText();
    }

    default String getValueOf(WebElement element) {
        return holdOn().until(visibilityOf(element)).getAttribute("value");
    }
}
