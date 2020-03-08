package com.automation.tests.day6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserUtilities;
import utilities.DriverFactory;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {



        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtilities.wait(2);

        List<WebElement> buttons=driver.findElements(By.tagName("button"));
        buttons.get(0).click();
        BrowserUtilities.wait(3);

        String popupText=driver.switchTo().alert().getText();//we get text from pop up message
        System.out.println(popupText);

        driver.switchTo().alert().accept();//to click>>
        BrowserUtilities.wait(3);
        String expected="You successfully clicked an alert";
        String actual=driver.findElement(By.id("result")).getText();
        if (expected.equals(actual)){
            System.out.println("TEST PASSED");

        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected);
            System.out.println("Actual:  "+actual);
        }

//##############################
        System.out.println("TEST NO2:");
        buttons.get(1).click();//we click on the second button
        BrowserUtilities.wait(3);
        driver.switchTo().alert().dismiss();//we click to cancel

        String expected2="You clicked: Cancel";
        String actual2=driver.findElement(By.id("result")).getText();


        if (expected2.equals(actual2)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
            System.out.println("Expected: "+expected2);
            System.out.println("Actual:  "+actual2);
        }
        BrowserUtilities.wait(3);
//#############################################################
        System.out.println("TEST NO3");
        buttons.get(2).click();
        BrowserUtilities.wait(3);
        Alert alert= driver.switchTo().alert();//like different layer we switch into alert
        alert.sendKeys("Hello, World!");

        BrowserUtilities.wait(3);

        alert.accept();

        String expected3="Hello, World!";
        String actual3= driver.findElement(By.id("result")).getText();
        if (actual3.endsWith(expected3)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
            System.out.println("Expected: "+expected3);
            System.out.println("Actual:  "+actual3);
        }
        BrowserUtilities.wait(3);


        driver.quit();

    }
}
