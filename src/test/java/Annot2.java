import org.testng.annotations.*;

import java.sql.SQLOutput;


public class Annot2 {

    @BeforeClass
    public void beforeClass(){

        System.out.println(" (Test2) Before class Annot2");
    }

    @Test(groups = {"smoke", "regression"})
    public void tesT1Annot2(){

        System.out.println(" (Test2) Method Test2");


    }

    @Test
    public void tesT2Annot2(){

        System.out.println(" (Test2) Method Test2");

    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println(" (Test2) Before Method Annot2");

    }

    @AfterMethod
    public void aftereMethod(){
        System.out.println(" (Test2) After Method Annot2");

    }

    @AfterClass
    public void afterClass(){
        System.out.println(" (Test2) After class Annot2");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("(Test2) before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("(Test2) after test");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before SuiteMethod");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After SuiteMethod");
    }

    @BeforeGroups(groups = "smoke")
    public void beforeGrouping(){
        System.out.println("smoke test started");
    }


    @AfterGroups(groups = "smoke")
    public void afterGrouping(){
        System.out.println("smoke tests finished");
    }

}
