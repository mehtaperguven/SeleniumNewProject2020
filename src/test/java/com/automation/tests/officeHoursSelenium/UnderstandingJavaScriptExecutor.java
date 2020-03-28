package com.automation.tests.officeHoursSelenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UnderstandingJavaScriptExecutor {
    @Test(priority = 0, description = "Send text to sezrch box on etsy")
    public void test1(){
        // Driver instance created
        WebDriver driver = BrowserFactory2.getDriver("chrome");
        // Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");
    }

    @Test(priority = 1,description = "Clicking on an element")
    public void test2(){
       WebDriver driver=BrowserFactory2.getDriver("chrome");
       driver.get("https://www.etsy.com/");

       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("document.getElementById('catnav-primary-link-10923').click();");


    }


    @Test(description = "get the page title")
    public void testcase3(){
        WebDriver driver = BrowserFactory2.getDriver("chrome");
        // Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // return keyword before the script is for Selenium to know that it needs to bring back information
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println(pageTitle);
    }
    @Test
    public void test4(){
        WebDriver driver = BrowserFactory2.getDriver("chrome");
        // Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;


    }

    @Test(description = "scroll down")
    public void test5(){

        WebDriver driver = BrowserFactory2.getDriver("chrome");
        // Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;

    }
}
