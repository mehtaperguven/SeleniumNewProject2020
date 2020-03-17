package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtil;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        //#TASK
        //verify that 1st checkbox is not selected  and 2nd is selected
        BrowserUtil.wait(4);
        List<WebElement> checkBoxes=driver.findElements(By.tagName("input"));

            if (!checkBoxes.get(0).isSelected()&&checkBoxes.get(1).isSelected()){
                System.out.println("Test passed");
            }else{
                System.out.println("Test failed");
            }
        BrowserUtil.wait(3);


            //task: Lets us click on first checkbox and verify it's clicked
WebElement checkbox1=checkBoxes.get(0);
checkbox1.click();
BrowserUtil.wait(4);
        if (checkBoxes.get(0).isSelected()){
            System.out.println("TEST PASSED, checkbox 1 is selected");
        }else{
            System.out.println("TEST FAILED, checkbox 1 is not selected");
        }

//one more task
        if (checkBoxes.get(0).isSelected()&&checkBoxes.get(1).isSelected()){
            System.out.println("test both boxes selected is passed");
        }else {
            System.out.println("test both boxes selected is failed");
        }


        driver.quit();
    }
}
