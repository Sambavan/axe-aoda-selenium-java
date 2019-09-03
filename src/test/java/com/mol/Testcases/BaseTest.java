package com.mol.Testcases;

import com.mol.Helper.ThreadLocalDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    WebDriver driver;
    private ThreadLocalDriverFactory threadLocalDriverFactory = new ThreadLocalDriverFactory();


    private WebDriver getDriver() {
        return threadLocalDriverFactory.getTLDriver().get();
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    void setUp(final String browser) {
        threadLocalDriverFactory.setTLDriver(browser);

        driver = getDriver();

        driver.get("https://www.google.com");

    }

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        driver.quit();
        threadLocalDriverFactory.getTLDriver().remove();
    }

}
