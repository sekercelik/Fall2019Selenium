package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigationSelf {
    public static void main(String[] args) throws Throwable {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();

        String a= "https://google.com";
        String b= "https://amazon.com";
        String c= " https://etsy.com";


        driver.get(a);
        Thread.sleep(4000);
        verifyEqual(driver.getTitle(),"google");


        driver.navigate().to(b);
        Thread.sleep(4000);
        //System.out.println("second page:  "+driver.getTitle());
        verifyEqual(driver.getTitle(),"amazon");

        driver.navigate().to(c);
        System.out.println("navigate.to:  "+driver.getTitle());
        Thread.sleep(4000);

        driver.navigate().back();
        System.out.println("navigate back:  "+driver.getTitle());
        Thread.sleep(4000);

        driver.navigate().forward();
        System.out.println("navigate forward:  "+ driver.getTitle());
        Thread.sleep(4000);

        driver.navigate().refresh();
        Thread.sleep(4000);
        System.out.println("refresh:  "+ driver.getTitle());
        driver.quit();

     //   driver.close();


    }

        public static void verifyEqual(String str1,String str2){
        if(str1.equalsIgnoreCase(str2)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        }

}
