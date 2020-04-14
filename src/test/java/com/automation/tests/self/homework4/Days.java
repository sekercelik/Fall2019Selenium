package com.automation.tests.self.homework4;


import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Days {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

//***************************************************************************************************************
    @Test(description = "test 1")
    public void days() {
       // WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

      //  BrowserUtils.wait(1);

        List<WebElement> daysBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        //List<WebElement> daysBox = driver.findElements(By.cssSelector(".gwt-CheckBox>input"));

        List<WebElement> dayNames = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
       // List<WebElement> dayNames = driver.findElements(By.cssSelector(".gwt-CheckBox>label"));
        // . is class, > is child

        Random randomly = new Random();
        // if we know only exit condition we need to use while loop
        // if we don't know how many times it is going to loop, it is unexpected
        // for loop ==> we know how many..

        int count = 0;
        while (count < 3) {

            int x = randomly.nextInt(dayNames.size());   // 0 is included, last is not

            if (daysBox.get(x).isEnabled()) {
                daysBox.get(x).click();

                System.out.println(dayNames.get(x).getText());

                if (dayNames.get(x).getText().equalsIgnoreCase("friday")) {
                    count++;
                }
                daysBox.get(x).click();
            }
        }

     //   driver.quit();

    }

//****************************************************************************************************************





 //***************************************************************************************************************
    @Test(description = "Test 2")
    public void todaysDate() {

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select yearCurrent = new Select(driver.findElement(By.id("year")));
        Select monthCurrent = new Select(driver.findElement(By.id("month")));
        Select dayCurrent = new Select(driver.findElement(By.id("day")));

        String last = yearCurrent.getFirstSelectedOption().getText() + " "
                     + monthCurrent.getFirstSelectedOption().getText() + " "
                     + dayCurrent.getFirstSelectedOption().getText();

        System.out.println(last);

        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy MMMM dd"));
        System.out.println(currentDate);

        Assert.assertTrue(last.equals(currentDate));

        // another solution
        // SimpleDateFormat sf = new SimpleDateFormat("yyyy MMMM dd");
        // Assert.assertEquals(last, sf.format(new Date()));

        driver.quit();


    }
//***************************************************************************************************************

    @Test(description = "Test 3")
    public void yearsMonthsDays(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select yearCurrent = new Select(driver.findElement(By.id("year")));
        Select monthCurrent = new Select(driver.findElement(By.id("month")));
        Select dayCurrent = new Select(driver.findElement(By.id("day")));

        Random r=new Random();
        int index= r.nextInt(yearCurrent.getOptions().size());
        yearCurrent.selectByIndex(index);

//        WebElement monthBox =driver.findElement(By.id("'month"));
//        String monthNames= monthBox.getText();

        List<String> months31 = new ArrayList<>(Arrays.asList(new String[]
                {"January", "March", "May", "July", "August", "October", "December"}));
        int febDays;
        int yearValue = Integer.parseInt(yearCurrent.getFirstSelectedOption().getText());
        if(yearValue %400==0 || (yearValue%4 ==0 && yearValue %100!=0)){
            febDays=29;
        }else{
            febDays=28;
        }
        for(int i =0; i<12; i++){
            monthCurrent.selectByIndex(i);
            if(months31.contains(monthCurrent.getFirstSelectedOption().getText())){
                Assert.assertEquals(dayCurrent.getOptions().size(), 31);
            }else if(monthCurrent.getFirstSelectedOption().getText().equals("February")){
                Assert.assertEquals(dayCurrent.getOptions().size(), febDays);
            }else{
                Assert.assertEquals(dayCurrent.getOptions().size(), 30);
            }
        }
    }

    //is leapyear..local date time a bak// is leap year a nasil bakiliyor bak..
//******************************************************************************************************************
    @Test(description = "Test 3")
    public void yearsMonthsDaysNew() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select yearCurrent = new Select(driver.findElement(By.id("year")));
        List<WebElement> years =yearCurrent.getOptions();

        Random r=new Random();
        int randomNumber=r.nextInt(years.size());

        String selectedYear=years.get(randomNumber).getText();
        yearCurrent.selectByVisibleText(selectedYear);

        Select monthCurrent = new Select(driver.findElement(By.id("month")));




        Select dayCurrent = new Select(driver.findElement(By.id("day")));





    }

