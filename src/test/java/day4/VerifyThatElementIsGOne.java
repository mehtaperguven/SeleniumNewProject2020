package day4;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGOne {
    public static void main(String[] args) throws Exception {
        //Interview Question
        //How to check that element does not exist any more
        //it means element is gone element will disappeare it will clean from the HTML as well

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();
driver.get("http://practice.cybertekschool.com/multiple_buttons");
Thread.sleep(2000);

driver.findElement(By.id("disappearing_button")).click();
        List<WebElement> list=driver.findElements(By.id("disappearing_button"));
if (list.size()==0){//this means no element is found

    System.out.println("test passed, element is not found");
}else{
    System.out.println("test failed ");
}

Thread.sleep(2000);


List<WebElement> buttons=driver.findElements(By.tagName("button"));
for (WebElement eachButton:buttons){
    eachButton.click();
    Thread.sleep(2000);
}

    driver.quit();

    }



}
