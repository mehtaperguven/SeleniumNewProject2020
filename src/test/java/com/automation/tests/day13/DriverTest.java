package com.automation.tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DriverTest {

    @Test
    public void googleTest(){
        //Driver.getDriver() ---> returns driver
        Driver.getDriver().get("http://google.com");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Google");
        System.out.println(Driver.getDriver().getTitle());//prints Google
        Driver.closeDriver();
    }

}
