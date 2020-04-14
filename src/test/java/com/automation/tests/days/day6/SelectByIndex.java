package com.automation.tests.days.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        Select stateSelect= new Select(driver.findElement(By.id("state")));

        // index starts form 0,
        stateSelect.selectByIndex(12);
        BrowserUtils.wait(3);

     //   stateSelect.selectByIndex(stateSelect.getOptions().size()-1);


        List<WebElement> stateLst = stateSelect.getOptions();
        int count = 0;
        for (WebElement eachState: stateLst) {
            count++;
            System.out.println( count + " = " +eachState.getText());
        }






        BrowserUtils.wait(3);
        driver.quit();


    }
}
