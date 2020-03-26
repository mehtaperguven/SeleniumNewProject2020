package com.automation.tests.vytrack.activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class DenemeActivities {
    private By usernameBy=By.id("prependedInput");
    private By passwordBy=By.cssSelector("#prependedInput2");
    private By loginBy=By.id("_submit");
    private String storeManagerUserName="storemanager85";
    private String storeManagerPassword="UserUser123";
    private WebDriver driver;
    private Actions action;
    private By activitiesBy=By.xpath("(//span[@class=\"title title-level-1\"])[5]");
    private By calendarBy=By.xpath("//span[@class='title title-level-2' and contains(text(),'Calendar Events')]");
    //private By createCalendarButtonBy=By.linkText("Create Calendar event");
    private By createCalendarButtonBy=By.cssSelector("a[title='Create Calendar event']");
   @BeforeMethod
    public void setup(){
       WebDriverManager.chromedriver().version("79").setup();

       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://qa2.vytrack.com/user/login");
       BrowserUtils.wait(3);
       action=new Actions(driver);
       driver.findElement(usernameBy).sendKeys(storeManagerUserName);
       driver.findElement(passwordBy).sendKeys(storeManagerPassword);
       driver.findElement(loginBy).click();
       action.moveToElement(driver.findElement(activitiesBy)).perform();
       BrowserUtils.wait(3);

        driver.findElement(calendarBy).click();
        //driver.findElement(By.xpath("//span[@class='title title-level-2' and contains(text(),'Calendar Events')]"));
        BrowserUtils.wait(3);



   }
    @Test
    public void buttonVisibility(){
        WebElement eventButton=driver.findElement(createCalendarButtonBy);
        Assert.assertTrue(eventButton.isDisplayed());
    }



}
