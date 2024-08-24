package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.fragments.helpers.Helpers.waitForElementVisible;
import static com.course.selenium.fragments.helpers.Helpers.waitForPageLoaded;

public class MyAccountPage {

    By locatorAlertSuccess = By.cssSelector(".alert-success");

    @FindBy(css = ".myaccount-link-list a[title=Addresses]")
    private WebElement myAddressesButton;

    @FindBy(css = ".myaccount-link-list a[title='Add my first address']")
    private WebElement addMyAddressesButton;

    @FindBy(css= ".footer_links .button-small")
    private WebElement homeButton;

    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(driver, By.cssSelector(".myaccount-link-list a[title=Addresses]"), "my-account");
        PageFactory.initElements(driver, this);
    }
    public String getSuccessMessage() {
        WebElement alert = waitForElementVisible(driver, locatorAlertSuccess);
        return alert.getText().strip();
    }

    public String getLoggedUsername() {
        WebElement userName = driver.findElement(By.xpath("//a[@class='account']"));
        return userName.getText();
    }

    public void clickHome() {
        homeButton.click();
    }
}
