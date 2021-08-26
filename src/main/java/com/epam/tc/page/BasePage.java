package com.epam.tc.page;

import com.epam.tc.component.Header;
import com.epam.tc.component.LeftMenu;
import com.epam.tc.component.LogWindow;
import com.epam.tc.util.PropertiesUtil;
import com.epam.tc.util.AttachmentUtil;
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
    PropertiesUtil propUtil = new PropertiesUtil();
    protected Header header;
    protected LeftMenu leftMenu;
    protected LogWindow logWindow;

    @Step("Open page {url}")
    public void openPage(String url) {
        driver.navigate().to(url);
    }

    @Step("Check {title} and Title page")
    public void checkTitle(String title) {
        Assertions.assertThat(driver.getTitle()).isEqualTo(title);
    }

    @BeforeClass()
    public void setUp(ITestContext testContext) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        header = new Header(driver);
        leftMenu = new LeftMenu(driver);
        logWindow = new LogWindow(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        testContext.setAttribute("driver", driver);
        attachProperty();
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
