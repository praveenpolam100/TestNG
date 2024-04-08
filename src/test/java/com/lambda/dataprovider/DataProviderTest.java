package com.lambda.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "userTest-Data")
    public static Object[][] dataProvider(){

        Object [][] data = new Object[2][11];

        data[0][0] = "Praveen";
        data[0][1] = "Praveen@test.com";
        data[0][2] = "password";
        data[0][3] = "company";
        data[0][4] = "www.website.com";
        data[0][5] = "United States";
        data[0][6] = "Frisco";
        data[0][7] = "Address1";
        data[0][8] = "Address2";
        data[0][9] = "Texas";
        data[0][10] = "75035";

        data[1][0] = "Prashanth";
        data[1][1] = "Prashanth@test.com";
        data[1][2] = "password";
        data[1][3] = "company";
        data[1][4] = "www.website.com";
        data[1][5] = "United States";
        data[1][6] = "Frisco";
        data[1][7] = "Address1";
        data[1][8] = "Address2";
        data[1][9] = "Texas";
        data[1][10] = "75035";

        return data;
    }

/*    @Test(dataProvider = "userTest-Data")
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

    }*/

}
