package com.automation.tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtilities;
import utilities.DriverFactory;

import javax.swing.plaf.synth.SynthToolTipUI;

public class SelectByValue {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(2);

        Select stateSelect=new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("DC");
        BrowserUtilities.wait(2);

        String expected="District Of Columbia";
        String actual=stateSelect.getFirstSelectedOption().getText();
        if (expected.equals(actual)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        BrowserUtilities.wait(3);


    driver.quit();

    }
}
