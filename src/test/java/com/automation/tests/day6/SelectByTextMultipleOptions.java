package com.automation.tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtils;
import utilities.DriverFactory;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        Select languagesSelect=new Select(driver.findElement(By.name("Languages")));

        boolean isMultiple=languagesSelect.isMultiple();
        System.out.println(isMultiple);//>>>if it is true it means there are multiple options to select

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("C#");

        BrowserUtils.wait(3);


        List<WebElement> selectedLanguages=languagesSelect.getAllSelectedOptions();

        for (WebElement selectedLanguage:selectedLanguages){
            System.out.println(selectedLanguage.getText());
        }

        BrowserUtils.wait(2);

        languagesSelect.deselectByVisibleText("Java");
        BrowserUtils.wait(3);
        languagesSelect.deselectAll();

        BrowserUtils.wait(3);

        driver.quit();
    }
}
