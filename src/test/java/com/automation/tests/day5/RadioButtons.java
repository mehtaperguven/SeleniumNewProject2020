package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().version("79").setup();//79 is chrome driver's version
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        //we generated wait method for Thread.sleep();

       // Thread.sleep(3000);

        List<WebElement> radioButtons=driver.findElements(By.tagName("input"));
        //we collected all input radiobutton elements above
        //<input type="radio">
        for (WebElement radioButton:radioButtons){

           // <input type="radio" id="blue" name="color" checked="">
            String id=radioButton.getAttribute("id");//id is unique getAttribute("id") brings blue
            //returns true if button already is clicked
           boolean isSelected=radioButton.isSelected();
            System.out.println(id+" is selected ? "+isSelected);

            if (radioButton.isEnabled()) {//retirns true if button can be clicked,otherwise returns false
                radioButton.click();
                System.out.println("Clicked on:: "+id);
                BrowserUtils.wait(1);
            }else{
                System.out.println("Button is disabled, not clicked :: "+id);

            }
            System.out.println();
        }



        driver.quit();
    }
}
