package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtilities;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().version("79").setup();//79 is chrome driver's version
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtilities.wait(3);
        //we generated wait method for Thread.sleep();

       // Thread.sleep(3000);

        List<WebElement> radioButtons=driver.findElements(By.tagName("input"));
        //we collected all input radiobutton elements above
        //<input type="radio">
        for (WebElement radioButton:radioButtons){

           // <input type="radio" id="blue" name="color" checked="">
            String id=radioButton.getAttribute("id");//id is unique getAttribute("id") brings blue
            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("Clicked on:: "+id);
                BrowserUtilities.wait(1);
            }else{
                System.out.println("Button is disabled, not clicked :: "+id);
            }
        }



        driver.quit();
    }
}
