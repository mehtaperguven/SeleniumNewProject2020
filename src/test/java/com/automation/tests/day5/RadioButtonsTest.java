package com.automation.tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserUtils;
import utilities.DriverFactory;

public class RadioButtonsTest {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        //sometimes if we do not maximize the window
        // some elements can be hidden for that reason we generally maximize window
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        //<input type="radio" id="black" name="color">//in HTML id is unique
        WebElement blackButton=driver.findElement(By.id("black"));//we want to find element by id "black"

        if (blackButton.isDisplayed()&& blackButton.isEnabled()) {//isDisplayed::means is Visible!
            System.out.println("CLICK ON BLACK BUTTON");
            blackButton.click();
        }else{
            System.out.println("FAILED TO CLICK ON BLACK BUTTON");
        }

        //isDisplayed()=true===>>>>>means that element exist and visible,
        //some elements can be exist bot not visible to the users
        //isEnabled()=true==>>means button can be clicked



        if (blackButton.isSelected()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

    }
}
