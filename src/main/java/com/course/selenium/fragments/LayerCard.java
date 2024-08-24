package com.course.selenium.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.fragments.helpers.Helpers.waitForElementVisible;
import static com.course.selenium.fragments.helpers.Helpers.waitForPageLoaded;

public class LayerCard {

    @FindBy(css = "#layer_cart .button-medium")
    private WebElement proceedToCheckOut;

    private WebDriver driver;

    public LayerCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector("#layer_cart .button-medium") ,"coderslab.pl");
    }

    public void clickProceedToCheckOut(){
        proceedToCheckOut.click();
    }

}
