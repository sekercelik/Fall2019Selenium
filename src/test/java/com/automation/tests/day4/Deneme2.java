package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Deneme2 {
    public static void main(String[] args)throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://amazon.com");
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("hand sanitizer",Keys.ENTER );
        Thread.sleep(3000);
        System.out.println("title is: "+driver.getTitle());
        driver.close();

    }
}
