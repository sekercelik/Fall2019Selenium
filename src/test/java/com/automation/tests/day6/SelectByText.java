package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

       // WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        //create a web element object for drop-down first
        WebElement simpleDropdown= driver.findElement(By.id("dropdown"));
        Select selectSimpleDropdown=new Select(simpleDropdown);  // select class from selenium
                                    //pass webElement object as parameter

        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        selectSimpleDropdown.selectByVisibleText("Option 1");

      //******************************************************************************

      Select selectYear = new Select(driver.findElement(By.id("year")));
      // we can us eit this way in on eshot instead of seperately creating web elemnet an d passing in select constructor
       Select selectMonth =new Select(driver.findElement(By.id("month")));
       Select selectDay = new Select(driver.findElement(By.id("day")));


        selectYear.selectByVisibleText("2012");
       selectMonth.selectByVisibleText("September"); // you need to pass month name // if you pass number you need to chhose selectByValue
        selectDay.selectByVisibleText("12");
        BrowserUtils.wait(4);

      // select all months one by one
        List<WebElement> months= selectMonth.getOptions();
        for(WebElement eachMonth : months) {
            // get the month name and select based on that
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Georgia");

        //option that is currently selected
        // getFirstSelectedOption()--> returns a webelement, so we need to call getText()
        //getText() retrieves visible text from the webElement
        String selected= stateSelect.getFirstSelectedOption().getText();
        if(selected.equals("Georgia")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        List<WebElement> states =stateSelect.getOptions();
        for(WebElement stateOption : states){
            System.out.println(stateOption.getText());// will print all states

        }


        BrowserUtils.wait(3);
        driver.quit();

    }
}
