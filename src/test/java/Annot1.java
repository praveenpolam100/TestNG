import org.testng.annotations.*;

@Test (groups = "smoke")
public class Annot1 {

    @BeforeClass
    public void beforeClass(){

        System.out.println(" (Test1) Before class Annot1");
    }

    public void tesT1Annot1(){

        System.out.println(" (Test1) Method Test1");

    }

    public void tesT2Annot1(){

        System.out.println(" (Test1) Method Test2");

    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println(" (Test1) Before Method Annot1");

    }

    @AfterMethod
    public void aftereMethod(){
        System.out.println(" (Test1) After Method Annot1");

    }

    @AfterClass
    public void afterClass(){
        System.out.println(" (Test1) After class Annot1");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("(Test1) before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("(Test1) after test");
    }

}
