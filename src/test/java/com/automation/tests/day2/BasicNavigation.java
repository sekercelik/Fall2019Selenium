package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{


    // to start selenium script we need :
   // setup webdriver (browser driver) and create webdriver object
        // for every browser we have corresponding driver

        WebDriverManager.chromedriver().setup(); // we just call it here
        WebDriver driver= new ChromeDriver(); //WebDriver is interface//  ChromeDriver is a class
    //    FirefoxDriver driver =new FirefoxDriver(); // or RemoteWebDriver driver =new FirefoxDriver();

    // in selenium everything starts from WebDriver interface
    // ChromeDriver extends RemoteWebDriver --> implements WebDriver

        driver.get("http://google.com");    // to open a website

        Thread.sleep(3000); // for demo, wait 3 seconds // add throws declaration, too!!!

        String title=driver.getTitle(); // returns title of the page(returns <title>whatever </title> text)
        String expectedTitle= "Google";

        System.out.println("title is : "+title);
        if(expectedTitle.equals(title)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.close(); // to close browser// browser cannot close itself





    }
}
