package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtil;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");


        List<WebElement> checkBoxes=driver.findElements(By.tagName("input"));




//        checkBoxes.get(0).click();
//        //System.out.println(">>>>>>"+checkBoxes.get(0));
//        BrowserUtilities.wait(3);

for (int i=0;i<checkBoxes.size();i++) {
    if (checkBoxes.get(i).isDisplayed()&&checkBoxes.get(i).isEnabled()&&(!checkBoxes.get(i).isSelected())) {
        checkBoxes.get(i).click();
        System.out.println("check box "+(i+1)+" is clicked");
        BrowserUtil.wait(3);
    }else{
        System.out.println("check box "+(i+1)+" is not clicked because already was selected");
    }
}
        driver.quit();
    }
}
