package com.automation.tests.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.LinkedList;
import java.util.List;

public class TestScriptsFrom1_5 {
    private WebDriver driver;
    private String URL="https://practice-cybertekschool.herokuapp.com/";
    private By registrationBy=By.linkText("Registration Form");
    private By dateOfBirthBy=By.cssSelector("[name=\"birthday\"]");
    private By cPlusBy=By.xpath("(//label[@class='form-check-label'])[1]");
    private By javaBy=By.xpath("(//label[@class='form-check-label'])[2]");
    private By javaScriptBy=By.xpath("(//label[@class='form-check-label'])[3]");
    private By firstNameBy=By.cssSelector("input[placeholder='first name']");
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(registrationBy).click();
        BrowserUtils.wait(3);

    }

    @Test(description = "this test passed")
    public void testScript1(){
    driver.findElement(dateOfBirthBy).sendKeys("“wrong_dob");
    BrowserUtils.wait(3);
    WebElement textActual=driver.findElement(By.xpath("//small[@class='help-block' and contains(text(),'The date of birth is not valid')]"));
    Assert.assertTrue(textActual.isDisplayed());

    }

    @Test(description = "all languages are displayed")
    public void testScript2(){
        WebElement cPlusPlus=driver.findElement(cPlusBy);
        WebElement javaJava=driver.findElement(javaBy);
        WebElement javaScript=driver.findElement(javaScriptBy);
        List<WebElement> languages= new LinkedList<>();
        languages.add(cPlusPlus);
        languages.add(javaJava);
        languages.add(javaScript);

        for (WebElement each: languages) {

            Assert.assertTrue(each.isDisplayed());
            //System.out.println(each.getText());

        }
    }

    @Test
    public void testScript3(){

    driver.findElement(firstNameBy).sendKeys("B");


    }


    @AfterMethod
    public void close(){
    if (driver!=null){
        driver.quit();
        driver=null;
    }

    }



}
