package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();


        driver.get("http://practice.cybertekschool.com/login");

//        WebElement username=driver.findElement(By.name("username"));
//
//        username.sendKeys("tomsmith");
        //we can do in one step as below:

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(3000);

        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);
String expected="Welcome to the Secure Area. When you are done click logout below.";
String actual=driver.findElement(By.tagName("h4")).getText();
if (expected.equals(actual)){
    System.out.println("TEST PASSED");
}else {
    System.out.println("TEST FAILED");
}

//let's click on logout button. It seems like a button but
//it is actually a link <a> tag represents a link
//If we have partial couple spaces in the text just use partialLinkText instead of LinkText


WebElement logout=driver.findElement(By.linkText("Logout"));

String href=logout.getAttribute("href");
        System.out.println("Link is "+ href);
        String className=logout.getAttribute("class");
        System.out.println("class name is "+className);
        logout.click();
        Thread.sleep(3000);


        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);
        WebElement errorMessage=driver.findElement(By.id("flash-messages"));

        System.out.println(errorMessage.getText());
        Thread.sleep(2000);

         driver.quit();




    }


}
