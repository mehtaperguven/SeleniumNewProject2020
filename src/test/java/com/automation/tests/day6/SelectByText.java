package com.automation.tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtils;
import utilities.DriverFactory;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
    driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(4);
        //we generate WebElement object below:
        WebElement simpleDropdown=driver.findElement(By.id("dropdown"));

        //Provide WebElement object>>simpleDropdown>> into the constructor
        Select selectSimpleDropdown=new Select(simpleDropdown);


        //we select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);

        selectSimpleDropdown.selectByVisibleText("Option 1");
        BrowserUtils.wait(3);

    Select selectYear=new Select(driver.findElement(By.id("year")));
    Select selectMonth=new Select(driver.findElement(By.id("month")));
    Select selectDay=new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("1971");
        selectMonth.selectByVisibleText("March");
        selectDay.selectByVisibleText("6");

        BrowserUtils.wait(5);
//select all months one by one
        //.getOptions(); >>returns all options from dropdown as List<WebElement>
        List<WebElement> months=selectMonth.getOptions();
        for (WebElement eachMonth:months){
            String monthName=eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(2);
        }
        BrowserUtils.wait(3);


        Select stateSelect=new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Texas");
        BrowserUtils.wait(3);

        String selected=stateSelect.getFirstSelectedOption().getText();
        if (selected.equals("Texas")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test failed");
        }


        BrowserUtils.wait(2);



        List<WebElement> states=stateSelect.getOptions();
        for(WebElement stateOption:states){
            System.out.println(stateOption.getText());
        }



        driver.quit();
    }
}
