package com.lambda.tests;

import com.lambdatest.pages.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Slider extends BaseClass {

    @Test
    public void selectDropdownList() {
        Map<Integer, String> week = new HashMap<>();
        week.put(1, "Monday");
        week.put(2, "Tuesday");
        week.put(3, "Wednesday");
        week.put(4, "Thursday");
        week.put(5, "Friday");
        week.put(6, "Saturday");
        week.put(7, "Sunday");

        LocalDateTime date = LocalDateTime.now();
        int day = date.getDayOfWeek().getValue();

        driver.findElement(By.linkText("Select Dropdown List")).click();
        WebElement webElementDropdown = driver.findElement(By.id("select-demo"));
        Select select = new Select(webElementDropdown);
        select.selectByVisibleText(week.get(day));
        System.out.println(week.get(day));


    }

    @Test
    public void dragandDrop() {
        driver.findElement(By.linkText("Drag and Drop")).click();
        WebElement source1 = driver.findElement(By.xpath("//div[@id='todrag']//span[text()='Draggable 1']"));
        WebElement source2 = driver.findElement(By.xpath("//div[@id='todrag']//span[text()='Draggable 2']"));
        WebElement destination = driver.findElement(By.id("mydropzone"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source1, destination);
        actions.perform();
        actions.dragAndDrop(source2, destination);
        actions.perform();


        WebElement source3 = driver.findElement(By.id("draggable"));
        WebElement destination3 = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source3, destination3);
        actions.perform();


    }

    @Test
    public void sliderDemo1() {
        driver.findElement(By.linkText("Drag & Drop Sliders")).click();
        WebElement slider = driver.findElement(By.xpath("//div[@class='sp__range']//input[@type='range']"));
        String defaultValue = driver.findElement(By.id("range")).getText();
        softAssert.assertEquals(defaultValue, "5");
        softAssert.assertAll();
        int slideNumber = 0;

        do {

            if (slideNumber < 50) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            } else if (slideNumber > 50) {
                slider.sendKeys(Keys.ARROW_LEFT);
            } else if (slideNumber == 50) {
                break;
            }

            slideNumber = Integer.parseInt(driver.findElement(By.id("range")).getText());


        } while (slideNumber != 50);


    }

    @Test
    public void sliderDemo2() {
        driver.findElement(By.linkText("Drag & Drop Sliders")).click();
        String defaultValue = driver.findElement(By.id("rangePrimary")).getText();
        softAssert.assertEquals(defaultValue, "20");
        softAssert.assertAll();
        WebElement slider = driver.findElement(By.xpath("//div[@class='sp__range sp__range-primary']//input[@type='range']"));
        int sliderValue = Integer.parseInt(defaultValue);

        while (sliderValue != 50) {

            if (sliderValue < 50) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
            sliderValue = Integer.parseInt(driver.findElement(By.id("rangePrimary")).getText());
            if (sliderValue == 50) {
                break;
            }
        }


    }


}