//******************************************************************************************************************

    @Test (description = "Test 4")
    public void departmentsSort(){
        driver.get("https://www.amazon.com");
        Assert.assertEquals(driver.findElement(By.className("nav-search-label")).getText(), "All");

        List<WebElement> l1 = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();
        boolean notAlphabetOrder = false;

        for(int i =0; i<l1.size()-1; i++){
            if(l1.get(i).getText().compareTo(l1.get(i+1).getText())>0){
                notAlphabetOrder =true;
                break;
            }

        }
        Assert.assertTrue(notAlphabetOrder);
    }

//***************************************************************************************************************

    @Test (description = "Test 5")
    public void mainDepartments(){
        driver.get("https://www.amazon.com/gp/site-directory");

        List<WebElement> mainDep = driver.findElements(By.tagName("h2"));
        List<WebElement> allDep = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();

        Set<String> mainDepS = new HashSet<>();
        Set<String> allDepS = new HashSet<>();

        for( WebElement each : mainDep){
            mainDepS.add(each.getText());
        }
        for( WebElement each : allDep){
            allDepS.add(each.getText());
        }
        for(String each : mainDepS){
            if(!allDepS.contains(each)){
                System.out.println(each);
                System.out.println("This main dep is not in All departments list");
            }
        }
        Assert.assertTrue(allDep.containsAll(mainDepS));
    }


//***************************************************************************************************************

    @Test(description = "Test6")
    public void links() {

        driver.get("https://www.w3schools.com/");

        List<WebElement> allElements = driver.findElements(By.tagName("a"));
         System.out.println(allElements.size());

        for (WebElement each : allElements) {
            if (each.isDisplayed()) {
                System.out.println(each.getText() + " " + each.getAttribute("href"));
            }
        }

    }


//***************************************************************************************************************

    @Test(description = "Test 7")
    public void validLinks() {

        driver.get("https://www.selenium.dev/documentation/en/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("total number of links: " + links.size());
        for(int i=0; i<links.size(); i++){
            String href = links.get(i).getAttribute("href");
            try {
                URL url = new URL(href);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.connect();
                Assert.assertEquals(httpURLConnection.getResponseCode(), 200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//***************************************************************************************************************

    @Test(description = "Test 8")
    public void cart() {

        driver.get("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/following-sibling::input")).click();

        List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price']/span[@class='a-offscreen']"));
        int x = new Random().nextInt(price.size());
        x = x==0?1:x;

        String originName = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])["+x+"]")).getText();
        String originPrice = "$" +
                driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[2])["+x+"]")).getText() +"."+
                driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[3])["+x+"]")).getText();

        driver.findElement(By.xpath("(//span[@class='a-price-fraction'])["+x+"]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Qty:']/following-sibling::span")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.id("productTitle")).getText(), originName);
        Assert.assertEquals(driver.findElement(By.id("price_inside_buybox")).getText(), originPrice);
        Assert.assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());
    }

//***************************************************************************************************************

    @Test(description = "Test 9")
    public void prime(){
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/following-sibling::input")).click();
        WebElement firstPrimeName =driver.findElement(By.xpath("(//i[@aria-label='Amazon Prime']/../../../../../..//h2)[1]"));
        String name1 = firstPrimeName.getText();
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-prime a-icon-medium']/../div/label/i")).click();
        String name2 = driver.findElement(By.xpath("(//i[@aria-label='Amazon Prime']/../../../../../..//h2)[1]")).getText();
        Assert.assertEquals(name2, name1);
        driver.findElement(By.xpath("//div[@id='brandsRefinements']//ul/li[last()]//i")).click();
        String name3 = driver.findElement(By.xpath("(//i[@aria-label='Amazon Prime']/../../../../../..//h2)[1]")).getText();
        Assert.assertNotEquals(name1, name3);
    }



 //***************************************************************************************************************

    @Test(description = "Test 10")
    public void more_spoons(){
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoons");
        driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/following-sibling::input")).click();
        List<WebElement> l1 = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a/span"));
        List<String > s1 = new ArrayList<>();
        for(WebElement each : l1){
            s1.add(each.getText());
        }
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-prime a-icon-medium']/../div/label/i")).click();
        List<WebElement> l2 = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a/span"));
        List<String > s2 = new ArrayList<>();
        for(WebElement each : l2){
            s2.add(each.getText());
        }
        Assert.assertEquals(s1,s2);
    }


//***************************************************************************************************************

    @Test(description = "Test 11")
    public void cheap_spoons(){
        // NO Price option on amazon website on the left after search
    }


}
