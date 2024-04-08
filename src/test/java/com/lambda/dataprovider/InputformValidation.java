package com.lambda.dataprovider;

import com.lambdatest.pages.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InputformValidation {

    private By linkTextinputFoem = By.linkText("Input Form Submit");


    @Test(dataProviderClass = DataProviderTest.class, dataProvider = "userTest-Data")
    public void dataProviderTest(String data1, String data2, String data3, String data4, String data5, String data6, String data7, String data8, String data9, String data10, String data11){

        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
        System.out.println(data4);
        System.out.println(data5);
        System.out.println(data6);
        System.out.println(data7);
        System.out.println(data8);
        System.out.println(data9);
        System.out.println(data10);
        System.out.println(data11);

    }





}
