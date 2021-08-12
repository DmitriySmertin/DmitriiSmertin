package com.epam.tc.hw3.page;

import com.epam.tc.hw3.util.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver driver;
    public PropertiesUtil propUtil = new PropertiesUtil();

    public void openPage(String url) {
        driver.navigate().to(url);
    }

    @BeforeClass()
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass()
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
        driver = null;
    }


}
