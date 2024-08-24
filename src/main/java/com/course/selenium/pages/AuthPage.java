package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.fragments.helpers.Helpers.waitForElementVisible;
import static com.course.selenium.fragments.helpers.Helpers.waitForPageLoaded;


public class AuthPage {

    private WebDriver driver;

    @FindBy(id="email_create")
    WebElement createAccountEmailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "create_account_error")
    private WebElement createAccountAlert;

    @FindBy(css = "#email")
    WebElement emailSignInput;

    @FindBy(css = "#passwd")
    WebElement passwdSignInput;

    @FindBy(css = "#SubmitLogin")
    WebElement submitSignButton;



    public AuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector("#email_create") ,"my-account");

    }

    public void typeEmailIntoCreateAccount(String email){
        createAccountEmailInput.sendKeys(email);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public boolean isErrorMessageShown() {
        return createAccountAlert.isDisplayed();
    }

    public String getErrorMessage() {
        waitForElementVisible(driver,createAccountAlert);
        return createAccountAlert.getText();
    }

    public void typeEmailIntoLogin(String mail) {
        emailSignInput.clear();
        emailSignInput.sendKeys(mail);
    }
    public void typePasswordIntoLogin(String password) {
        passwdSignInput.clear();
        passwdSignInput.sendKeys(password);
    }

    public void clickSingInButton() {
        submitSignButton.click();
    }
}
