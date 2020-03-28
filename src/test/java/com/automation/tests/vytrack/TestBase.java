package com.automation.tests.vytrack;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationReader;
import utilities.Driver;
//TestBase class exists in TestNG projects
//TestBase is abstract class,provides minimum essential setup and cleanup for every test of our project
//It is abstract to be extended! by sub classes
//Does not contain Test
//We initialize WebDriverwait,Actions class object and open the browser
//It should not be under utilities for the design point of view!
//testBase is a blueprint for all test classes
 public abstract class TestBase {
    //protected will be visible in the subclass,(same package or outside the package sub class as well)
protected WebDriverWait wait;
protected Actions actions;
   @BeforeMethod
   public void setup(){
String URL= ConfigurationReader.getProperty("qa1");
       Driver.getDriver().get(URL);
       Driver.getDriver().manage().window().maximize();
        wait=new WebDriverWait(Driver.getDriver(),15);
        //implicit wait should be in BeforeMethod
       //We should not use both implicit and explicit waits in same test
       //It might cause unexpected delays
       //Explicit wait is used inside a Test itself,since we have to provide webelement
       actions=new Actions(Driver.getDriver());
   }

   @AfterMethod
    public void teardown(){
       Driver.closeDriver();
   }
}
