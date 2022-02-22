package com.solvd.task2.service;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.safari.SafariOptions;

public class OptionFactory {

    public static AbstractDriverOptions<?> createOption(Browser browserName) {
        AbstractDriverOptions<?> browserOption = null;
        switch (browserName) {
            case SAFARI:
                browserOption = new SafariOptions();
                break;
            case CHROME:
                browserOption = new ChromeOptions();
                break;
            case FIREFOX:
                browserOption = new FirefoxOptions();
                break;
            default:
                break;
        }
        return browserOption;
    }
}