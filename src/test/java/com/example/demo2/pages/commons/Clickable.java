package com.example.demo2.pages.commons;

import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.example.demo2.config.BrowserFactory.holdOn;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public interface Clickable {

    default void click(WebElement element) {
        holdOn().until(elementToBeClickable(element));
        element.click();
    }

    default void click(WebElement element, Duration duration) {
        holdOn()
            .withTimeout(duration)
            .until(elementToBeClickable(element));
        element.click();
    }
}
