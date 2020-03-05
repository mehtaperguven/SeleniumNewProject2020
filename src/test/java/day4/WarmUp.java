package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverFactory;

public class WarmUp {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {

ebayTest();
        amazonTest();
        wikiTest();

        //      Go to ebay
//    enter search term
//    click on search button
//    print number of results
    }public static void ebayTest() throws Exception{

        driver = DriverFactory.createDriver("chrome");
        //WebDriverManager.chromedriver().setup();

        driver.get("https://www.ebay.com/");

Thread.sleep(2000);
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
Thread.sleep((2000));
        WebElement searchResult = driver.findElement(By.tagName("h1"));
        System.out.println("searchResult " + searchResult.getText().split(" ")[0]);
//gives only first value
        //between span which represents space , we found each text
        driver.quit();

    }
//    go to amazon
//    Go to ebay
//    enter search term
//    click on search button
//    verify title contains search term

    public static void amazonTest() throws Exception {

        driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        //enter text and click Enter
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book",Keys.ENTER);
        Thread.sleep(2000);
        String title=driver.getTitle();

        if (title.contains("java book")){

            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }




    }

//    Go to wikipedia.org
//    enter search term `selenium webdriver`
//    click on search button
//    click on search result `Selenium (software)`
//    verify url ends with `Selenium_(software)`
    public static void wikiTest() throws Exception{


        driver=DriverFactory.createDriver("chrome");
        driver.get("https://www.wikipedia.org/wiki/Main_Page");

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(3000);

        String link=driver.getCurrentUrl();// we get link as a String
        System.out.println(link);
        if (link.endsWith("Selenium_(software)")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }


    }
}