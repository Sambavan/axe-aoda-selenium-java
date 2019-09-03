package com.mol.Helper;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptionsManager {

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--headless", "--no-sandbox", "--window-size=1920,1080", "--disable-popup-blocking");
        return chromeOptions;
    }

    public FirefoxOptions getFirefoxOption() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless", "--no-sandbox", "--window-size=1920,1080");
        return firefoxOptions;
    }

    public EdgeOptions getEdgeOption() {
        EdgeOptions edgeOptions = new EdgeOptions();
        return edgeOptions;
    }

}

