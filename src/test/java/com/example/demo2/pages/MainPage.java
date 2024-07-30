package com.example.demo2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import static com.example.demo2.config.BrowserFactory.driver;

public class MainPage extends BasePageObject<MainPage> {
    @FindBy(css = "[data-test='site-header-search-action']")
    private WebElement searchButton;

    @FindBy(css = "[data-test-id='search-input']")
    private WebElement searchInput;

    @FindBy(css = "[data-test='full-search-button']")
    private WebElement advancedSearchButton;

    @FindBy(css = "button[data-jetbrains-cookies-banner-action='ACCEPT_ALL']")
    private WebElement acceptAllButton;

    @FindBy(css = "h3[data-test='no-results']")
    private WebElement noSearchResults;

    public MainPage() {
        PageFactory.initElements(driver(), this);
    }

    public MainPage navigate() {
        driver().get("https://www.jetbrains.com/");
        return this;
    }

    public MainPage clickOnSearchButton() {
        cmd.click(searchButton);
        return this;
    }

    public MainPage fillInSearchInput(String searchText) {
        cmd.waitVisibilityOf(searchInput);
        cmd.writeText(searchInput, searchText);
        return this;
    }

    public MainPage clickOnAdvancedSearch() {
        cmd.click(advancedSearchButton, Duration.ofSeconds(20));
        return this;
    }

    public MainPage clickOnAcceptAllCookies() {
        cmd.click(acceptAllButton);
        cmd.waitInvisibilityOf(acceptAllButton);
        return this;
    }

    public Boolean isNoSearchResultsVisible() {
        return cmd.isVisible(noSearchResults);
    }

    public Boolean isSearchResultsShowingText(String text) {
        cmd.waitTextVisibility(noSearchResults, text);
        return true;
    }

    public Boolean isCookiesDialogVisible() {
        return cmd.isVisible(acceptAllButton);
    }
}
