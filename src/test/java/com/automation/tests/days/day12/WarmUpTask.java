package com.automation.tests.days.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WarmUpTask {
    private WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }
//******************************************************************************************************************

    /**
     * Go to http://practice.cybertekschool.com/tables
     * Click on "Last name" column name
     * Verify that table is sorted by last name in alphabetic order.
     * <p>
     * The Java String compareTo() method is used for comparing two strings lexicographically.
     * Each character of both the strings is converted into a Unicode value for comparison.
     * If both the strings are equal then this method returns 0 else it returns positive or negative value.
     * The result is positive if the first string is lexicographically greater than
     * the second string else the result would be negative.
     * <p>
     * This method is coming from Comparable interface.
     * If you want to be able to sort collection of some class
     * you need to implement this interface
     * and override compareTo method
     * <p>
     * "a".compareTo("b") = -1
     * <p>
     * 61 - 62 = -1
     * <p>
     * a is before b
     * <p>
     * "a".compareTo("a")
     * <p>
     * 61 - 61 = 0
     * <p>
     * 0 means 2 strings are equals
     */
    @Test
    public void test() {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        //click on column name
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(2);
        //collect all values from the first column
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i < column.size() - 1; i++) {
            //take a string
            String value = column.get(i).getText();
            //take a following string
            String nextValue = column.get(i + 1).getText();

            System.out.println(value.compareTo(nextValue));

            //if difference is negative - order value is before nextValue in alphabetic order
            //if difference is positive - order value is after nextValue in alphabetic order
            //if difference is 0 - value and nextValue are equals
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }
        driver.quit();
    }

    /*List<WebElement> lst=driver.findElements(By.xpath("//table[1]//tr//td[1]"));
        List<String> lastNames=BrowserUtils.getTextFromWebElements(lst);
        List<String> listSorted=lastNames;
        Collections.sort(listSorted);
        driver.findElement(By.xpath("//table[1]//span[text()='Last Name']")).click();
        Assert.assertEquals(lastNames,listSorted);
     */

   /*@Test
public void test2(){
    List<String> list = BrowserUtils.getTextFromWebElements(driver.findElements(lastNameBy));
    System.out.println(list);
    boolean actual = true;
    for (int i = 0; i <list.size()-1 ; i++) {
        if(list.get(i).charAt(0)<list.get(i+1).charAt(0)){
            actual = false;
        }
    }
    Assert.assertFalse(actual);
}
*/

//******************************************************************************************************************
    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }

}
