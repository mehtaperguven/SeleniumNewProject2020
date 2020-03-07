package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);
//helloooo

        //how to collect all links from the page
        //to get one element we use FindElement
        //If we look more than one FindElements
        //FindElements returns List<WebElements>
        //Every link must start by  "<a tag !!!
        List<WebElement> links= driver.findElements(By.tagName("a"));

        for (WebElement each:links){

            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
            System.out.println();
//            each.click();
//            Thread.sleep(3000);
//            driver.navigate().back();
            //when we add above part it gives StaleElementReferenceException

        }
        //Interview Question
        //StaleElementReferenceException: Means that selenium can not find previously located element
        //we should find element again
        //We need to refresh our collections each time to solve this problem       driver.quit();
        //you lost the ball you can not use it first you should find it

    for (int i=1; i<links.size();i++){
        links.get(i).click();//click to link
        Thread.sleep(500);
        driver.navigate().back();//go back
        Thread.sleep(500);

        links=driver.findElements(By.tagName("a"));//refresh all list of links again
        //we lost the link in each implementation we should find all links again
        //if we do not refresh we will be able to open

    }

    }
}
