package com.automation.tests.days.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        Select stateSelect= new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("DC");

        String expected= "District Of Columbia";
        String actual= stateSelect.getFirstSelectedOption().getText();
       // returns a webelement, so we need to call getText(), method, to be able to compare it with a String
//        if(expected.equals(actual)){
//            System.out.println("Test Passed");
//        }else{
//            System.out.println("Failed");
//        }
        System.out.println(expected.equals(actual)? "Passed" : "Failed");












        BrowserUtils.wait(3);
        driver.quit();


    }
}
