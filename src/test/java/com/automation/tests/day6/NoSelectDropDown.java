package com.automation.tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserUtil;
import utilities.DriverFactory;

import java.util.List;

public class NoSelectDropDown {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtil.wait(3);
//below used dropdown is not selectable
        //we do not use Select class in here
        //It looks like dropdown but infect it is not
        //Since it is un selectable first we make it visible by clicking on
        driver.findElement(By.id("dropdownMenuLink")).click();//to expand dropdown menu first we click on it
        BrowserUtil.wait(3);


        driver.findElement(By.linkText("Amazon")).click();
        BrowserUtil.wait(3);


        List<WebElement> allLinks=driver.findElements(By.className("dropdown-item"));

        for (WebElement link:allLinks){
            System.out.println(link.getText()+" : "+link.getAttribute("href"));
        }

        driver.findElement(By.id("dropdownMenuLink")).click();//?????
        driver.findElement(By.linkText("Etsy")).click();
        BrowserUtil.wait(3);
        driver.quit();
    }
}
