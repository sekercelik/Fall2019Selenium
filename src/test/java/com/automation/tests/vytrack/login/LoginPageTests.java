package com.automation.tests.vytrack.login;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
// this is static import of all assertions
// with this; you don't need to call Assert class, just use methods directly


public class LoginPageTests {
    private WebDriver driver;
    private String URL= "https://qa2.vytrack.com/user/login";
    //https  -->  is secured version of http protocol
    // http  -->  is hypertext transfer protocol that every single website is using nowadays
    // https --> data encrypted, no chance for hackers to retrieve info
    // http  --> data as plain text, very easy to hack it

    private String username= "storemanager85";  // credentials for store manager
    private String password ="UserUser123";

    private By usernameBy= By.id("prependedInput");
    // By is actually a class,when you look for something with By, it returns object of By

    private By passwordBy=By.id("prependedInput2");
    private By warningMessageBy= By.cssSelector("[class='alert alert-error']>div");
    // > greater sign means go to child in css

//******************************************************************************************************


    @Test(description = "Verify that warning message displays when user enters invalid username")
    public void invalidUsername(){
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(5);

        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual, expected);
    }

//*******************************************************************************************************************

    @Test(description="Login as store manager and verify that title is equals to Dashboard")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password,Keys.ENTER);
        BrowserUtils.wait(5);

        String expected= "Dashboard";
        String actual= driver.getTitle();
        assertEquals(actual,expected,"Page title is not correct!");
    }





//****************************************************************************************************

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver= new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        if(driver != null){  // if web driver object alive
            driver.quit();    // close browser, close session
            driver = null;    // destroy webdriver object for sure
        }
    }


}
