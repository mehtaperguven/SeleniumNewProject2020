package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
driver.get("http://google.com");
Thread.sleep(2000);

        WebElement search=driver.findElement(By.name("q"));//we find element by locator
        //when we find the element how to enter text?
        //we use sendKeys() method
        //HOw to press Enter after entering the text()
        //then we use Keys.ENTER to
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(4000);

        WebElement news=driver.findElement(By.linkText("News"));
        news.click();//It clicks to News element ,module on the website
       Thread.sleep(4000);

        driver.quit();
    }
}
