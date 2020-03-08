package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtilities;

public class FileUploading {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtilities.wait(4);

        WebElement upload=driver.findElement(By.id("file-upload"));
        String filePath=System.getProperty("user.dir")+"/pom.xml";

        System.out.println(filePath);
        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit"));
        BrowserUtilities.wait(4);

//String filePath2="C:/Users/zynpr/OneDrive/Masaüstü/Mehtap/SELENIUM/gitproject2019";
//upload.sendKeys(filePath2);
//driver.findElement(By.id("file-submit"));
//BrowserUtilities.wait(4);
        driver.quit();


    }
}
