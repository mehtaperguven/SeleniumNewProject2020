package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtil;

public class NestedFrame {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/nested_frames");

        BrowserUtil.wait(4);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement content=driver.findElement(By.id("content"));
        System.out.println(content.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");

        WebElement body=driver.findElement(By.tagName("body"));
        System.out.println(body.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());



        driver.quit();



    }
}
