package com.automation.tests.self;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_8 {

    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com/";
    private By auto = By.linkText("Autocomplete");


    @Test
    public void testCase8() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(auto).click();
        // BrowserUtils.wait(1);
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        // BrowserUtils.wait(1);
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        // BrowserUtils.wait(1);
        WebElement message = driver.findElement(By.id("result"));
        System.out.println(message.getText());

        Assert.assertTrue(message.isDisplayed());

        driver.quit();
    }

}

