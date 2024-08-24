package com.course.selenium.pages.lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.course.selenium.fragments.helpers.Helpers.waitForElementVisible;
import static com.course.selenium.fragments.helpers.Helpers.waitForPageLoaded;

public class AccountInfo {

    private final WebDriver driver;

    public AccountInfo(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(driver, By.xpath("//a[@class='account']"),"/index.php");
    }

    public String getLoggedUsername() {
        WebElement userName = driver.findElement(By.xpath("//a[@class='account']"));
        return userName.getText();
    }
}