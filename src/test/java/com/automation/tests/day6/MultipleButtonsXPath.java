package com.automation.tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.BrowserUtilities;
import utilities.DriverFactory;

public class MultipleButtonsXPath {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtilities.wait(3);

        WebElement btn1=driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btn1.click();

        WebElement result=driver.findElement(By.id("result"));
        System.out.println(result.getText());
        BrowserUtilities.wait(3);



         WebElement btn2=driver.findElement(By.xpath("//button[text()='Button 2']"));
         btn2.click();
         BrowserUtilities.wait(3);
         //WebElement result2=driver.findElement(By.id("result"));
         System.out.println(result.getText());


         WebElement btn3=driver.findElement(By.xpath("//button[starts-with(@id,'button_')]"));
            btn3.click();
         BrowserUtilities.wait(3);
         System.out.println(result.getText());

       // WebElement btn4 = driver.findElement(By.id("//button[contains(@id,'_button')][1]"));
         WebElement btn4=driver.findElement(By.xpath("//button[contains(@id,'_button')][1]"));
        btn4.click();
        System.out.println(result.getText());
        BrowserUtilities.wait(3);

        WebElement btn5 = driver.findElement(By.xpath("//button[contains(text(),'5')]"));
        btn5.click();
        System.out.println(result.getText());
        BrowserUtilities.wait(3);
        driver.quit();
    }
}
