package day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverFactory;

public class FindElementsPractice {

    public static void main(String[] args) throws Exception {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
        //to do same thing written above we built new method under the utilities in the DriverFactory

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");


        WebElement fullName=driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");
        Thread.sleep(3000);

        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");
        Thread.sleep(3000);

        WebElement signUp=driver.findElement(By.name("wooden_spoon"));

        signUp.submit();
        Thread.sleep(3000);

        String expected="Thank you for signing up. Click the button below to return to the home page.";
        WebElement message=driver.findElement(By.className("subheader"));
        String actual=message.getText();

if (expected.equals(actual)){
        System.out.println("Test Passed");
}else{
        System.out.println("Test failed");
}



driver.quit();



    }
}
