package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons= driver.findElements(By.tagName("button"));
        buttons.get(0).click(); // to click on the first button
        BrowserUtils.wait(3);

        String popupText=driver.switchTo().alert().getText();// to get the text inside the opening box
        System.out.println(popupText);

        driver.switchTo().alert().accept();  // to click ok

        String expected= "You successfully clicked an alert";
        String actual= driver.findElement(By.id("result")).getText();

        if(expected.equals(actual)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
            System.out.println("Expected: "+ expected);
            System.out.println("Actual: "+ actual);
        }
        BrowserUtils.wait(3);
//****************************************************************************************************

        buttons.get(1).click(); // to click on the second
        BrowserUtils.wait(3);

        driver.switchTo().alert().dismiss();  // to click cancel

        String expectedForCancel= "You clicked: Cancel";
        String actualForCancel= driver.findElement(By.id("result")).getText();

        if(expectedForCancel.equals(actualForCancel)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("expectedForCancel: "+ expectedForCancel);
            System.out.println("actualForCancel: "+ actualForCancel);

        }
        BrowserUtils.wait(3);

//***************************************************************************************************
        //TASK click on button #3
        //Enter some text: Hello, World!
        //Verify that result text ends with Hello, World!

        buttons.get(2).click(); // to click on the second
        BrowserUtils.wait(3);

//        Alert alert= driver.switchTo().alert();
//        alert.sendKeys("Hello,World");  // to click cancel
//        alert.accept();
//          //OR
        driver.switchTo().alert().sendKeys("Hello,World");
        driver.switchTo().alert().accept();


        String expected3 ="You entered: hello, world ";
        // this will fail. because it should be :you entered: Hello,World

        String actual3= driver.findElement(By.id("result")).getText();

        if(expected3.endsWith(actual3)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println( "expected3: "+expected3);
            System.out.println("Actual3: " + actual3);
        }


    BrowserUtils.wait(5);
    driver.quit();
    }
}
