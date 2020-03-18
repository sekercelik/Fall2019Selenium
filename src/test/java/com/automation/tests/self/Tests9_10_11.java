package com.automation.tests.self;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests9_10_11 {

    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com/";

    //****************************************************************************************************************
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Status Codes")).click();
    }


    //****************************************************************************************************************
    @Test
    public void testCase9() {
        driver.findElement(By.linkText("200")).click();
        WebElement message = driver.findElement(By.xpath("//p[contains(text(),'This page returned a 200 status code.')]"));
        //  WebElement message = driver.findElement(By.tagName("p"));
        assertTrue(message.isDisplayed());
        BrowserUtils.wait(5);

        //a different approach to see if the message contains the expected
//        String expected= "This page returned a 200 status code.";
//        String actual= driver.findElement(By.tagName("p")).getText();
//          assertTrue(actual.contains(expected));
//          BrowserUtils.wait(3);
    }

    //*****************************************************************************************************************
    @Test
    public void testCase10() {
        driver.findElement(By.linkText("301")).click();
        WebElement message = driver.findElement(By.tagName("p"));
        assertTrue(message.isDisplayed());
    }

    //****************************************************************************************************************
    @Test
    public void testCase11() {
        driver.findElement(By.linkText("404")).click();
        WebElement message = driver.findElement(By.tagName("p"));
        assertTrue(message.isDisplayed());
    }


    //****************************************************************************************************************
    @Test
    public void testCase12() {
        driver.findElement(By.linkText("500")).click();
        WebElement message = driver.findElement(By.tagName("p"));
        assertTrue(message.isDisplayed());
    }

//********************************************************************************************************************

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


}
