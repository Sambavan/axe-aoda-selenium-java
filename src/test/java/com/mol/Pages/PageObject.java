package com.mol.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import java.time.LocalDate;
import java.util.List;

public class PageObject {

    protected WebDriver driver;
    protected Logger logger;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    void selectCurrentDay(List<WebElement> dates) {
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();

        dates.get(day - 1).click();
    }

}