package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {

        //to start selenium script we need
        //setup webdriver (browse driver) and
        WebDriverManager.chromedriver().setup();
        //RemoteWebDRiver is the super parent of all drivers
       // RemoteWebDriver driver=new SafariDriver();

        //ChromeDriver driver=new ChromeDriver();
        WebDriver driver=new ChromeDriver();
        //in selenium, everything starts from WebDriver interface

        driver.get("http://google.com");// we opened the browser

        Thread.sleep(3000);//it waits for 3 seconds
        // we must add throws when we call sleep() from Thread


        String title=driver.getTitle();
        String expectedTitle="Google";
        System.out.println("Title from the HTML file is "+ title);
        System.out.println("Hello hello");
        if (expectedTitle.equals(title)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.close();//we closed the browser
    }
}
