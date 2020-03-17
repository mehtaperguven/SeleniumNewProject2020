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
import utilities.BrowserUtil;

public class RegistrationForm {

    private  String URL="http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    //private String firstNameLocator="firstname";
    private By firstNameBy=By.name("firstname");
    //private String lastNameLocator="lastname";
    private By lastNameBy=By.name("lastname");
    private By userNameBy=By.name("username");
    private By emailBy=By.name("email");
    private By passwordBy=By.name("password");
   // private By phoneBy=By.name("phone");
    private By phoneBy=By.cssSelector("input[name='phone']");
    private By maleBy=By.cssSelector("input[value='male']");
    private By femaleBy=By.cssSelector("input[value='female']");
    private By otherBy=By.cssSelector("input[value='other']");
    private By dateOfBirthBy=By.name("birthday");
    private By departmentBy=By.name("department");
    private By jobTitleBy=By.name("job_title");
    private By cplusplusBy=By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy=By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javaScriptBy=By.xpath("//label[text()='JavaScript']/preceding-sibling::input");
    private By signUpBy=By.id("wooden_spoon");

@Test
public void test1(){

driver.findElement(firstNameBy).sendKeys("Patrick");
driver.findElement(lastNameBy).sendKeys("white");
driver.findElement(userNameBy).sendKeys("testuser");
driver.findElement(emailBy).sendKeys("test@email.com");
driver.findElement(passwordBy).sendKeys("12345678");
driver.findElement(phoneBy).sendKeys("234-123-1231");

    driver.findElement(femaleBy).click();
    driver.findElement(dateOfBirthBy).sendKeys("01/02/1940");

    Select departmentSelect = new Select(driver.findElement(departmentBy));
    departmentSelect.selectByVisibleText("Department of Agriculture");
    Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
    jobTitleSelect.selectByVisibleText("SDET");
    driver.findElement(javaBy).click();
    driver.findElement(signUpBy).click();
    BrowserUtil.wait(5);
    String expected = "You've successfully completed registration!";
    String actual = driver.findElement(By.tagName("p")).getText();


}


@Test
public void verifyFirstNameLengthTest(){

//    driver.findElement(firstNameBy).sendKeys("a");
//    BrowserUtilities.wait(4);
//    WebElement warningMessage=driver.findElement(By.xpath("//small[test()='first name must be more than 2 and less than 64 characters long']"));
//    Assert.assertTrue(warningMessage.isDisplayed());


    driver.findElement(firstNameBy).sendKeys("a");
    BrowserUtil.wait(3);
    WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
    Assert.assertTrue(warningMessage.isDisplayed());
}
@Test
public void verifyAlphabeticLettersOnlyTest(){
driver.findElement(firstNameBy).sendKeys("123");
BrowserUtil.wait(3);
WebElement warningMessage=driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
Assert.assertTrue(warningMessage.isDisplayed());
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
    driver.quit();
}

}
