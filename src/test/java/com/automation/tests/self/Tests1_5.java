package com.automation.tests.self;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests1_5 {

   private WebDriver driver;
   private String URL= "https://practice-cybertekschool.herokuapp.com/";
   private By registrationBy= By.linkText("Registration Form");
   private By birthdayBy= By.name("birthday");
   private By cplusBy= By.xpath("//label[@for='inlineCheckbox1']");
   //By.id("inlineCheckbox1");
   private By javaBy= By.xpath("//label[@for='inlineCheckbox2']");
    // By.id("inlineCheckbox2");
   private By javaSBy= By.xpath("//label[@for='inlineCheckbox3']");
   // By.id(inlineCheckbox3);
   private By firstNameBy= By.name("firstname");
   private By lastNameBy= By.name("lastname");
   private By userNameBy= By.name("username");
   private By email= By.name("email");
   private By passwordBy = By.name("password");
   private By phoneBy= By.name("phone");
   private By female= By.xpath("//input[@value='female']");
   // By.cssSelector("input[value='female']");
   private By department= By.name("department");
   private By job = By.name("job_title");
   private By signUp= By.id("wooden_spoon");

   //****************************************************************************************************

    @Test
    public void testCase1(){
    driver.findElement(birthdayBy).sendKeys("wrong_dob");
    WebElement  wrongDOBMessage=
                     driver.findElement(By.xpath("//small[contains(text(), 'is not valid')]"));
        assertTrue(wrongDOBMessage.isDisplayed());
        BrowserUtils.wait(2);
    }

//****************************************************************************************************

    @Test
    public void testCase2(){
    WebElement cplus= driver.findElement(cplusBy);
    assertTrue(cplus.isDisplayed());
    WebElement java=driver.findElement(javaBy);
    assertTrue(java.isDisplayed());
    WebElement javaScript= driver.findElement(javaSBy);
    assertTrue(javaScript.isDisplayed());

    }
//*******************************************************************************************************

    @Test
    public void testCase3(){
    driver.findElement(firstNameBy).sendKeys("d");
    WebElement firstnameMessage= driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));

    // BrowserUtils.wait(3);
    // System.out.println(firstnameMessage.getText());

        assertTrue(firstnameMessage.isDisplayed());
        BrowserUtils.wait(2);

    }

//*******************************************************************************************************

    @Test
    public void testCase4(){
    driver.findElement(lastNameBy).sendKeys("a");
      WebElement lastnameMessage= driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        // BrowserUtils.wait(3);
        // System.out.println(lastnameMessage.getText());

        assertTrue(lastnameMessage.isDisplayed());
        BrowserUtils.wait(2);
    }


//*******************************************************************************************************

    @Test
    public void testCase5(){
    driver.findElement(firstNameBy).sendKeys("Mary");
    driver.findElement(lastNameBy).sendKeys("Smith");
    driver.findElement(userNameBy).sendKeys("MarySmith");
    driver.findElement(email).sendKeys("marysmith@yahoo.com");
    driver.findElement(passwordBy).sendKeys("Mary12345");
    driver.findElement(phoneBy).sendKeys("123-456-7890");
    driver.findElement(female).click();
    driver.findElement(birthdayBy).sendKeys("10/10/2000");

    Select departmentChoose= new Select(driver.findElement(department));
    departmentChoose.selectByVisibleText("Tourism Office");

    Select jobTitle= new Select(driver.findElement(job));
    jobTitle.selectByVisibleText("QA");
    //jobTitle.selectByIndex(5);

    driver.findElement(javaBy).click();
    driver.findElement(signUp).click();

    String actual= driver.findElement(By.tagName("p")).getText();
    //
    String expected = "You've successfully completed registration!";

    assertEquals(actual,expected);

    }

//************************************************************************************
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(registrationBy).click();
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
