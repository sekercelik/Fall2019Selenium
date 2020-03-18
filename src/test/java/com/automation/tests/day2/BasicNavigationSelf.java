package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigationSelf {
    public static void main(String[] args) throws Throwable {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();

        String a= "http://google.com";
        String b= "http://amazon.com";
        String c= " http://etsy.com";


        driver.get(a);
        Thread.sleep(4000);
        verifyEquals(driver.getTitle(),"google");


        driver.navigate().to(b);
        Thread.sleep(4000);
        //System.out.println("second page:  "+driver.getTitle());

        if(driver.getTitle().toLowerCase().contains("amazon")){ // will pass/ cunku title'da amazon var
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        verifyEquals(driver.getTitle(),"Amazon");   // neden hata veriyor?/cunku title equals amazon degil../
        // title=> Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more

        driver.navigate().to(c);
        Thread.sleep(4000);
        verifyEquals(driver.getTitle(),"etsy"); // will fail because: title is
      //  title=> Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone
        System.out.println("navigate.to:  "+driver.getTitle());


        driver.navigate().back();
        Thread.sleep(4000);
        System.out.println("navigate back:  "+driver.getTitle());


        driver.navigate().forward();
        System.out.println("navigate forward:  "+ driver.getTitle());
        Thread.sleep(4000);

        driver.navigate().refresh();
        System.out.println("refresh:  "+ driver.getTitle());

      //  driver.quit();

        driver.close();


    }

        public static void verifyEquals(String str1,String str2){
        if(str1.equalsIgnoreCase(str2)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        }

}
