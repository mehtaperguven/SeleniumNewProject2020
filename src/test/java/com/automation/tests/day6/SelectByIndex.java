package com.automation.tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtils;
import utilities.DriverFactory;

import java.util.List;

public class SelectByIndex {
    public static void main(String[] args) {


        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select stateSelect=new Select(driver.findElement(By.id("state")));
        stateSelect.selectByIndex(9);//selects District Of Columbia
        //index as usual starts by 0!!!!
        BrowserUtils.wait(3);

        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);


        BrowserUtils.wait(3);




        List<WebElement> stateLst = stateSelect.getOptions();
        int count = 0;
        for (WebElement eachState: stateLst) {

            System.out.println(count + " = " + eachState.getText());
            count++;
        }


        driver.quit();

    }
}
