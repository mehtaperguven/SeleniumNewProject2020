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
        driver.manage().window().maximize();//It maximizes the browser's page
        Thread.sleep(3000);//it waits for 3 seconds for Demo
        // we must add throws when we call sleep() from Thread


        String title=driver.getTitle();
        String expectedTitle="Google";
        System.out.println("Title from the HTML file is "+ title);

        if (expectedTitle.equals(title)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);

        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }


        driver.navigate().back();//comes back to google

        verifyEquals(driver.getTitle(),"Google");

        driver.navigate().forward();//moves forward in the browser's history
        System.out.println("Get title "+driver.getTitle());
        System.out.println("Get URL "+driver.getCurrentUrl());


        driver.navigate().refresh();//to refresh, reload the page
        Thread.sleep(3000);

        //driver.close() must be at the end
        driver.close();//we close the browser

//hello hello
    }public static void verifyEquals(String arg1, String arg2){

        if (arg1.equals(arg2)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
    }

}
