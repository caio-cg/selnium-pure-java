package com.example.demo2;

import com.example.demo2.pages.DetailedSearchPage;
import com.example.demo2.pages.MainPage;
import org.junit.jupiter.api.*;

import static com.example.demo2.config.BrowserFactory.driverClose;
import static org.junit.jupiter.api.Assertions.*;


public class MainPageTest {
    MainPage mainPage;

    @BeforeEach
    public void setUp() {
        mainPage = new MainPage();
    }

    @AfterEach
    public void tearDown() {
        driverClose();
    }

    @RepeatedTest(3)
    void search_for_unknown_subject_should_return_no_results(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition() + " - start - search_for_no_results \n \t\t Thread id:" + Thread.currentThread().getId());

        mainPage
            .navigate()
            .clickOnAcceptAllCookies()
            .assertThat(() -> {
                assertFalse(mainPage.isCookiesDialogVisible());
            })
            .clickOnSearchButton()
            .fillInSearchInput("BLABLABLABLA")
            .assertThat(() -> {
                assertTrue(mainPage.isNoSearchResultsVisible());
                assertTrue(mainPage.isSearchResultsShowingText("We’re sorry! We couldn’t find results for «BLABLABLABLA»"));
            });

        System.out.println(repetitionInfo.getCurrentRepetition() + " - end - search_for_no_results \n \t\t Thread id:" + Thread.currentThread().getId());
    }

    @RepeatedTest(3)
    void search_for_selenium_should_lead_to_details_page(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition() + " - start - search_for_selenium_should_lead_to_details_page \n \t\t Thread id:" + Thread.currentThread().getId());

        mainPage
            .navigate()
            .clickOnAcceptAllCookies()
            .clickOnSearchButton()
            .fillInSearchInput("Selenium")
            .clickOnAdvancedSearch()
            .assertThat(() -> {
                var searchPage = new DetailedSearchPage();
                assertEquals("Selenium", searchPage.getSearchInputText());
            });

        System.out.println(repetitionInfo.getCurrentRepetition() + " - end - search_for_selenium_should_lead_to_details_page \n \t\t Thread id:" + Thread.currentThread().getId());
    }
}
