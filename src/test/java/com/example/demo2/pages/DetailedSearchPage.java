package com.example.demo2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.example.demo2.config.BrowserFactory.driver;


public class DetailedSearchPage extends BasePageObject<DetailedSearchPage> {

    @FindBy(css = "input[data-test-id='search-input']")
    WebElement searchInput;

    public DetailedSearchPage() {
        PageFactory.initElements(driver(), this);
    }

    public String getSearchInputText() {
        return cmd.getValueOf(searchInput);
    }

}
