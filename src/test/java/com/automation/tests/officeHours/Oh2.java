package com.automation.tests.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Oh2 {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.kohls.com/");
        WebElement searchbox= driver.findElement(By.id("search"));
        searchbox.sendKeys("handbags"+ Keys.ENTER);
        Thread.sleep(5000);
      //  WebElement message = driver.findElement(By.tagName("Search Results for "));

        searchbox.clear();


     driver.quit();
    }
}
