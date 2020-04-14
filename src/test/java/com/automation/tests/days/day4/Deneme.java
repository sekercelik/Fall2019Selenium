package com.automation.tests.days.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Deneme {
    private static WebDriver driver;

    public static void main(String[] args){
      //  WebDriver driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        try {
            driver.get("https://ebay.com");
            Thread.sleep(3000);
            String title = driver.getTitle();
            System.out.println("title: "+title);
            WebElement searchBar=driver.findElement(By.xpath("//input[@placeholder=\"Search for anything\"]"));
            searchBar.sendKeys("macbook pro");
            WebElement searchButton=driver.findElement(By.id("gh-btn"));
            searchButton.click();

            List<WebElement> urunler=driver.findElements(By.xpath("//h3//span[@class=\"BOLD\"]"));
            for (int i = 0; i <urunler.size() ; i++) {
                System.out.println(urunler.get(i).getText());
            }
            Thread.sleep(4000);
        }catch (Exception e){
            e.getStackTrace();
        }
        driver.close();

    }
}
