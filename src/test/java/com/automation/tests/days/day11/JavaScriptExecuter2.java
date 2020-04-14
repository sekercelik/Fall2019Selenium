package com.automation.tests.days.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuter2 {
 private WebDriver driver;

 @BeforeMethod
    public void setup(){
     driver= DriverFactory.createDriver("chrome");
     driver.get("http://practice.cybertekschool.com/");
     driver.manage().window().maximize();
 }


 @Test
 public void verifyTitle(){
     String expected ="Practice";
     JavascriptExecutor js= (JavascriptExecutor) driver; // we create javascriptexecutor object by casting webdriver obj
     // we need to cast it to javascriptExecuter
     // now we switched from webdriver to js
     // after we cast it we will see methods of jse
     String actual = (String) js.executeScript("return document.title");
     // executeScript is a method
     // we provide js code as a string ==> "return document.title"
        //ORR you can use .toString()- to avoid additional casting from Object to string
    // String actual = js.executeScript("return document.title").toString();
     Assert.assertEquals(actual,expected);
 }

//********************************************************************************************************************
    @Test
    public void clickTest(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
      //  link.click(); ==> disable this click action to perform it with js executor
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", link);
        //after "" you can list webElements that will be used
        //as part of your javascript code
        //it's varargs, so you can list 0+
        //arguments - listed after ,
        //use index to get specific webelement
        // WebElement arguments = {element, link, link2};
        //from left - to right
        // if nothing works with java, you can use java script executer

        WebElement button6= driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()", button6);
        // once declare et elementi bularak
        // sonra onu argument olarak icine at jsexecuter'in
        // onun onune de indexi belirterek click yap

        BrowserUtils.wait(4);

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "Now it's gone!");


        // js.executeScript("arguments[1].click()", link, button6); // bu button 6'ya click yapar
        // js.executeScript("arguments[0].click()", link, button6); // bu link'e click yapar
    }
    //****************************************************************************************************************
    @Test
    public void textInputTest(){
     driver.findElement(By.linkText("Form Authentication")).click();
     BrowserUtils.wait(3);

     WebElement username = driver.findElement(By.name("username"));
     WebElement password = driver.findElement(By.name("password"));
     WebElement loginbtn=driver.findElement(By.id("wooden_spoon"));

     //to get text from input box==>  read attribute "value"
    // to enter text ==> set attribute "value"
     JavascriptExecutor userPass = (JavascriptExecutor) driver;
     userPass.executeScript("arguments[0].setAttribute('value', 'tomsmith')",username);
     userPass.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')",password);
     userPass.executeScript("arguments[0].click()",loginbtn);
     BrowserUtils.wait(4);

     String expected="Welcome to the Secure Area. When you are done click logout below.";
    String message= userPass.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();
    Assert.assertEquals(message,expected);

    }
    //****************************************************************************************************************

@Test
public void scrollToElement(){
     BrowserUtils.wait(4);
     WebElement link =driver.findElement(By.linkText("Cybertek School"));

     JavascriptExecutor js = (JavascriptExecutor) driver;

     js.executeScript("arguments[0].scrollIntoView(true)",link);


}
//****************************************************************************************************************
    @Test
    public void scrollTest(){
     driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
     JavascriptExecutor js= (JavascriptExecutor) driver;

        for (int i = 0; i <15 ; i++) {
            js.executeScript("window.scrollBy(0,1000)");
            BrowserUtils.wait(2);
        }

    }
    // bu metot 15 kere scroll yapacak..

//****************************************************************************************************************

@AfterMethod
    public void teardown(){
    BrowserUtils.wait(2);
     driver.quit();
}


}
