import com.google.common.base.Function;
import com.lambdatest.pages.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Progressbar extends BaseClass {

    @Test
    public void jqueryDownloadProgressbar(){

        driver.findElement(By.linkText("JQuery Download Progress bars")).click();
        driver.findElement(By.id("downloadButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By progressbar = By.xpath("//div[@class='progress-label']");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(progressbar, "Complete!"));
        String elementText = driver.findElement(By.xpath("//div[@class='progress-label']")).getText();
        Assert.assertEquals("Complete!", elementText);

    }

    @Test
    public void dynamicDataloading(){
        driver.findElement(By.linkText("Dynamic Data Loading")).click();
        driver.findElement(By.id("save")).click();
        By image = By.xpath("//div[@id='loading']//img");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));
        //driver.findElement(image).isDisplayed();
        Assert.assertTrue(driver.findElement(image).isDisplayed(), "Image is not displayed in AUT");

    }

    @Test
    public void jqueryDownloadProgressbarFluentWait(){
        driver.findElement(By.linkText("JQuery Download Progress bars")).click();
        driver.findElement(By.id("downloadButton")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement progressbarText = driver.findElement(By.xpath("//div[@id='dialog']//div[@class='progress-label']"));

                if(progressbarText.getText().equals("Complete!")){
                    System.out.println("Progress is completed");
                    return progressbarText;
                }else{
                    System.out.println(progressbarText.getText());
                    return null;
                }

            }
        });

    }

}
