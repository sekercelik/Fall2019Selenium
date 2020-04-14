package com.automation.tests.days.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) throws Throwable{
//we are writing same codes again and again
//we will write a method and call it : DRY Principle
//sth that support our code : utilities
//under automation package
//We created utilities package and DriverFactory class under automation package
//we wrote reusable methods inside DriverFactory class named => createDriver
//whenever we need to crate webDriver object
//we will call our custom method
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

       // WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName= driver.findElement(By.name("full_name"));
        fullName.sendKeys("Sidika Celik");

        Thread.sleep(2000);

        WebElement email= driver.findElement(By.name("email"));
        email.sendKeys("sceliksidika@gmail.com");

        Thread.sleep(2000);

        WebElement signUp= driver.findElement(By.name("wooden_spoon"));
        signUp.click();     // or signUp.submit();
        Thread.sleep(2000);

        String expected="Thank you for signing up. Click the button below to return to the home page.";
        WebElement message = driver.findElement(By.className("subheader"));
        String actual =message.getText();  // it will return visible text <h3>text </h3>

        if(expected.equals(actual)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

//  ctrl + F to see search part in inspect

        driver.quit();  // to close everything


    }
}
