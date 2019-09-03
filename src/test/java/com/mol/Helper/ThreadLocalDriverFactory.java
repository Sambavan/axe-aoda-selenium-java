package com.mol.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ThreadLocalDriverFactory {

    BrowserOptionsManager browserOptionsManager = new BrowserOptionsManager();
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public synchronized void setTLDriver(String browser) {
        if (browser.equals("firefox")) {
            threadLocalDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(browserOptionsManager.getFirefoxOption()));
        } else if (browser.equals("chrome")) {
            threadLocalDriver = ThreadLocal.withInitial(() -> new ChromeDriver(browserOptionsManager.getChromeOptions()));
        } else if (browser.equals("edge")) {
            threadLocalDriver = ThreadLocal.withInitial(() -> new EdgeDriver(browserOptionsManager.getEdgeOption()));
        }
    }
    public synchronized ThreadLocal<WebDriver> getTLDriver() {
        return threadLocalDriver;
    }

}
