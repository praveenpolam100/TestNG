import com.lambdatest.pages.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AssertionTest extends BaseClass {

    @Test(priority = 1)
    public void testSingleRadiobutton() {
        driver.findElement(By.linkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath("//input[@value='Male' and @name='gender']"))
                .click();
        driver.findElement(By.xpath("//input[@value='5 - 15']")).click();
        driver.findElement(By.xpath("//button[text()='Get values']")).click();
        String genderDisplayed = driver.findElement(By.className("genderbutton")).getText();
        String ageSelected = driver.findElement(By.className("groupradiobutton")).getText();
        //String ageSelected =driver.findElement(By.cssSelector(".groupradiobutton")).getText();
        softAssert.assertTrue(genderDisplayed.equals("Male"));
        softAssert.assertTrue(ageSelected.equals("5 - 15"));
        softAssert.assertAll();

    }

    @Test(priority = 2)
    public void testingSingleCheckbox(){

        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.id("isAgeSelected")).click();
        String message = driver.findElement(By.id("txtAge")).getText();
        Assert.assertTrue(message.equals("Checked"));

    }

    @Test(priority = 3)
    public void testingDisabledcheckboxDemo(){
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.xpath("(//input[@class='mr-10'])[2]")).click();
        driver.findElement(By.xpath("(//input[@class='mr-10'])[3]")).click();

        softAssert.assertTrue(
        driver.findElement(By.xpath("(//input[@class='mr-10'])[2]")).isSelected());
        softAssert.assertTrue(
                driver.findElement(By.xpath("(//input[@class='mr-10'])[3]")).isSelected());

        boolean option3 =  driver.findElement(By.xpath("(//input[@class='mr-10'])[4]")).isEnabled();
        boolean option4 =  driver.findElement(By.xpath("(//input[@class='mr-10'])[5]")).isEnabled();

        if (option3){
            driver.findElement(By.xpath("(//input[@class='mr-10'])[4]")).click();
            softAssert.assertTrue(
                    driver.findElement(By.xpath("(//input[@class='mr-10'])[4]")).isSelected());

        }else{
            softAssert.assertFalse(
                    driver.findElement(By.xpath("(//input[@class='mr-10'])[4]")).isSelected());
        }

        if (option4){
            driver.findElement(By.xpath("(//input[@class='mr-10'])[5]")).click();
            softAssert.assertTrue(
                    driver.findElement(By.xpath("(//input[@class='mr-10'])[5]")).isSelected());

        }else {
            softAssert.assertFalse(
                    driver.findElement(By.xpath("(//input[@class='mr-10'])[5]")).isSelected());
        }

    }

    @Test(priority = 4)
    public void multipleCheckboxDemo(){
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.xpath("//input[@id='box'][@value='Check All']")).click();
       List<WebElement> checkBoxes =  driver.findElements(By.xpath
                ("//div[@class='w-full rigth-input flex items-center justify-between smtablet:block']//div//input[@type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
            softAssert.assertTrue(checkBox.isSelected(), "checkbox not selected");

        }
        driver.findElement(By.xpath("//input[@id='box'][@value='Uncheck All']")).click();

        for (WebElement checkBox : checkBoxes) {
            softAssert.assertFalse(checkBox.isSelected(), "Not all checkboxes unselected");

        }
        softAssert.assertAll();

    }

    @Test(priority = 5)
    public void simpleformDemo(){

        driver.findElement(By.linkText("Simple Form Demo")).click();
        driver.findElement(By.id("user-message")).sendKeys("Doing Testing under Lambda Website.");
        driver.findElement(By.id("showInput")).click();
        String message = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(message, "Doing Testing under Lambda Website.");


        //compare sum of two input values
        driver.findElement(By.id("sum1")).sendKeys("50");
        driver.findElement(By.id("sum2")).sendKeys("50");
        driver.findElement(By.cssSelector("form#gettotal>button")).click();
        String totalValue = driver.findElement(By.id("addmessage")).getText();
        Assert.assertEquals(totalValue, "100");

    }
}
