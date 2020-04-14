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

//        String filePath=System.getProperty("user.dir")+"\\XPath_Css.txt";
//        driver.findElement(By.id("file-upload")).sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        String message= driver.findElement(By.id("uploaded-files")).getText();
        String expected= "XPath_Css.txt";
       // System.out.println(actual);
        Assert.assertTrue(driver.findElement(By.id("uploaded-files")).isDisplayed());

        Assert.assertEquals(message,expected);

        driver.quit();
    }




}
