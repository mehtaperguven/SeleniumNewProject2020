package com.automation.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;


public class DenemeForm {
    public static String expected;
    public static String actual;
    private WebDriver driver;
    private String URL = "http://practice.cybertekschool.com/registration_form";
    private By firstnameBy = By.cssSelector("[name='firstname']");
    //private By firstnameByy=By.name("firstname");
    private By lastnameBy = By.xpath("//input[@name='lastname']");
    private By usernameBy = By.xpath("//input[@name='username']");
    private By emailBy = By.cssSelector("[name='email']");
    private By passwordBy = By.cssSelector("[type='password']");
    private By telBy = By.cssSelector("[type='tel']");
    private By maleBy = By.cssSelector("input[value='male']");//.....By.cssSelector>>...//input[@value='male']
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");
    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.xpath("//div//select[@name='job_title']");
    //private By cplusBy=By.xpath("//div//input[@value=\"cplusplus\"]");
    private By cplusplusBy = By.cssSelector("[value=\"cplusplus\"]:nth-child(1)");
    private By javaBy = By.id("inlineCheckbox2");
    // private By javajavaBy=By.cssSelector("#inlineCheckbox2");
    private By JavaScriptBy = By.cssSelector("[value='javascript']");
    private By signupBy = By.cssSelector("[id='wooden_spoon']");

    @Test
    public void testForm() {

        // WebElement element=driver.findElement(javaBy);
        driver.findElement(firstnameBy).sendKeys("Sema");
        driver.findElement(lastnameBy).sendKeys("Engin");
        driver.findElement(usernameBy).sendKeys("semasema");
        driver.findElement(emailBy).sendKeys("sema@gmail.com");
        driver.findElement(passwordBy).sendKeys("12312345");
        driver.findElement(telBy).sendKeys("234-123-1231");
        driver.findElement(femaleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("01/02/2000");

//        //StringBuilder str=new StringBuilder("elma");
//        int []arr=new int[5];

        Select department = new Select(driver.findElement(departmentBy));
        department.selectByVisibleText("Department of Engineering");

        Select jobSelect = new Select(driver.findElement(jobTitleBy));
        jobSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();


        driver.findElement(signupBy).click();
        BrowserUtils.wait(5);
        expected = "You've successfully completed registration!";
        actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(expected, actual, "expected is not equal to actual");


    }

//    public static void main(String[] args) {
//
//        testtest();
//
//
//
//    }
//    public static boolean  testtest(){
//
//    if (expected.equals(actual)){
//        System.out.println("test passed");
//        return true;
//
//    }else{
//        System.out.println("test failed");
//
//        return false;
//    }

//}

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        BrowserUtils.wait(4);
    }
    @AfterMethod
    public void close(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
