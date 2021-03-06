package com.automation.tests.vytrack.activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.DriverFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CalendarEventsPageTests1 {

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;

    private String storeManagerUserName="storemanager85";
    private String storeManagerPassword="UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    //By.xpath(//span[@class="title title-level-1"])[5]
    private By createCalendarEventBtnBy = By.cssSelector("a[title='Create Calendar event']");
    ////span[@class='title title-level-2' and contains(text(),'Calendar Events')]
    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);

        BrowserUtils.wait(5);

        actions = new Actions(driver);
        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();

        BrowserUtils.wait(2);

        driver.findElement(By.linkText("Calendar Events")).click();

        BrowserUtils.wait(5);
    }

    @Test
    public void verifyCreateButton(){
        WebElement createCalendarEventBtn = driver.findElement(createCalendarEventBtnBy);
        Assert.assertTrue(createCalendarEventBtn.isDisplayed());
    }

    /**
     * //in the @BeforeMethod
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     *
     *
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank

     * Default start date should be current date
     * Default start time should be current time
     */
    @Test(description = "Default options")
    public void verifyDefaultValues(){
        //Click on Create Calendar Event
        driver.findElement(createCalendarEventBtnBy).click();
        BrowserUtils.wait(4);

        //Default owner name should be current user
        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        System.out.println("currentUserName>>>>>"+currentUserName);
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();
        System.out.println("defaultOwnerName>>>>>"+defaultOwnerName);
        Assert.assertEquals(currentUserName, defaultOwnerName);

//        Default title should be blank
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
        //date time syntax = https://www.journaldev.com/17899/java-simpledateformat-java-date-format

        //Default start date should be current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");
        System.out.println("ACTUAL DATE>>>>>>"+actualDate);
        Assert.assertEquals(actualDate , expectedDate);

        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:mm a"));//mm olunca problem olmadi
        System.out.println("expectedTime>>>>>"+expectedTime);
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");
        System.out.println("ACTUAL TIME>>>>>>"+actualTime);

        Assert.assertEquals(actualTime, expectedTime);
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }






}
