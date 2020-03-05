package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
//we are writing same codes again and again
//we will write a method and call it : DRY Principle
//sth that support our code : utilities
//under automation package
//We created utilities package and DriverFactory class under automation package
//we wrote reusable methods inside DriverFactory class named => createDriver
//whenever we need to crate webDriver object
//we will call our custom method
    /*  this method returns webdriver object based on browser type
    * if you want to use chrome browser, just provide chrome as a parameter
    * * @param browserName
     * @return webdriver object
     * */
    /**
     * You homework will be to improve this method!
     * This method return webdriver object based on browser type
     * If you want to use chrome browser, just provide chrome as a parameter
     * @param browserName
     * @return webdriver object
     */
    public static WebDriver createDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    }
}
