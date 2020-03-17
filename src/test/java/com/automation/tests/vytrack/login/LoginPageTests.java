package com.automation.tests.vytrack.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;

import static org.testng.Assert.*;

public class LoginPageTests {

    private WebDriver driver;
    private String URL="https://qa2.vytrack.com/user/login";
    //http==hyper text transfer protocol
    //https== secured version of http protocol
    private String username="storemanager85";
    private String password="UserUser123";



   private By usernameBy=By.id("prependedInput");
   private By passwordBy=By.id("prependedInput2");
   private By warningMessageBy=By.cssSelector("[class='alert alert-error']>div");//here...>div means get direct child !!!!

   @Test
   public void invalidUserName(){
       driver.findElement(usernameBy).sendKeys("invalidusername");
       driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
       BrowserUtilities.wait(3);
       WebElement warningElement=driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected="Invalid user name or password.";
        String actual=warningElement.getText();
        assertEquals(actual,expected);

   }

   @Test(description = "login as store manager and verify that title is equals to Dashboard")
   public void loginStoreManager(){

       driver.findElement(usernameBy).sendKeys(username);
       driver.findElement(passwordBy).sendKeys(password,Keys.ENTER);

       String expected="Dashboard";
       String actual=driver.getTitle();
       assertEquals(actual,expected,"Page title is not correct");
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
