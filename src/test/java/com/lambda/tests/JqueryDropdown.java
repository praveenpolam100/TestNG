package com.lambda.tests;

import com.lambdatest.pages.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class JqueryDropdown extends BaseClass {

    @Test(priority = 0)
    public void selectvalue_jQuerydropdown() {
        driver.findElement(By.linkText("JQuery Select dropdown")).click();
        WebElement countryDropdown = driver.findElement(By.id("country"));
        Select select = new Select(countryDropdown);
        List<WebElement> countries = select.getOptions();
        for (WebElement country : countries) {
            System.out.println(country.getText());
            if (country.getText().equals("United States of America")) {
                select.selectByVisibleText("United States of America");
                break;
            }
        }
    }

    @Test (priority = 1)
        public void multiSelectDropdown(){

        driver.findElement(By.linkText("JQuery Select dropdown")).click();
        WebElement multiselwebElement = driver.findElement(By.cssSelector("[class = 'js-example-basic-multiple pl-10 select2-hidden-accessible']"));
        Select select = new Select(multiselwebElement);
        List <WebElement> webElements = select.getOptions();
        select.selectByValue("AZ");
        select.selectByVisibleText("California");

        for (WebElement element: webElements){

            System.out.println(element.getText());

        }


    }

    @Test (priority = 2)
    public void selectCountrydropdown(){
        driver.findElement(By.linkText("JQuery Select dropdown")).click();
        WebElement webElement = driver.findElement(By.cssSelector("[class='js-example-disabled-results select2-hidden-accessible']"));

        Select select = new Select(webElement);
        List <WebElement> webElements = select.getOptions();
        Boolean defaultIndex = false;
       for (int i=0; i<webElements.size(); i++ ){

           if (webElements.get(i).getText().contains("Guam")){
               if (webElements.get(i).isEnabled()){
                   select.selectByIndex(i);
                   defaultIndex = true;
                   break;

               }

           }
       }
       //if the item is disabled, then the default item would be PR
        if (defaultIndex){
            select.selectByValue("PR");
        }

    }

    @Test(priority = 3)
    public void selectfileunderGroup(){
        driver.findElement(By.linkText("JQuery Select dropdown")).click();
        WebElement element = driver.findElement(By.id("files"));
        Select select = new Select(element);
        List <WebElement> options = select.getOptions();
        System.out.println(options.size());
        for (WebElement option :options){
            System.out.println(option.getText());
        }



    }


}
