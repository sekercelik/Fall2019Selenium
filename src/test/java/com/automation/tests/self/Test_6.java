package com.automation.tests.self;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_6 {
    private WebDriver driver;

    @Test
    public void testCase6(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.tempmailaddress.com/"); // step 1
        String email= driver.findElement(By.id("email")).getText(); //step 2

        BrowserUtils.wait(4);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");// step  3
        driver.findElement(By.linkText("Sign Up For Mailing List")).click(); // step 4

        BrowserUtils.wait(4);

        driver.findElement(By.name("full_name")).sendKeys("Mary Smith"); // step 5
        driver.findElement(By.name("email")).sendKeys(email); //step6

        BrowserUtils.wait(4);

        driver.findElement(By.className("radius")).click(); //step7
        BrowserUtils.wait(4);

        WebElement message= driver.findElement(By.name("signup_message")); // step 8
        System.out.println("message: "+message.getText());

        Assert.assertTrue(message.isDisplayed());//8
        BrowserUtils.wait(4);


        driver.navigate().to("https://www.tempmailaddress.com/"); //step 9
        BrowserUtils.wait(4);

        //step 10
      //WebElement received = driver.findElement(By.xpath("//td[text()='Thanks for subscribing to practice.cybertekschool.com!']"));
        WebElement received = driver.findElement(By.xpath("//td[text()='do-not-reply@practice.cybertekschool.com']"));
        Assert.assertTrue(received.isDisplayed());

        received.click();  // step11
        BrowserUtils.wait(4);

        String fromWho= driver.findElement(By.id("odesilatel")).getText(); // step 12
        String expected ="do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(fromWho,expected);

        String actualSubject= driver.findElement(By.id("predmet")).getText(); // step 13
        String expectedSubject= "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualSubject,expectedSubject);

        driver.quit();


    }

}
