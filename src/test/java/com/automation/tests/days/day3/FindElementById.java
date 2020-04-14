package com.automation.tests.days.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");

        driver.findElement(By.name("username")).sendKeys("tomsmith");

        Thread.sleep(3000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");
        // OR
     //   driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);

        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String actual= driver.findElement(By.tagName("h4")).getText(); // to verify if tag is unique, put // infront of tag
                                                                        //  Like h4 in search box(open the box: it ctrl+f)

        if(expected.equals(actual)){
            System.out.println("Test Passed");

        }else{
            System.out.println("Test Failed");
        }

      // let's click on logout button. it looks like a button, but it's actually a link
      // every element with <a> tag is a link
      // if you have couple spaces in the text, just use partialLinkText
      // linkText        --> is like  equals method , requires exact match
      // partialLinkText -->  is like contains method , should be present ,complete match is not required
      // don't put space

        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        //WebElement logout = driver.findElement(By.linkText("Logout"));
        String href = logout.getAttribute("href");
        String className = logout.getAttribute("class");

        System.out.println(href);
        System.out.println(className);
        logout.click();

        Thread.sleep(2000);
        //let's enter invalid credentials

        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.id("flash-messages"));

        System.out.println(errorMessage.getText());


        Thread.sleep(2000);


       driver.quit();
    }
}
