package com.lambdatest.pages;

import org.openqa.selenium.By;

public class HomePage extends BaseClass{

    private By bootstrapProgressBar = By.linkText("Bootstrap Progress bar");
    public BootstrapProgressbarPage clickBootstrapProgressBar(){
        click(bootstrapProgressBar);
        return new BootstrapProgressbarPage();
    }
}
