package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {
    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        actions= new Actions(driver);

    }
  //******************************************************************************************************
  @Test
  public void hoverOnImage(){
      driver.get("http://practice.cybertekschool.com/hovers");
      driver.manage().window().maximize();
      BrowserUtils.wait(3);
      WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
      WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
      WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

      actions.moveToElement(img1).pause(1000).moveToElement(img2).pause(1000).moveToElement(img3).build().perform();
      // build() is needed when you have couple of actions
      // always end with perform()
      // we can chain methods
      //  moves to first image- pause- move to the second - pause - move to the third image

    // hover on the first image
      // verify that "name: user1" is dispalyed

      actions.moveToElement(img1).perform();
      // hover over image to make text visible
      WebElement imgText1 =  driver.findElement(By.xpath("//h5[text()='name: user1']"));
      Assert.assertTrue(imgText1.isDisplayed());
      // verify that webelement that contains the text is visible



  }






    //******************************************************************************************************
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
