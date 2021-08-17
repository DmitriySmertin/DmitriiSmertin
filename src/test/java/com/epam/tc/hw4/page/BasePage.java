package com.epam.tc.hw4.page;

import com.epam.tc.hw3.util.PropertiesUtil;
import com.epam.tc.hw4.util.AttachmentUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver driver;
    public com.epam.tc.hw3.util.PropertiesUtil propUtil = new PropertiesUtil();

    public void openPage(String url) {
        driver.navigate().to(url);
    }

    public void checkTitle(String title) {
        Assertions.assertThat(driver.getTitle()).isEqualTo(title);
    }

    @BeforeClass()
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
    }

    @AfterClass()
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
        driver = null;
    }

    public void attachProperty() {
        try (FileInputStream fis = new FileInputStream("./src/test/resources/application.property")) {
            AttachmentUtil.attachFromInputStream("application.property", fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
