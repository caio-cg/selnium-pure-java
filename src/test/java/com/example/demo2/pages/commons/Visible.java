package com.example.demo2.pages.commons;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.example.demo2.config.BrowserFactory.holdOn;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public interface Visible {

    default Boolean isVisible(WebElement element) {
        try {
            holdOn().until(visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return element.isDisplayed();
    }

    default void waitVisibilityOf(WebElement element) {
        holdOn().until(visibilityOf(element));
    }

    default void waitVisibilityOf(WebElement element, Duration duration) {
        holdOn()
                .withTimeout(duration)
                .until(visibilityOf(element));
    }

    default void waitInvisibilityOf(WebElement element) {
        holdOn().until(invisibilityOf(element));
    }

    default void waitInvisibilityOf(WebElement element, Duration duration) {
        holdOn()
                .withTimeout(duration)
                .until(invisibilityOf(element));
    }

    default void waitTextVisibility(WebElement element, String text) {
        holdOn().until(and(
                visibilityOf(element),
                textToBePresentInElement(element, text)
        ));
    }
}
