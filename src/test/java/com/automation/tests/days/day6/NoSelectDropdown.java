package com.automation.tests.days.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        //INTERVIEW QUESTION
//From selenium perspective there are 2 types of dropdowns : select and other
//To handle select drop-downs, use Select class from selenium
//In case of any other dropdown, just click on, wait until options become visible and click on the option
//how to determine which option is drop down and which is not?
//just look at tag name, if it is select than dropdown type is select
        //dropdown link-> it is not select based
        //find locator for the button first
        // then click
        //everything inside is a link
        //

        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(2);

       List<WebElement> allLinks= driver.findElements(By.className("dropdown-item"));
       for(WebElement link : allLinks){
           System.out.println(link.getText()+ " : "+ link.getAttribute("href"));
       }
       BrowserUtils.wait(3);

        driver.findElement(By.linkText("Amazon")).click();


//        BrowserUtils.wait(2);
//        driver.findElement(By.linkText("Google"));



        BrowserUtils.wait(3);
       driver.quit();

    }
}
