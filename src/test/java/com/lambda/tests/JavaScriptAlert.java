package com.lambda.tests;

import com.lambdatest.pages.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.Duration;

public class JavaScriptAlert extends BaseClass {

    @Test(priority = 1)
    public void javaScriptAlertpopupTest(){


        driver.findElement(By.linkText("Javascript Alerts")).click();
        WebElement button1 = driver.findElement(By.xpath("//button[@type='button'][contains(@class, 'my-30 mx-10')]"));
        button1.click();
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        }catch (Exception e){
            System.out.println(e.getMessage());

        }

   }

   @Test (priority = 2)
   public void javascriptAlertConfirmBox(){
       driver.findElement(By.linkText("Javascript Alerts")).click();
       WebElement button2 = driver.findElement(By.xpath("(//button[@type='button' and @class='btn btn-dark mx-10 hover:bg-lambda-900 hover:border-lambda-900'])[1]"));
       button2.click();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       wait.until(ExpectedConditions.alertIsPresent());
       try{
           driver.switchTo().alert().dismiss();
           WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
           wait1.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//p[@id='confirm-demo']")), "You pressed Cancel!"));
           String message = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
           softAssert.assertEquals(message, "You pressed Cancel!");
           softAssert.assertAll();

       }catch (Exception e){
           System.out.println(e.getMessage());
       }

   }

   @Test(priority = 3)
   public void javascriptAlertPromptBox(){
       driver.findElement(By.linkText("Javascript Alerts")).click();
       WebElement button3 = driver.findElement(By.xpath("(//button[@type='button' and @class='btn btn-dark mx-10 hover:bg-lambda-900 hover:border-lambda-900'])[2]"));
       button3.click();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       wait.until(ExpectedConditions.alertIsPresent());
       try{

           String alertMessage = driver.switchTo().alert().getText();
           driver.switchTo().alert().sendKeys("My name is Praveen");
           driver.switchTo().alert().accept();
           String enteredText = driver.findElement(By.id("prompt-demo")).getText();
           softAssert.assertTrue(enteredText.contains("My name is Praveen"), "Text was not showing correctly");
           softAssert.assertAll();

        }catch(Exception e){
           System.out.println(e.getMessage());
       }

   }

   @Test(priority = 4)
    public void bootstrapAlertautoHide(){
        driver.findElement(By.linkText("Bootstrap Alerts")).click();
        WebElement button1 = driver.findElement(By.xpath("//button[text()='Autoclosable Success Message']"));
       button1.click();
       WebElement bootstrapElement = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.textToBePresentInElement(bootstrapElement, "Autocloseable success message. Hide in 5 seconds."));
       long startTime = System.currentTimeMillis();
       String message = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]")).getText();
       wait.until(ExpectedConditions.invisibilityOf(bootstrapElement));
       long endTime = System.currentTimeMillis();

       System.out.println("Seconds: " +(endTime-startTime)/1000);


    }

@Test(priority = 5)
public void normalSuccessMessage(){
    driver.findElement(By.linkText("Bootstrap Alerts")).click();
    driver.findElement(By.xpath("//button[text()='Normal Success Message']")).click();
    WebElement webElementText = driver.findElement(By.xpath("(//div[contains(@class, 'alert-success alert')])[2]"));
    WebElement webElementClose = driver.findElement(By.xpath("(//div[contains(@class, 'alert-success alert')])[2]//a"));
    String message = webElementText.getText();
    softAssert.assertTrue(message.contains("Normal success message. To close use the close button."));
    softAssert.assertAll();
    webElementClose.click();

   }

}
