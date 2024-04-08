package com.lambdatest.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.UINT16;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BootstrapProgressbarPage extends BaseClass {

    private By startdownlodButton = By.id("dwnBtn");
    private By counterPercent = By.cssSelector(".counter");
    private By downloadConformationText = By.xpath("//p[contains(@class,'success text-green-100')]");




    public void clickDownloadButton(){
        click(startdownlodButton);
    }

    public String getProgressbarPercentage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(counterPercent, "100%"));
        String progressText = getText(counterPercent);
        System.out.println(progressText);
        return progressText;

    }

    public String getDownloadconfirmationCheckMessage(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(downloadConformationText));

        String actualMessage = getText(downloadConformationText);
        return actualMessage;

    }

}
