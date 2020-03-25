package com.automation.tests.day13;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class ConfigurationReaderTest {
   @Test
    public void readProperties(){

String browser= ConfigurationReader.getProperty("browser");

String url=ConfigurationReader.getProperty("qa1");

       System.out.println(browser);
       System.out.println(url);

       String storeManager=ConfigurationReader.getProperty("store_manager");
       System.out.println("storeManager = " + storeManager);
       String password=ConfigurationReader.getProperty("password");
       System.out.println("password = " + password);
       String driver=ConfigurationReader.getProperty("driver");
       System.out.println("driver = " + driver);
       
   }
}
