package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {



    @Test
    public void test(){

        //System.out.println(System.getProperties());//gives all information about our computer
        //"user.dir"==user directory
        //to find the exact path we need >>System.getProperty("user.dir")
        System.out.println(System.getProperty("user.dir"));//gives>>>C:\Users\zynpr\IdeaProjects\Fall2019Selenium
        //one important usage>>>>>>System.out.println(System.getProperty("user.dir"));+"/pom.xml"
        String path=System.getProperty("user.dir")+"\\pom.xml";
        System.out.println("====>>>>"+path);
        System.out.println(System.getProperty("os.name"));//prints>>>Windows 10

        System.out.println(System.getProperty("user.home"));
        String pathToDownloads=System.getProperty("user.home")+"\\Downloads";
        System.out.println("====>>>>"+pathToDownloads);

        System.out.println(System.getProperty("os.arch"));



    }
}
