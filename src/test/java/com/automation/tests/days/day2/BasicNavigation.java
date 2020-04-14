package com.automation.tests.days.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{


    // to start selenium script we need :
   // setup web driver (browser driver) and create webdriver object
   // for every browser we have corresponding driver

        WebDriverManager.chromedriver().setup(); // we just call it here
        WebDriver driver= new ChromeDriver(); //WebDriver is interface//  ChromeDriver is a class
    //    FirefoxDriver driver =new FirefoxDriver(); // or RemoteWebDriver driver =new FirefoxDriver();

    // in selenium everything starts from WebDriver interface
    // ChromeDriver extends RemoteWebDriver --> implements WebDriver

        driver.get("http://google.com");    // to open a website
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen(); // we don't use it usually

        Thread.sleep(3000); // for demo, wait 3 seconds // add throws declaration, too!!!

        String title=driver.getTitle(); // returns title of the page(returns <title>whatever </title> text)
        String expectedTitle= "Google";

        System.out.println("title is : "+title);
        if(expectedTitle.equals(title)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        // go to another website within the same window
        driver.navigate().to("https://amazon.com");

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.navigate().back();   // comeback to google
        verifyEquals(driver.getTitle(),"Google"); // checking if page title is equal to Google
        //checking if page title is equals to Google
        //.getTitle() - returns page title
        verifyEquals(driver.getTitle(), "Google");
        //move forward in the browser history
        //again, going to amazon
        driver.navigate().forward();
        Thread.sleep(3000);//for demo, wait 3 seconds
        System.out.println("Title: "+driver.getTitle());
        //driver.getTitle() - returns page title of the page that is currently opened
        System.out.println("URL: "+ driver.getCurrentUrl());

        driver.navigate().refresh();//to reload page
        Thread.sleep(3000);//for demo, wait 3 seconds
        //driver.navigate().to() = driver.get()
        //must be at the end
        driver.close(); // to close browser// browser cannot close itself


    }

    //check if two strings are the same, if print Test Passed
    //Otherwise print Test Failed
    public static void verifyEquals(String arg1, String arg2){
        if (arg1.equals(arg2)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
    }


}
