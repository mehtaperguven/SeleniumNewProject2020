package com.automation.tests.day7;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserUtil;
import utilities.DriverFactory;

public class Xpath {
    //static variable must be outside the main which belongs to class
    public static String userNameLocator="//label[text()='Username']//following-sibling::input";
    public static String passwordLocator="//label[text()='Password']/following-sibling::input";
    public static String loginBtnLocator="//button[text()='Login']";//or #wooden_spoon



    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtil.wait(3);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        BrowserUtil.wait(1);
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        BrowserUtil.wait(1);
        driver.findElement(By.xpath(loginBtnLocator)).click();// or //button[contains(text(),'Login')]
        BrowserUtil.wait(3);
        driver.quit();


    }

}
