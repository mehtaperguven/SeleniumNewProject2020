package com.automation.tests.vytrack.fleet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;

public class VehiclesPageTests {
    private WebDriver driver;
    private String URL="https://qa2.vytrack.com/user/login";
    private String username="storemanager85";
    private String password="UserUser123";

@Test
public void verifyPageSubTitle(){
driver.findElement(By.id("prependedInput")).sendKeys(username);
driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
    BrowserUtilities.wait(4);
driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]")).click();
BrowserUtilities.wait(3);
//driver.findElement(By.linkText("Vehicles")).click();
driver.findElement(By.xpath("//span[@class='title title-level-2'and contains(text(),'Vehicles')]")).click();
BrowserUtilities.wait(4);
String expected="All Cars";
String actual=driver.findElement(By.cssSelector("[class='oro-subtitle']")).getText();
    Assert.assertEquals(expected,actual);

}
/*
 *     Given user is on the vytrack landing page
 *     When user logs on as a store manager
 *     Then user navigates to Fleet --> Vehicles
 *     And user verifies that page number is equals to "1"*/
@Test
public void verifyPageNumber(){
    driver.findElement(By.id("prependedInput")).sendKeys(username);
    driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
    BrowserUtilities.wait(4);
    //driver.navigate().to("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation");
    String actual= driver.findElement(By.cssSelector("input[type='number'])")).getAttribute("value");
    String expected="1";
    Assert.assertEquals(actual,expected);




}
@BeforeMethod
public void setup(){

    WebDriverManager.chromedriver().version("79").setup();
    driver=new ChromeDriver();
    driver.get(URL);
    driver.manage().window().maximize();
}


    @AfterMethod
    public void teardown(){

        if (driver!=null){//if webdriver object is alive
            driver.quit();
            driver=null;//be sure that driver is closed,

        }
    }
}
