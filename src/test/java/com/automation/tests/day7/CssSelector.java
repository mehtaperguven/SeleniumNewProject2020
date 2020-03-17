package com.automation.tests.day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtil;

public class CssSelector {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        //WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");


        //WebElement heading= driver.findElement(By.cssSelector(".h3"));//here . means class!!!
        WebElement heading=driver.findElement(By.className("h3"));
        WebElement home = driver.findElement(By.cssSelector(".nav-link"));//nav-link is a class >>>. is used for class
        WebElement btn1 = driver.findElement(By.cssSelector("[onclick='button1()']"));
        WebElement btn2 = driver.findElement(By.cssSelector("[name='button2']"));
        WebElement btn3 = driver.findElement(By.cssSelector("[id^='button_']"));//^ starts with means
        WebElement btn4 = driver.findElement(By.cssSelector("[onclick='button4()']"));
        WebElement btn5 = driver.findElement(By.cssSelector("[onclick='button5()']"));
        WebElement btn6 = driver.findElement(By.cssSelector("#disappearing_button"));

        btn1.click();
        BrowserUtil.wait(2);
        btn2.click();
        BrowserUtil.wait(2);
        btn3.click();
        BrowserUtil.wait(2);
        btn4.click();
        BrowserUtil.wait(2);
        btn5.click();
        BrowserUtil.wait(2);
        btn6.click();

        BrowserUtil.wait(2);
        driver.quit();
    //helloo
    }
}

