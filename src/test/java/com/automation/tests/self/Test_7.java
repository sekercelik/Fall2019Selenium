package com.automation.tests.self;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_7 {
    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com/";

    @Test
    public void testCase7() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(By.linkText("File Upload")).click();
       driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\16787\\Desktop//XPath_Css.txt");
       driver.findElement(By.id("file-submit")).click();

        WebElement message= driver.findElement(By.tagName("h3"));
        String actual= message.getText();
        String expected= "File Uploaded!";
       // System.out.println(actual);

        Assert.assertEquals(actual,expected);

        Assert.assertTrue(driver.findElement(By.id("uploaded-files")).isDisplayed());

        driver.quit();
    }

}
