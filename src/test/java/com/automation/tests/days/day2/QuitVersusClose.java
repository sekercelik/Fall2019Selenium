package com.automation.tests.days.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVersusClose {
    public static void main(String[] args)throws Exception {

        //quit closes all the opened windows by driver
        // close only closes one particular window

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
       // driver.close();   // closes one window
        driver.quit();      // closes all the windows



    }
}
