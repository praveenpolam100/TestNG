package com.lambdatest.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static  SoftAssert softAssert;


    @BeforeTest
    public static void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterTest
    public static void tearDown(){
        driver.quit();
    }

    @Parameters({"URL"})
    @BeforeMethod
    public static void getURL(String url){
        driver.get(url);
    }

    @BeforeTest
    public static void getSoftAsset(){
        softAssert = new SoftAssert();

    }

  @AfterMethod
  public void takeScreenshot(ITestResult testResult) throws IOException {

        if(ITestResult.FAILURE == testResult.getStatus()){

            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            Date date = new Date(System.currentTimeMillis());
            long timeStamp = date.getTime();
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/screenshots" +testResult.getName()+".png");
            FileHandler.copy(source, destination);

        }


    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void click(By locator){
        find(locator).click();
    }

    protected String getText(By locator){
        return find(locator).getText();
    }


}
