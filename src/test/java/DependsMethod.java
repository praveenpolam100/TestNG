import com.lambdatest.pages.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsMethod extends BaseClass {



    @Test
    public static void getTitle(){
        String tiTle = driver.getTitle();

        Assert.assertEquals(tiTle, "Selenium Gri Online | Run Selenium Test On Cloud");


    }

    @Test(dependsOnMethods = "getTitle")
    public static void getalLinks_withoutNotation(){

        System.out.println("Function:  getalLinks_withoutNotation");
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);



    }

    @Test(dependsOnMethods = {"getTitle"}, alwaysRun = true)
    public static void getalLinks_withNotation(){

        System.out.println("Function: getalLinks_withNotation");
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);



    }





    }


