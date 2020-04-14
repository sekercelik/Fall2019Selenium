package com.automation.tests.vytrack.self;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LogIn {
    private WebDriver driver;
    private Actions actions;
    private String URL= "https://qa2.vytrack.com/user/login";
    //odometer info page ==>  https://qa2.vytrack.com/entity/Extend_Entity_VehiclesOdometer
    private String driverUsername= "user39";  // "user40";  "user41";
    private String driverPassword= "UserUser123";

private By userBy= By.id("prependedInput");
private By passBy= By.id("prependedInput2");
private By login= By.name("_submit");

    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
private By vehicleOdometer = By.xpath("//span[@class='title title-level-2' and contains(text(),'Vehicle Odometer')]");
private By tablo = By.className("grid-scrollable-container scrollbar-is-visible");

@BeforeMethod
public void setup(){
     WebDriverManager.chromedriver().version("79").setup();
    driver= new ChromeDriver();
    actions= new Actions(driver);
    driver.get(URL);
    driver.manage().window().maximize();
    BrowserUtils.wait(3);
    driver.findElement(userBy).sendKeys(driverUsername);
    driver.findElement(passBy).sendKeys(driverPassword);
    driver.findElement(login).click();
    BrowserUtils.wait(2);
}
//******************************************************************************************

    @Test
    public void seeOdometerInformation(){

    driver.findElement(fleetBy).click();
 WebElement vOdometer=  driver.findElement(vehicleOdometer);
 actions.moveToElement(vOdometer).click().perform();
 BrowserUtils.wait(10);


}






//******************************************************************************************
@AfterMethod
    public void teardown(){
    if(driver != null){
      driver.quit();
      driver= null;
    }
}

}
