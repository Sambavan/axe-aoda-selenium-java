package com.mol.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchButtonPage extends PageObject {
    public SearchButtonPage(WebDriver driver) {
        super(driver);}

    @FindBy(name = "btnK")
    WebElement googleSearchButton;

    @FindBy(name ="btnI")
    WebElement feelingLuckyButton;

    public Boolean searchButtonsAreDisplayed() {
        return googleSearchButton.isDisplayed() && feelingLuckyButton.isDisplayed();
    }

    public String getSearchButtonText() {
        return googleSearchButton.getAttribute("value");
    }

    public String getFeelingLuckyButtonText() {
        return feelingLuckyButton.getAttribute("value");
    }

}
