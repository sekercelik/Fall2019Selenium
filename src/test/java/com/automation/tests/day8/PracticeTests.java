package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTests {
    private WebDriver driver;

 /*   Create a class called PracticeTests
- setup before/after methods
	- in before method. instantiate webdriver and navigate to: http://practice.cybertekschool.com/
            - in after method - just close webdriver.
- create a test called loginTest
	- go to “Form Authentication” page
	- enter valid credentials
	userName: tomsmith
	password: SuperSecretPassword

	- verify that following sub-header message is displayed: “Welcome to the Secure Area. When you are done click logout below.”
*/
/*
* WebDriverManager.chromedriver().version("79").setup();
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(chromeOptions);
* */

    /**
     * We put @Test annotation to make methods executable as tests
     */
    @Test//create a test called loginTest
    public void loginTest() {
        //go to "Form Authentication" page
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(3);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        //if assertion fails - it will throw exception and message will be printed
        //3 parameters: (expected, actual, "message in case of error")
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");


    }

    //**********************************************************************************************
    @Test
    public void forgotPasswordTest() {
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("email")).sendKeys("ebvabetul@gmail.com", Keys.ENTER);
        BrowserUtils.wait(2);
        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_message")).getText();

        Assert.assertEquals(actual, expected, "Confirmation message is not matching");


    }
//*******************************************************************************************************

    /**
     * TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Checkboxes" page
     * And clicks on checkbox #1
     * Then user verifies that checkbox #1 is selected
     */
    @Test
    public void checkboxTest1() {

        driver.findElement(By.linkText("Checkboxes")).click();
        //collect all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(4);

        checkboxes.get(0).click();//to click on 1st checkbox

        Assert.assertTrue(checkboxes.get(0).isSelected(), "Checkbox #1 is not selected!");


        //*********** another way to solve it **************************************
//        @Test
//        public void checkboxTest(){
//            driver.get("http://practice.cybertekschool.com/checkboxes");
//            WebElement check1=driver.findElements(By.tagName("input")).get(0);
//            check1.click();
//            BrowserUtils.wait(2);
//            Assert.assertTrue(check1.isSelected());
//        }


//***********************************************************************************************
//        @BeforeMethod
//        public void setup(){
//            //setup webdriver
//            WebDriverManager.chromedriver().version("79").setup();
//            driver = new ChromeDriver();
//            driver.get("http://practice.cybertekschool.com/");
//            driver.manage().window().maximize();
//        }
//
//        public void teardown(){
//            driver.quit();
//        }

/*   @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        //provide chromeOptions object into chromedriver constructor
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    // if website doesn't have certificate , browser will show warning
    // data will be stolen easily
    //
*
* */


    }
}