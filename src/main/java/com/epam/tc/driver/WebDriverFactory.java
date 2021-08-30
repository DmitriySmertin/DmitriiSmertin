package com.epam.tc.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.management.openmbean.InvalidOpenTypeException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverFactory {

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";


    private static final String REMOTE_DRIVER_TYPE = "remote";
    private static final String LOCAL_DRIVER_TYPE = "local";

    public static WebDriver createWebDriver(String driverType, String browserName) {
        if (REMOTE_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
            return createRemoteWebDriver(browserName);
        } else if (LOCAL_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
            return createLocalDriver(browserName);
        } else {
            throw new WebDriverTypeException(String.format("Unsupported format driver type: %s", driverType));
        }
    }

    public static WebDriver createLocalDriver(final String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase(Locale.ROOT)) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException(String.format("Unsupported browser name: %s", browserName));
        }
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }


    private static WebDriver createRemoteWebDriver(final String browserName) {
        Capabilities capabilities = null;
        if (CHROME.equalsIgnoreCase(browserName)) {
            capabilities = createRemoteChromeCapabilities();

        } else if (FIREFOX.equalsIgnoreCase(browserName)) {
            capabilities = createRemoteFirefoxCapabilities();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported browser name: %s", browserName));
        }
        try {
            return new RemoteWebDriver(new URL("http://192.168.1.68:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new InvalidOpenTypeException("Invalid selenium grid url");
        }
    }

    private static Capabilities createRemoteFirefoxCapabilities() {
        return new FirefoxOptions();
    }

    private static Capabilities createRemoteChromeCapabilities() {
        return new ChromeOptions();
    }


}
