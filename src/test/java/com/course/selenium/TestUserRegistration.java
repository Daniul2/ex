package com.course.selenium;

import com.course.selenium.pages.AuthPage;
import com.course.selenium.pages.CreateAccountPage;
import com.course.selenium.pages.HomePage;
import com.course.selenium.pages.MyAccountPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.course.selenium.fragments.helpers.Helpers.getRandomEmail;

public class TestUserRegistration {
    private static WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void shouldRegisterNewUserAccount() {
        HomePage homePage =  new HomePage(driver);
        homePage.clickSingIn();

        AuthPage authPage = new AuthPage(driver);
        authPage.typeEmailIntoCreateAccount(getRandomEmail());
        authPage.clickCreateAccountButton();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.typeFirstName("John");
        createAccountPage.typeLastName("Doe");
        createAccountPage.typePassword("s3cret");
        createAccountPage.clickRegisterButton();

        MyAccountPage myAccountPage = new MyAccountPage(driver);

        Assert.assertEquals("Your account has been created.", myAccountPage.getSuccessMessage());

    }

    @Test
    public void shouldDisplaysError() throws InterruptedException {
        HomePage homePage =  new HomePage(driver);
        homePage.clickSingIn();

        AuthPage authPage = new AuthPage(driver);
        authPage.typeEmailIntoCreateAccount("foo@bar.com");
        authPage.clickCreateAccountButton();

        Assert.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.",
                authPage.getErrorMessage());
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
