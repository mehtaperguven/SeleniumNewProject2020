package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtilities;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtilities.wait(5);
        driver.findElement(By.name("firstname")).sendKeys("John");
driver.findElement(By.name("lastname")).sendKeys("Smith");
driver.findElement(By.name("username")).sendKeys("jsmith");
driver.findElement(By.name("email")).sendKeys("jsmith@hotmail.com");
driver.findElement(By.name("password")).sendKeys("superSecret");
driver.findElement(By.name("phone")).sendKeys("532-523-8945");

        List<WebElement> genders=driver.findElements(By.name("gender"));
        genders.get(0).click();

        driver.findElement(By.name("birthday")).sendKeys("01/01/2000");
driver.findElement(By.id("inlineCheckbox2")).click();
BrowserUtilities.wait(2);

driver.findElement(By.id("wooden_spoon")).click();
BrowserUtilities.wait(2);


        driver.quit();
    }
}
