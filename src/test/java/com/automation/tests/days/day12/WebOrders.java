package com.automation.tests.days.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

private WebDriver driver;

@BeforeMethod
    public void setup(){
    driver= DriverFactory.createDriver("chrome");
    driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders");
    driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
    driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

}

@Test
public void checkBoxTest(){
    driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
    BrowserUtils.wait(2);
    List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
    for (WebElement checkbox : checkboxes) {
        Assert.assertTrue(checkbox.isSelected());
    }
}
//*****************************************************************************************************************
/** Go to web orders page
 * Verify that Steve Johns zip code is 21233
 * Then update his zip code to 20002
 * Then verify that Steve Johns zip code is 20002
 */
@Test
public void updateZipCode(){
    WebElement zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
    Assert.assertEquals(zipcode.getText(), "21233");

    //click on update image

    driver.findElement(By.xpath(" //td[text()='Steve Johns']//following-sibling::td/input")).click();

    WebElement zipcodeInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

    zipcodeInput.clear();
    zipcodeInput.sendKeys("20002");

    driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

    zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
    Assert.assertEquals(zipcode.getText(), "20002");
}


@AfterMethod
public void teardown(){
    driver.quit();
}



}
