package com.automation.tests.officeHoursSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.DriverFactory;

public class VeryImportantDynamicCode {

    @DataProvider(name ="testData")
    public static Object [] testData(){
        return new Object [] {"404","500","301","200"};
    }
    /*
         DataProvider returns data in form of single dimensional Object array (Object [])or 2 dimensional object array (Object [] [])
         Object [] --> When you have only 1 parameter
         Object [] [] --> When you have 2+ parameters
      */
    @Test(dataProvider = "testData")
    public void statusCodes(String code ){
        //500, 404 should be the parameters
        //Step 1
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2
        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();
        //Step 3
        WebElement statusCode = driver.findElement(By.linkText(code));
        statusCode.click();
        String expectedMessage ="This page returned a "+code+" status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();
        if(actualMessage.contains(expectedMessage)){
            System.out.println("Passed");
        }else{
            System.out.println("FAILED");
        }
        driver.close();
    }
}
