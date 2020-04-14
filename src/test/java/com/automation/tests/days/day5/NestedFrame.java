package com.automation.tests.days.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(3);

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement contentMiddle= driver.findElement(By.id("content"));
        System.out.println("middle: "+contentMiddle.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");

        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());

        //to go to the bottom frame, you need to switch to the default content
        //because, top frame is a sibling for bottom frame, but not a parent
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.quit();


    }
}
