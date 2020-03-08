package com.automation.tests.day5;

import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class Deneme {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("firefox");
        System.out.println(driver);

        driver.close();

    }
}
