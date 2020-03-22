package com.automation.tests.officeHoursSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class StatusCodes {

//if we do not put priority it would return from top to bottom

    @Test(priority= 1,description = "Verify that following message is displayed")
    public void testcase11(){
        WebDriver driver=BrowserFactory2.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();
//Step 3
        WebElement statusCode = driver.findElement(By.xpath("//a[text()='404']"));
        statusCode.click();
        BrowserUtils.wait(3);

    }

    @Test(priority = 0,description = "we are testing in second order")
public void test12(){


    }


     /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. And click on “Status Codes”.
        Step 3. Then click on “500”.
        Step 4. Verify that following message is displayed: “This page returned a 500 status code”
         */
    /*xpath :
    //a[text()='Status Codes']
    //a[contains(text(),'Status Codes')]
    //ul/li[46]
    //a[@href="/status_codes"]
    linkText :
    lintText("Status Codes")
    partialLinkText:
    partialLintText("Status Codes")
    partiallinkText("Status")
    partiallinkText("Codes")
    CssSelector
     [href="/status_codes"]
     */

    public static void main(String[] args) {

        WebDriver driver=BrowserFactory2.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");

 //       driver.findElement(By.linkText("Status Codes"));
//        driver.findElement(By.xpath("//a[text()='Status Codes']"));
//        driver.findElement(By.xpath("//a[contains(text(),'Status Codes')]"));
//        driver.findElement(By.xpath("//a[@href=\"/status_codes\"]"));
//        driver.findElement(By.cssSelector("[href=\"/status_codes\"]")).click();
       //WebElement statusCode= driver.findElement(By.xpath("//a[@href=\"status_codes/200\"]"));
        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();
//Step 3
        WebElement statusCode = driver.findElement(By.linkText("500"));
        statusCode.click();
        BrowserUtils.wait(3);
// Step 4
        String expectedMessage ="This page returned a 500 status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();
//System.out.println(actualMessage);
        if(actualMessage.contains(expectedMessage)){
            System.out.println("Passed");
        }else{
            System.out.println("FAILED");
        }
        driver.close();

    }
}
