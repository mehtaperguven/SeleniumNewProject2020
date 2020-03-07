package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtilities;

public class TestForiFrame {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtilities.wait(4);
        //we switch to inside frame to get text
        driver.switchTo().frame("mce_0_ifr");//it is>> "mce_0_ifr" >>>id of this frame
        //we switchTo frame which has "id=mce_0_ifr"

        WebElement textInput=driver.findElement(By.id("tinymce"));
        System.out.println("!!!!!!!>>>>"+textInput.getText());    //will not work
        BrowserUtilities.wait(4);

textInput.clear();//we delete text
textInput.sendKeys("Hello, World....");// we changed text with Hello, World
BrowserUtilities.wait(4);
        //Below we come back, outside of the frame layer by defaultContent()
        driver.switchTo().defaultContent();//we exit from the frame

        WebElement heading=driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());


        driver.quit();
    }
}
