package com.automation.tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.DriverFactory;

public class ActionsTests {

private WebDriver driver;
private Actions actions;//if we want to hover in image, boxes we need Actions class

@BeforeMethod
public void setup(){

    driver= DriverFactory.createDriver("chrome");
    actions = new Actions(driver);
}
@Test
public void hoverOnImage(){
    driver.get("http://practice.cybertekschool.com/hovers");
    BrowserUtils.wait(4);

    WebElement img1=driver.findElement(By.xpath("(//img)[1]"));
    WebElement img2=driver.findElement(By.xpath("(//img)[2]"));
    WebElement img3=driver.findElement(By.xpath("(//img)[3]"));
    actions.moveToElement(img1).pause(1000).
            moveToElement(img2).pause(1000).
            moveToElement(img3).build().perform();
    //build() is used when you have couple of actions
    //always end with perform()!!
    //pause(1000) waits 1 second similar to>>>>Thread.sleep(1000)
    BrowserUtils.wait(3);

    actions.moveToElement(img1).perform();
    WebElement imgText1=driver.findElement(By.xpath("//h5[text()='name: user1']"));

   //below we verify that web element that contains text is visible
    Assert.assertTrue(imgText1.isDisplayed());

    actions.moveToElement(img2).perform();
    WebElement imgText2=driver.findElement(By.xpath("//h5[text()='name: user2']"));
    Assert.assertTrue(imgText2.isDisplayed());
    String imgtxt22=imgText2.getText();
    System.out.println(imgtxt22);


}
@Test
public void jqueryMenuTest(){

    driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
    //WebElement enabled=driver.findElement(By.cssSelector("#ui-id-3"));
    WebElement enabled2=driver.findElement(By.xpath("//a[@id='ui-id-3']"));
   // WebElement downloads=driver.findElement(By.cssSelector("#ui-id-4"));
    WebElement download2=driver.findElement(By.xpath("//a[@id='ui-id-4']"));
    WebElement pdf=driver.findElement(By.cssSelector("#ui-id-5"));
    actions.moveToElement(enabled2).pause(1000).
            moveToElement(download2).pause(1000).click(pdf).build().perform();
    //pdf.click();
    BrowserUtils.wait(3);
}

    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        //click on accept cookies
        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();

        BrowserUtils.wait(3);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon, earth).perform();

        String expected = "You did great!";
        String actual = earth.getText();

        Assert.assertEquals(actual, expected);
        //if assertion fails it will not be implemented following codes
        //do not put after Assertion any thing

    }



@AfterMethod
    public void teardown(){
    BrowserUtils.wait(5);
    driver.quit();
}

}

