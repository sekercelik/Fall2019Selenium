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

public class SelfStudy {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    }
    //*****************************************************************************************************************
        @Test
        public void updateSamuelCity(){

        WebElement city= driver.findElement(By.xpath("//table//tbody//tr[8]//td[7]"));
            System.out.println("city before: "+city.getText()); // get Samuel's city
            BrowserUtils.wait(2);

        WebElement zip = driver.findElement(By.xpath("//table//tbody//tr[8]//td[9]"));
            System.out.println("zip before: "+zip.getText());
            driver.findElement(By.xpath("//table//tbody//tr[8]//td[13]")).click();//the following xpath is working,too
        //  driver.findElement(By.xpath(" //td[text()='Samuel Clemens']//following-sibling::td/input")).click();
            BrowserUtils.wait(2);
          WebElement newcity=  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
          newcity.clear();
          BrowserUtils.wait(2);

           String expectedMessage="Field 'City' cannot be empty.";
           String actualMessage = driver.findElement(By.id("ctl00_MainContent_fmwOrder_RequiredFieldValidator4")).getText();
            System.out.println(actualMessage);
            Assert.assertEquals(actualMessage,expectedMessage);

            newcity.sendKeys("duluth,ga");

            WebElement zipUpdate= driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
            zipUpdate.clear();
            BrowserUtils.wait(2);

            String expectedZipMessage ="Field 'Zip' cannot be empty.";
            String actualZipMessage = driver.findElement(By.id("ctl00_MainContent_fmwOrder_RequiredFieldValidator5")).getText();
            System.out.println(actualZipMessage);
            Assert.assertEquals(actualZipMessage,expectedZipMessage);
            BrowserUtils.wait(3);

            zipUpdate.sendKeys("30000");
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();


            BrowserUtils.wait(4);



        }






 //*****************************************************************************************************************
@AfterMethod
    public void teardown(){
        driver.quit();
}

}
