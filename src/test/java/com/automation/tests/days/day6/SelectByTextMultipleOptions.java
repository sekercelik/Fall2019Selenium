package com.automation.tests.days.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languages =new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple= languages.isMultiple();
        System.out.println(isMultiple);
        languages.selectByVisibleText("Java");
        languages.selectByVisibleText("JavaScript");
        languages.selectByVisibleText("Python");

        // how to verify these options are selected
        // let's get all selected options

        List<WebElement> selectedLanguages= languages.getAllSelectedOptions();
        for(WebElement selectedOnes : selectedLanguages){
            System.out.println("selected: "+selectedOnes.getText());
        }

        languages.deselectByVisibleText("Python"); // it will deselect Python
        BrowserUtils.wait(1);
        languages.deselectAll(); // will deselect all
        BrowserUtils.wait(1);






        BrowserUtils.wait(3);
        driver.quit();

    }
}
