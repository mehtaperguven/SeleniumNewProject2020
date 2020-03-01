package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);

       //every window has some id, this id calls window handle
        //based on window handle we can switch between windows

        String windowHandle=driver.getWindowHandle();
        //gives currently opened widow's id
        System.out.println("Window's id==Window's Handle is = "+windowHandle);


        Set<String> windowHandlesIds=driver.getWindowHandles();
        System.out.println(windowHandlesIds);

        System.out.println("Before switching window ids "+driver.getCurrentUrl()+">>>>>"+driver.getWindowHandle());
        for (String windowId:windowHandlesIds){

            if (!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("After switch of window id "+driver.getCurrentUrl()+">>>>>"+driver.getWindowHandle());

        //switchToWindowBasedOnTitle("http://practice.cybertekschool.com/open_new_tab", );

   driver.close();

    }
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver ){

        Set<String> windows =driver.getWindowHandles();
        for (String each: windows){
        driver.switchTo().window(each);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
}


    }
}
