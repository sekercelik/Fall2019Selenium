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

      //move to the second image
      BrowserUtils.wait(3);

      actions.moveToElement(img2).perform();
      WebElement imgText2= driver.findElement(By.xpath("//h5[text()='name: user2']"));
      Assert.assertTrue(imgText2.isDisplayed());
  }

    //******************************************************************************************************

  @Test
  public void jqueryMenuTest(){
    //hover on enabled
    // hover on downloads
    // click on PDF

      driver.get("https://practice-cybertekschool.herokuapp.com/jqueryui/menu");
        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        actions.moveToElement(enabled).pause(1000).moveToElement(downloads).pause(1000).click(pdf).build().perform();

  }
    //******************************************************************************************************

    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@title='Accept Cookies']")).click();
        BrowserUtils.wait(3);

        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));
        actions.dragAndDrop(moon,earth).perform();

        String expected ="You did great!";
        String actual =earth.getText();

        Assert.assertEquals(actual,expected);
        //a different approach
       // actions.clickAndHold(moon).pause(2000).moveToElement(earth).pause(1000).release().build().perform();

    }
    //******************************************************************************************************



    //******************************************************************************************************
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
