package com.automation.tests.days.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        //we have to setup webdriver bsed on the browser that we gonna use
        //old way of confuguring webdriver:
      //  System.setProperty("webdriver.chrome.driver","/path/chromedriver");

        //better way to set up web driver:
        //setup chromedriver
        WebDriverManager.chromedriver().setup();
        //create chromedriver object
        ChromeDriver driver = new ChromeDriver();

        //open some website
        driver.get("http://google.com");

        // to read page title use method==>  .getTitle()

        System.out.println(driver.getTitle());

        driver.close();

    }
}
