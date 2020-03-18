package com.automation.tests.vytrack.fleet;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class VehiclesPageTests {
/*######## TASK
under fleet package create a class called VehiclesPageTests
In this class, you will need to create @beforemethod with setup and @aftermethod with teardown part.
 Use LoginPageTests class as a reference.

create a test called verifyPageSubTitle

    - in this test, you will need to navigate to Fleet --> Vehicles and verify that page subtitle is equals to "All Cars"
    user assertions for validation.
*/

    private String URL = "https://qa2.vytrack.com/user/login";
    //    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    private WebDriver driver;

    private By pageNumBy= By.cssSelector("input[type='number']");


//*************************************************************************************************************

    @Test
    public void verifyPageSubTitle(){
      // bu class ta iki test yaptim cogu seyi ortak oldugu icin ortak olan yerleri before methodun icine koydum!!!
    //************* ORRR ***********************
        // there is Actions class, you can use that, too
        // it is used for more advanced browser interactions
//         Actions actions= new Actions(driver);
//         actions.moveToElement(driver.findElement(fleetBy)).perform();
        // it will move to element instead of clicking
        //perform is to execute command
        // every action should end with perform

        //find subtitle element
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());

        String actual= subTitleElement.getText();
        String expected="All Cars";

        assertEquals(actual,expected);

    }
//**************************************************************************************************

    @Test
    public void verifyPageNumber(){
        String expected= "1";
        String actual= driver.findElement(pageNumBy).getAttribute("value");
        assertEquals(actual,expected);

    }

    //*****************************************************************************************

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver= new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        //put more wait here as well, if didn't click
        BrowserUtils.wait(5);
        //click on fleet
        driver.findElement(fleetBy).click();
        BrowserUtils.wait(2);

        //click on Vehicles
        driver.findElement(By.linkText("Vehicles")).click();
        //put more wait time if you are getting Cars, Dashboard...
        //this application is slooooow...
        BrowserUtils.wait(5);

    }

    @AfterMethod
    public void teardown(){
        if(driver != null){  // if web driver object alive
            driver.quit();    // close browser, close session
            driver = null;    // destroy webdriver object for sure
        }
    }



}
