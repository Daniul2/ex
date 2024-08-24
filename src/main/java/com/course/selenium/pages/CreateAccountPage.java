package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.fragments.helpers.Helpers.waitForPageLoaded;

public class CreateAccountPage {

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector("#customer_firstname"), "#account-creation");
    }

    public void typeFirstName(String name) {
        firstNameInput.clear();
        firstNameInput.sendKeys(name);
    }

    public void typeLastName(String surname) {
        lastNameInput.clear();
        lastNameInput.sendKeys(surname);
    }

    public void typePassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();

    }
}
