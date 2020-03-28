package com.automation.tests.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class NewLoginTests extends TestBase {
//private WebDriver driver;
    @Test
    public void verifyPageTitle(){
//verify that page title is "Dashboard"
            LoginPage loginObj=new LoginPage();
            loginObj.login();
            Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");


            //String actual= Driver.getDriver().findElement(By.className("oro-subtitle")).getText().trim();
          String actual=Driver.getDriver().getTitle();
          System.out.println(actual);


    }
    @Test
    public void verifyWarningMessage(){
        LoginPage loginObj=new LoginPage();
        loginObj.login("wrong","wrong");
        Assert.assertEquals(loginObj.getWarningMessageText(),"Invalid user name or password.");
       //Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']//div")).getText().trim(),"Invalid user name or password.");
        String str=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']//div")).getText();
       System.out.println(str);
    }

}
