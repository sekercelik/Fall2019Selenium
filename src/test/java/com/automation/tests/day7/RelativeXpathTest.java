package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpathTest {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);

     //   WebElement warning2= driver.findElement(By.xpath("//div[@class='errortext']"));  //OR
        WebElement warning2= driver.findElement(By.xpath("//*[@class='errortext']"));
        // * means any // used instead of tagname
        System.out.println(warning2.getText());

        driver.quit();



    }
}
