package com.automation.tests.day7;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;

public class Deneme2 {

    public static String userNameLocator="//label[text()='Username']//following-sibling::input";
                                        ////label[text()='Username']//following-sibling::input
    //label[contains(text(),'Username')]//following-sibling::input

public static String passwordLocator="//label[contains(text(),'Password')]/following-sibling::input";
//public static String str="[name='password']";

    public static String loginLocator="//button[contains(text(),'Login')]";



    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        BrowserUtils.wait(3);

        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(3);

        driver.findElement(By.xpath(loginLocator)).click();







//        //driver.findElement(By.cssSelector("[type='text']")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("[name=username]")).sendKeys("tomsmith");
//        BrowserUtilities.wait(3);
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword");
//        BrowserUtilities.wait(3);
//        driver.findElement(By.cssSelector("#wooden_spoon")).click();


        BrowserUtils.wait(3);
        driver.quit();


    }

}
