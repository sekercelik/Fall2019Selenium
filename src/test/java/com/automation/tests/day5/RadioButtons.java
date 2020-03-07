package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        // Thread.sleep(2000); // we created a method in BrowserUtils to use instead of thread.sleep
        // we included try catch to prevent appliying throws Exception again and again
        BrowserUtils.wait(2); //calling the method in BrowserUtils instead of Thread.sleep

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));
        for (WebElement radioButton : radioButtons) {      // to click them one by one
            //to check if button can be clicked

            String id = radioButton.getAttribute("id");

            boolean isSelected = radioButton.isSelected();  // returns true is it is already selected
            System.out.println(id+ " is selected?: "+ isSelected);

            // isEnabled==> returns true if button is eligible to click
            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("clicked on : " + id);
                BrowserUtils.wait(1);
            } else {
                System.out.println("button is disabled, not clicked: " + id);
            }
            System.out.println();
        }
            driver.quit();

        }
    }

