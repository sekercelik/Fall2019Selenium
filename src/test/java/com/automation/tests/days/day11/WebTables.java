package com.automation.tests.days.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }
    //*****************************************************************************************************

    @Test
    public void getColumnNames() {

        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement colmnName : columnNames) {
            System.out.println(colmnName.getText());

        }
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);

    }

    //*****************************************************************************************************
    @Test
    public void verifyRowCount() {
        //tbody//tr==> to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we get a size of this collection, it automatically equals to number of elements
        //expected==> 4 rows in the table
        Assert.assertEquals(rows.size(), 4);

    }
//*****************************************************************************************************

    /**
     * To get specific column, skip row index, and just provide td index
     */
    @Test
    public void getSpecificColumn() {
        //td[5] - column with links
        List<WebElement> websites = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(websites));


    }
//*****************************************************************************************************
    //table[1]//td[text()='fbach@yahoo.com’]//following-sibling::td/a[text()=‘delete’]
    //first way :
//once you find email cell in the first table that has this email (jdoe@hotmail.com) then go to following sibling has linkText delete :
//td element with email and td element that contains delete => are siblings
////td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']

//to make it easier :
//go back to parent and find link that has text delete
//td is child of tr
////td[text()='fbach@yahoo.com']/..//a[text()='delete']

//even more simple way :
//it is more hardcoded! but easiest => you provide index so it s not flexible, if index is change ilocator will never find it
//go to find email in the first table go to parent go to second link inside this element
////table[1]//td[text()='jsmith@gmail.com']/..//a[2]
//*****************************************************************************************************

    /**
     * TASK until 4:45
     * Go to tables example page
     * Delete record with jsmith@gmail.com email
     * verify that number of rows is equals to 3
     * verify that jsmith@gmail.com doesn't exists any more in the table
     */
    @Test
    public void deleteRowTest() {
        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();

        BrowserUtils.wait(3);

        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();

        Assert.assertEquals(rowCount, 3);

        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());

    }
//*****************************************************************************************************

    /**
     * Let's write a function that will return column index based on column name
     */
    @Test
    public void getColumnIndexByName() {
        String columnName = "Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {
            if (columnNames.get(i).getText().equals(columnName)) {
                index = i + 1;
            }
        }
        Assert.assertEquals(index, 3);
    }
//********************************************************************************************************

    //      @Test
//    public void getColumnIndexByName() {
//        String columnName = "Email";
//        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
//        int index = 0;
//        for (int i = 0; i < columnNames.size(); i++) {
//            String actualColumnName = columnNames.get(i).getText();
//            System.out.println(String.format("Column name: %s, position %s", actualColumnName, i));
//            if (actualColumnName.equals(columnName)) {
//                index = i + 1;
//                break;
//            }
//        }
//        Assert.assertEquals(index, 3);
//    }
    //*****************************************************************************************************
    @Test
    public void getSpecificCell() {
        String expected = "http://www.jdoe.com";
        int row = 3;
        int column = 5;
        String xpath = "//table[1]//tbody//tr[" + row + "]//td[" + column + "]";
        WebElement cell = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(cell.getText(), expected);
    }


//*****************************************************************************************************
// headless mode nedir, nasil yapiliyor?
/* @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it to tru to make it work
        chromeOptions.setHeadless(false);//to run browser without GUI. Makes browser invisible.
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }*/


    //*****************************************************************************************************
    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }


}
