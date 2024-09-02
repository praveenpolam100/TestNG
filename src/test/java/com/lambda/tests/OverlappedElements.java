package com.lambda.tests;

import com.lambdatest.pages.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OverlappedElements extends BaseClass {

    @Test
    public void openOverlappedElelemtScreen() throws InterruptedException {
        driver.findElement(By.linkText("Overlapped Element")).click();
        driver.findElement(By.xpath("//input[@id='id']")).sendKeys("12345");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        //JavascriptExecutor js = (JavascriptExecutor) driver;

       // WebElement webElement =  driver.findElement(By.xpath("//input[@id='name']"));

        driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("testing");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Praveen");

        System.out.println("all good");




    }
}
