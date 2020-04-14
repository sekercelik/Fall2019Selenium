package com.automation.tests.days.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        //<input type="radio" id="black" name="color">
        WebElement blackB= driver.findElement(By.id("black"));

        //if visible and eligible to click
        if(blackB.isDisplayed() && blackB.isEnabled()){
            System.out.println("CLICKED ON BLACK BUTTON");
            blackB.click();
        }else {
            System.out.println("FAILED TO CLICK ON BLACK BUTTON");
        }


        blackB.click();

        // how do we verify that button is clicked?
        if(blackB.isSelected()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }


        driver.quit();

    }
}
