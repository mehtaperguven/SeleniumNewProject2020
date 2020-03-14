package com.automation.tests.day7;

import org.apache.http.impl.cookie.BrowserCompatVersionAttributeHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserUtilities;
import utilities.DriverFactory;

public class Xpath {
    //static variable must be outside the main which belongs to class
    public static String userNameLocator="//label[text()='Username']//following-sibling::input";
    public static String passwordLocator="//label[text()='Password']/following-sibling::input";
    public static String loginBtnLocator="//button[text()='Login']";
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtilities.wait(3);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        BrowserUtilities.wait(1);
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        BrowserUtilities.wait(1);
        driver.findElement(By.xpath(loginBtnLocator)).click();// or //button[contains(text(),'Login')]
        BrowserUtilities.wait(3);
        driver.quit();


    }

}
