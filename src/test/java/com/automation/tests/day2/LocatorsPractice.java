package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPractice {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();    // to set up driver
        WebDriver driver =new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://google.com");

        WebElement btn1= driver.findElement(By.id("gbqfbb"));
        btn1.click();
        Thread.sleep(3000);





        driver.close();



    }
}
