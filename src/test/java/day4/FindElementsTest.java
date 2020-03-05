package day4;

import io.github.bonigarcia.wdm.ChromeDriverManager;
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
        }

        driver.quit();
    }
}
