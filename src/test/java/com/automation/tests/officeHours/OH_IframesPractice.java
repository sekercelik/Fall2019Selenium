package com.automation.tests.officeHours;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OH_IframesPractice {
    private RemoteWebDriver driver;


    @BeforeMethod
    public void setup() {
        // driver= DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.manage().window().maximize();
        driver.switchTo().frame("frame-top");

        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));

        /*
            we have stored all frames webelements inside the list
            1. Loop through list
            2. swithch to each frame
                a. get test from body
                b. switch to parent
         */

        for (int i = 0; i < frameList.size(); i++) {
            driver.switchTo().frame(i);
            String bodyText = driver.findElement(By.xpath("//body")).getText();
            System.out.println("Body text: " + bodyText);
            driver.switchTo().parentFrame();
        }

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        String bodyText =driver.findElement(By.xpath("//body")).getText();
        System.out.println("bodyText = " + bodyText);

        driver.switchTo().defaultContent();
    }
}
