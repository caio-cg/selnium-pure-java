package com.example.demo2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class BrowserFactory {

//    private static final String[] BROWSERS = {"Chrome", "Firefox"};
//    private static final String[] BROWSERS = { "Firefox" };
    private static final String[] BROWSERS = { "Chrome" };

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>() {
        @Override
        protected WebDriver initialValue() {
            return createBrowser(getRandomBrowser());
        }

        @Override
        public WebDriver get() {
            return super.get();
        }
    };

    public static WebDriver driver() {
        return webDriver.get();
    }

    public static void driverClose() {
        webDriver.get().quit();
        webDriver.remove();
    }

    public static WebDriverWait holdOn() {
        return new WebDriverWait(webDriver.get(), Duration.ofSeconds(12));
    }

    public static WebDriver createBrowser(String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920, 1080");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-headless");
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }

        return driver;
    }

    private static String getRandomBrowser() {
        Random random = new Random();
        int index = random.nextInt(BROWSERS.length);
        return BROWSERS[index];
    }
}
