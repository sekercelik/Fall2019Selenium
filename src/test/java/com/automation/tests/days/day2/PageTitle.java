package com.automation.tests.days.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTitle {
    public static void main(String[] args) throws Throwable {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();

        driver.manage().window().fullscreen();
        driver.get("https://google.com");
        Thread.sleep(4000);
        String title= driver.getTitle();
        System.out.println(title);






        driver.close();




    }
}
