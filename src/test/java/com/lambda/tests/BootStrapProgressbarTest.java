package com.lambda.tests;

import com.lambdatest.pages.BaseClass;
import com.lambdatest.pages.BootstrapProgressbarPage;
import com.lambdatest.pages.HomePage;
import org.testng.annotations.Test;

public class BootStrapProgressbarTest extends BaseClass {

HomePage homePage;
BootstrapProgressbarPage bootstrapProgressbarPage;

@Test
public void clickBootstraplink(){

    homePage = new HomePage();
    bootstrapProgressbarPage = homePage.clickBootstrapProgressBar();
    bootstrapProgressbarPage.clickDownloadButton();
    String percentage = bootstrapProgressbarPage.getProgressbarPercentage();
    softAssert.assertTrue(percentage.equals("100%"), "Progress bar not showing 100%");
    String downloadconfirmationCheckMessage = bootstrapProgressbarPage.getDownloadconfirmationCheckMessage();
    softAssert.assertEquals(downloadconfirmationCheckMessage, "Download completed!");
    softAssert.assertAll();

}
}
