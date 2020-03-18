package com.automation.tests.self;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_6 {
    private WebDriver driver;

    @Test
    public void testCase6(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.tempmailaddress.com/");
        String email= "corran.giann@aallaa.org";

        BrowserUtils.wait(2);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        BrowserUtils.wait(3);

        driver.findElement(By.name("full_name")).sendKeys("Mary Smith");
        driver.findElement(By.name("email")).sendKeys(email);

        BrowserUtils.wait(2);

        driver.findElement(By.className("radius")).click();
        BrowserUtils.wait(3);

        WebElement message= driver.findElement(By.name("signup_message"));
        System.out.println(message.getText());

        BrowserUtils.wait(3);
        Assert.assertTrue(message.isDisplayed());

        driver.navigate().to("https://www.tempmailaddress.com/");




    }





}
